// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.search.documents.implementation.converters;

import com.azure.search.documents.indexes.implementation.models.DataSourceCredentials;
import com.azure.search.documents.indexes.implementation.models.SearchIndexerDataSource;
import com.azure.search.documents.indexes.models.DataChangeDetectionPolicy;
import com.azure.search.documents.indexes.models.DataDeletionDetectionPolicy;
import com.azure.search.documents.indexes.models.SearchIndexerDataSourceConnection;

import java.util.Objects;

/**
 * A converter between {@link SearchIndexerDataSource} and
 * {@link SearchIndexerDataSourceConnection}.
 */
public final class SearchIndexerDataSourceConverter {
    /**
     * Maps from {@link SearchIndexerDataSource} to
     * {@link SearchIndexerDataSourceConnection}.
     */
    public static SearchIndexerDataSourceConnection map(SearchIndexerDataSource obj) {
        if (obj == null) {
            return null;
        }

        String connectionString = obj.getCredentials() == null ? null
            : obj.getCredentials().getConnectionString();
        SearchIndexerDataSourceConnection searchIndexerDataSourceConnection = new SearchIndexerDataSourceConnection(
            obj.getName(), obj.getType(), connectionString, obj.getContainer());


        if (obj.getDataChangeDetectionPolicy() != null) {
            DataChangeDetectionPolicy dataChangeDetectionPolicy =
                DataChangeDetectionPolicyConverter.map(obj.getDataChangeDetectionPolicy());
            searchIndexerDataSourceConnection.setDataChangeDetectionPolicy(dataChangeDetectionPolicy);
        }

        String description = obj.getDescription();
        searchIndexerDataSourceConnection.setDescription(description);

        if (obj.getDataDeletionDetectionPolicy() != null) {
            DataDeletionDetectionPolicy dataDeletionDetectionPolicy =
                DataDeletionDetectionPolicyConverter.map(obj.getDataDeletionDetectionPolicy());
            searchIndexerDataSourceConnection.setDataDeletionDetectionPolicy(dataDeletionDetectionPolicy);
        }

        String eTag = obj.getETag();
        searchIndexerDataSourceConnection.setETag(eTag);

        return searchIndexerDataSourceConnection;
    }

    /**
     * Maps from {@link SearchIndexerDataSourceConnection} to
     * {@link SearchIndexerDataSource}.
     */
    public static SearchIndexerDataSource map(SearchIndexerDataSourceConnection obj) {
        if (obj == null) {
            return null;
        }
        Objects.requireNonNull(obj.getName(), "The SearchIndexerDataSourceConnection name cannot be null");

        DataSourceCredentials credentials = new DataSourceCredentials();
        credentials.setConnectionString(obj.getConnectionString());
        SearchIndexerDataSource searchIndexerDataSource = new SearchIndexerDataSource()
            .setName(obj.getName())
            .setType(obj.getType())
            .setCredentials(credentials)
            .setContainer(obj.getContainer());

        if (obj.getDataChangeDetectionPolicy() != null) {
            com.azure.search.documents.indexes.implementation.models.DataChangeDetectionPolicy
                dataChangeDetectionPolicy = DataChangeDetectionPolicyConverter.map(obj.getDataChangeDetectionPolicy());
            searchIndexerDataSource.setDataChangeDetectionPolicy(dataChangeDetectionPolicy);
        }

        String description = obj.getDescription();
        searchIndexerDataSource.setDescription(description);

        if (obj.getDataDeletionDetectionPolicy() != null) {
            com.azure.search.documents.indexes.implementation.models.DataDeletionDetectionPolicy dataDeletionDetectionPolicy
                = DataDeletionDetectionPolicyConverter.map(obj.getDataDeletionDetectionPolicy());
            searchIndexerDataSource.setDataDeletionDetectionPolicy(dataDeletionDetectionPolicy);
        }

        String eTag = obj.getETag();
        searchIndexerDataSource.setETag(eTag);

        return searchIndexerDataSource;
    }

    private SearchIndexerDataSourceConverter() {
    }
}
