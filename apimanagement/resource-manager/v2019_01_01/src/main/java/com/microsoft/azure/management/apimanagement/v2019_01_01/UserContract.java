/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.v2019_01_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.apimanagement.v2019_01_01.implementation.UserContractInner;
import com.microsoft.azure.arm.model.Indexable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.apimanagement.v2019_01_01.implementation.ApiManagementManager;
import java.util.List;
import com.microsoft.azure.management.apimanagement.v2019_01_01.implementation.UserIdentityContractInner;
import org.joda.time.DateTime;

/**
 * Type representing UserContract.
 */
public interface UserContract extends HasInner<UserContractInner>, Indexable, Updatable<UserContract.Update>, HasManager<ApiManagementManager> {
    /**
     * @return the email value.
     */
    String email();

    /**
     * @return the firstName value.
     */
    String firstName();

    /**
     * @return the groups value.
     */
    List<GroupContractProperties> groups();

    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the identities value.
     */
    List<UserIdentityContract> identities();

    /**
     * @return the lastName value.
     */
    String lastName();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the note value.
     */
    String note();

    /**
     * @return the registrationDate value.
     */
    DateTime registrationDate();

    /**
     * @return the state value.
     */
    UserState state();

    /**
     * @return the type value.
     */
    String type();

    /**
     * The entirety of the UserContract definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithResourceGroupName, DefinitionStages.WithServiceName, DefinitionStages.WithIfMatch, DefinitionStages.WithEmail, DefinitionStages.WithFirstName, DefinitionStages.WithLastName, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of UserContract definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a UserContract definition.
         */
        interface Blank extends WithResourceGroupName {
        }

        /**
         * The stage of the usercontract definition allowing to specify ResourceGroupName.
         */
        interface WithResourceGroupName {
           /**
            * Specifies resourceGroupName.
            * @param resourceGroupName The name of the resource group
            * @return the next definition stage
            */
            WithServiceName withResourceGroupName(String resourceGroupName);
        }

        /**
         * The stage of the usercontract definition allowing to specify ServiceName.
         */
        interface WithServiceName {
           /**
            * Specifies serviceName.
            * @param serviceName The name of the API Management service
            * @return the next definition stage
            */
            WithIfMatch withServiceName(String serviceName);
        }

        /**
         * The stage of the usercontract definition allowing to specify IfMatch.
         */
        interface WithIfMatch {
           /**
            * Specifies ifMatch.
            * @param ifMatch ETag of the Entity. Not required when creating an entity, but required when updating an entity
            * @return the next definition stage
            */
            WithEmail withIfMatch(String ifMatch);
        }

        /**
         * The stage of the usercontract definition allowing to specify Email.
         */
        interface WithEmail {
           /**
            * Specifies email.
            * @param email Email address. Must not be empty and must be unique within the service instance
            * @return the next definition stage
            */
            WithFirstName withEmail(String email);
        }

        /**
         * The stage of the usercontract definition allowing to specify FirstName.
         */
        interface WithFirstName {
           /**
            * Specifies firstName.
            * @param firstName First name
            * @return the next definition stage
            */
            WithLastName withFirstName(String firstName);
        }

        /**
         * The stage of the usercontract definition allowing to specify LastName.
         */
        interface WithLastName {
           /**
            * Specifies lastName.
            * @param lastName Last name
            * @return the next definition stage
            */
            WithCreate withLastName(String lastName);
        }

        /**
         * The stage of the usercontract definition allowing to specify Confirmation.
         */
        interface WithConfirmation {
            /**
             * Specifies confirmation.
             * @param confirmation Determines the type of confirmation e-mail that will be sent to the newly created user. Possible values include: 'signup', 'invite'
             * @return the next definition stage
             */
            WithCreate withConfirmation(Confirmation confirmation);
        }

        /**
         * The stage of the usercontract definition allowing to specify Identities.
         */
        interface WithIdentities {
            /**
             * Specifies identities.
             * @param identities Collection of user identities
             * @return the next definition stage
             */
            WithCreate withIdentities(List<UserIdentityContractInner> identities);
        }

        /**
         * The stage of the usercontract definition allowing to specify Note.
         */
        interface WithNote {
            /**
             * Specifies note.
             * @param note Optional note about a user set by the administrator
             * @return the next definition stage
             */
            WithCreate withNote(String note);
        }

        /**
         * The stage of the usercontract definition allowing to specify Password.
         */
        interface WithPassword {
            /**
             * Specifies password.
             * @param password User Password. If no value is provided, a default password is generated
             * @return the next definition stage
             */
            WithCreate withPassword(String password);
        }

        /**
         * The stage of the usercontract definition allowing to specify State.
         */
        interface WithState {
            /**
             * Specifies state.
             * @param state Account state. Specifies whether the user is active or not. Blocked users are unable to sign into the developer portal or call any APIs of subscribed products. Default state is Active. Possible values include: 'active', 'blocked', 'pending', 'deleted'
             * @return the next definition stage
             */
            WithCreate withState(UserState state);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<UserContract>, DefinitionStages.WithConfirmation, DefinitionStages.WithIdentities, DefinitionStages.WithNote, DefinitionStages.WithPassword, DefinitionStages.WithState {
        }
    }
    /**
     * The template for a UserContract update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<UserContract>, UpdateStages.WithIfMatch, UpdateStages.WithConfirmation, UpdateStages.WithIdentities, UpdateStages.WithNote, UpdateStages.WithPassword, UpdateStages.WithState {
    }

    /**
     * Grouping of UserContract update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the usercontract update allowing to specify IfMatch.
         */
        interface WithIfMatch {
            /**
             * Specifies ifMatch.
             * @param ifMatch ETag of the Entity. Not required when creating an entity, but required when updating an entity
             * @return the next update stage
             */
            Update withIfMatch(String ifMatch);
        }

        /**
         * The stage of the usercontract update allowing to specify Confirmation.
         */
        interface WithConfirmation {
            /**
             * Specifies confirmation.
             * @param confirmation Determines the type of confirmation e-mail that will be sent to the newly created user. Possible values include: 'signup', 'invite'
             * @return the next update stage
             */
            Update withConfirmation(Confirmation confirmation);
        }

        /**
         * The stage of the usercontract update allowing to specify Identities.
         */
        interface WithIdentities {
            /**
             * Specifies identities.
             * @param identities Collection of user identities
             * @return the next update stage
             */
            Update withIdentities(List<UserIdentityContractInner> identities);
        }

        /**
         * The stage of the usercontract update allowing to specify Note.
         */
        interface WithNote {
            /**
             * Specifies note.
             * @param note Optional note about a user set by the administrator
             * @return the next update stage
             */
            Update withNote(String note);
        }

        /**
         * The stage of the usercontract update allowing to specify Password.
         */
        interface WithPassword {
            /**
             * Specifies password.
             * @param password User Password. If no value is provided, a default password is generated
             * @return the next update stage
             */
            Update withPassword(String password);
        }

        /**
         * The stage of the usercontract update allowing to specify State.
         */
        interface WithState {
            /**
             * Specifies state.
             * @param state Account state. Specifies whether the user is active or not. Blocked users are unable to sign into the developer portal or call any APIs of subscribed products. Default state is Active. Possible values include: 'active', 'blocked', 'pending', 'deleted'
             * @return the next update stage
             */
            Update withState(UserState state);
        }

    }
}