/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.netapp.v2020_06_01.implementation;

import com.microsoft.azure.management.netapp.v2020_06_01.SnapshotPolicy;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import com.microsoft.azure.management.netapp.v2020_06_01.SnapshotPolicyPatch;
import java.util.Map;
import rx.functions.Func1;

class SnapshotPolicyImpl extends CreatableUpdatableImpl<SnapshotPolicy, SnapshotPolicyInner, SnapshotPolicyImpl> implements SnapshotPolicy, SnapshotPolicy.Definition, SnapshotPolicy.Update {
    private final NetAppManager manager;
    private String resourceGroupName;
    private String accountName;
    private String snapshotPolicyName;
    private SnapshotPolicyPatch updateParameter;

    SnapshotPolicyImpl(String name, NetAppManager manager) {
        super(name, new SnapshotPolicyInner());
        this.manager = manager;
        // Set resource name
        this.snapshotPolicyName = name;
        //
        this.updateParameter = new SnapshotPolicyPatch();
    }

    SnapshotPolicyImpl(SnapshotPolicyInner inner, NetAppManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.snapshotPolicyName = inner.name();
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.accountName = IdParsingUtils.getValueFromIdByName(inner.id(), "netAppAccounts");
        this.snapshotPolicyName = IdParsingUtils.getValueFromIdByName(inner.id(), "snapshotPolicies");
        //
        this.updateParameter = new SnapshotPolicyPatch();
    }

    @Override
    public NetAppManager manager() {
        return this.manager;
    }

    @Override
    public Observable<SnapshotPolicy> createResourceAsync() {
        SnapshotPoliciesInner client = this.manager().inner().snapshotPolicies();
        return client.createAsync(this.resourceGroupName, this.accountName, this.snapshotPolicyName, this.inner())
            .map(new Func1<SnapshotPolicyInner, SnapshotPolicyInner>() {
               @Override
               public SnapshotPolicyInner call(SnapshotPolicyInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<SnapshotPolicy> updateResourceAsync() {
        SnapshotPoliciesInner client = this.manager().inner().snapshotPolicies();
        return client.updateAsync(this.resourceGroupName, this.accountName, this.snapshotPolicyName, this.updateParameter)
            .map(new Func1<SnapshotPolicyInner, SnapshotPolicyInner>() {
               @Override
               public SnapshotPolicyInner call(SnapshotPolicyInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<SnapshotPolicyInner> getInnerAsync() {
        SnapshotPoliciesInner client = this.manager().inner().snapshotPolicies();
        return client.getAsync(this.resourceGroupName, this.accountName, this.snapshotPolicyName);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }

    private void resetCreateUpdateParameters() {
        this.updateParameter = new SnapshotPolicyPatch();
    }

    @Override
    public Object dailySchedule() {
        return this.inner().dailySchedule();
    }

    @Override
    public Boolean enabled() {
        return this.inner().enabled();
    }

    @Override
    public Object hourlySchedule() {
        return this.inner().hourlySchedule();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String location() {
        return this.inner().location();
    }

    @Override
    public Object monthlySchedule() {
        return this.inner().monthlySchedule();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public Map<String, String> tags() {
        return this.inner().getTags();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public Object weeklySchedule() {
        return this.inner().weeklySchedule();
    }

    @Override
    public SnapshotPolicyImpl withExistingNetAppAccount(String resourceGroupName, String accountName) {
        this.resourceGroupName = resourceGroupName;
        this.accountName = accountName;
        return this;
    }

    @Override
    public SnapshotPolicyImpl withLocation(String location) {
        if (isInCreateMode()) {
            this.inner().withLocation(location);
        } else {
            this.updateParameter.withLocation(location);
        }
        return this;
    }

    @Override
    public SnapshotPolicyImpl withDailySchedule(Object dailySchedule) {
        if (isInCreateMode()) {
            this.inner().withDailySchedule(dailySchedule);
        } else {
            this.updateParameter.withDailySchedule(dailySchedule);
        }
        return this;
    }

    @Override
    public SnapshotPolicyImpl withEnabled(Boolean enabled) {
        if (isInCreateMode()) {
            this.inner().withEnabled(enabled);
        } else {
            this.updateParameter.withEnabled(enabled);
        }
        return this;
    }

    @Override
    public SnapshotPolicyImpl withHourlySchedule(Object hourlySchedule) {
        if (isInCreateMode()) {
            this.inner().withHourlySchedule(hourlySchedule);
        } else {
            this.updateParameter.withHourlySchedule(hourlySchedule);
        }
        return this;
    }

    @Override
    public SnapshotPolicyImpl withMonthlySchedule(Object monthlySchedule) {
        if (isInCreateMode()) {
            this.inner().withMonthlySchedule(monthlySchedule);
        } else {
            this.updateParameter.withMonthlySchedule(monthlySchedule);
        }
        return this;
    }

    @Override
    public SnapshotPolicyImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.inner().withTags(tags);
        } else {
            this.updateParameter.withTags(tags);
        }
        return this;
    }

    @Override
    public SnapshotPolicyImpl withWeeklySchedule(Object weeklySchedule) {
        if (isInCreateMode()) {
            this.inner().withWeeklySchedule(weeklySchedule);
        } else {
            this.updateParameter.withWeeklySchedule(weeklySchedule);
        }
        return this;
    }

}
