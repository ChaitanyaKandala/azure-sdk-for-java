/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalakeanalytics.v2015_10_01_preview.implementation;

import java.util.Map;

import com.microsoft.azure.Resource;
import com.microsoft.azure.management.datalakeanalytics.v2015_10_01_preview.DataLakeAnalyticsAccountProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Data Lake Analytics account object, containing all information associated
 * with the named Data Lake Analytics account.
 */
public class DataLakeAnalyticsAccountInner extends Resource {
    /**
     * the properties defined by Data Lake Analytics all properties are
     * specific to each resource provider.
     */
    @JsonProperty(value = "properties")
    private DataLakeAnalyticsAccountProperties properties;

    /**
     * Get the properties defined by Data Lake Analytics all properties are specific to each resource provider.
     *
     * @return the properties value
     */
    public DataLakeAnalyticsAccountProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties defined by Data Lake Analytics all properties are specific to each resource provider.
     *
     * @param properties the properties value to set
     * @return the DataLakeAnalyticsAccountInner object itself.
     */
    public DataLakeAnalyticsAccountInner withProperties(DataLakeAnalyticsAccountProperties properties) {
        this.properties = properties;
        return this;
    }

}