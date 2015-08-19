/**
 * Copyright Microsoft Corporation
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.microsoft.azure.utility;

import com.microsoft.azure.management.storage.StorageManagementClient;
import com.microsoft.azure.management.storage.models.AccountType;
import com.microsoft.azure.management.storage.models.StorageAccount;
import com.microsoft.azure.management.storage.models.StorageAccountCreateParameters;
import com.microsoft.azure.management.storage.models.StorageAccountCreateResponse;
import com.microsoft.windowsazure.core.OperationStatus;
import com.microsoft.windowsazure.core.OperationResponse;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.util.List;

public class StorageHelper {
    /**
     * Create a storage account based on the input parameters.  Call blocks until 
     * either the storage account is created or an error occurs.  Default values 
     * for the storage account create parameters are provided.
     *
     * @param storageManagementClient       the storage management client object on which operations are performed
     * @param context                       information necessary for creating the storage account
     * @return StorageAccount               the storage account created, null if operation failed     
     * @throws Exception                    in the advent of a problem, the exception is thrown
     */
    public static StorageAccount createStorageAccount(
            StorageManagementClient storageManagementClient, ResourceContext context)
            throws Exception {
        //create storage account
        StorageAccountCreateParameters stoInput = new StorageAccountCreateParameters(AccountType.STANDARDGRS,
                context.getLocation());
        return createStorageAccount(storageManagementClient, context, stoInput);
    }

    /**
     * Create a storage account based on the input parameters.  Call blocks until 
     * either the storage account is created or an error occurs.
     *
     * @param storageManagementClient       the storage management client object on which operations are performed
     * @param context                       information necessary for creating the storage account
     * @param stoInput                      storage account specific parameters
     * @return StorageAccount               the storage account created, null if operation failed     
     * @throws Exception                    in the advent of a problem, the exception is thrown
     */
    public static StorageAccount createStorageAccount(
            StorageManagementClient storageManagementClient, ResourceContext context,
            StorageAccountCreateParameters stoInput) throws Exception {
            
        String storageAccountName = context.getStorageAccountName();
        StorageAccount storageAccount = null;
        
        ExecutorService service = null;
		try {
		    Future <StorageAccountCreateResponse> future = null;
            service = Executors.newFixedThreadPool(1);            
            future = storageManagementClient.getStorageAccountsOperations()
                                .createAsync(context.getResourceGroupName(),
                                             storageAccountName, stoInput);
            StorageAccountCreateResponse response = future.get();
            
            if(response.getStatus() == OperationStatus.SUCCEEDED) {
                storageAccount = response.getStorageAccount();
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            service.shutdown();
        }
        
        return storageAccount;
    }
        
    /**
     * Retrieve a storage account by name.
     *
     * @param storageManagementClient       the storage management client object on which operations are performed
     * @param context                       information necessary for creating the storage account
     * @return StorageAccount               the storage account requested, null if not found
     * @throws Exception                    in the advent of a problem, the exception is thrown
     */
    public static StorageAccount getStorageAccount(
            StorageManagementClient storageManagementClient,
            ResourceContext context) throws Exception {
        StorageAccount result = null;
        String storageAccountName = context.getStorageAccountName();

        List<StorageAccount> storageAccountList = storageManagementClient.getStorageAccountsOperations()
                    .listByResourceGroup(context.getResourceGroupName()).getStorageAccounts();
        for (StorageAccount account : storageAccountList) {
            if (account.getName().equalsIgnoreCase(storageAccountName)) {
                result = account;
                break;
            }
        }
                    
        return result;
    }
    
    /**
     * Create a storage account based on the input parameters.  Call blocks until 
     * either the storage account is created or an error occurs.
     *
     * @param storageManagementClient       the storage management client object on which operations are performed
     * @param context                       information necessary for creating the storage account
     * @param stoInput                      storage account specific parameters
     * @return StorageAccount               the storage account created, null if operation failed     
     * @throws Exception                    in the advent of a problem, the exception is thrown
     */
    public static boolean deleteStorageAccount(
            StorageManagementClient storageManagementClient, ResourceContext context) throws Exception {
            
        String storageAccountName = context.getStorageAccountName();
        boolean result = false;
        
        ExecutorService service = null;
		try {
		    Future <OperationResponse> future = null;
            service = Executors.newFixedThreadPool(1);            
            future = storageManagementClient.getStorageAccountsOperations()
                                .deleteAsync(context.getResourceGroupName(),
                                             storageAccountName);
            OperationResponse response = future.get();
            
            if(response.getStatusCode() / 100 == 2) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            service.shutdown();
        }
        
        return result;
    }    
}
