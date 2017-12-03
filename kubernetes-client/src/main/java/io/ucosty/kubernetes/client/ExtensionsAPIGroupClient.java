/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.ucosty.kubernetes.client;

import io.ucosty.kubernetes.api.model.extensions.DaemonSet;
import io.ucosty.kubernetes.api.model.extensions.DaemonSetList;
import io.ucosty.kubernetes.api.model.extensions.Deployment;
import io.ucosty.kubernetes.api.model.extensions.DeploymentList;
import io.ucosty.kubernetes.api.model.extensions.DoneableDaemonSet;
import io.ucosty.kubernetes.api.model.extensions.DoneableDeployment;
import io.ucosty.kubernetes.api.model.extensions.DoneableIngress;
import io.ucosty.kubernetes.api.model.extensions.DoneableNetworkPolicy;
import io.ucosty.kubernetes.api.model.extensions.NetworkPolicy;
import io.ucosty.kubernetes.api.model.extensions.NetworkPolicyList;
import io.ucosty.kubernetes.api.model.DoneableJob;
import io.ucosty.kubernetes.api.model.extensions.DoneableReplicaSet;
import io.ucosty.kubernetes.api.model.extensions.DoneableThirdPartyResource;
import io.ucosty.kubernetes.api.model.extensions.Ingress;
import io.ucosty.kubernetes.api.model.extensions.IngressList;
import io.ucosty.kubernetes.api.model.Job;
import io.ucosty.kubernetes.api.model.JobList;
import io.ucosty.kubernetes.api.model.extensions.ReplicaSet;
import io.ucosty.kubernetes.api.model.extensions.ReplicaSetList;
import io.ucosty.kubernetes.api.model.extensions.ThirdPartyResource;
import io.ucosty.kubernetes.api.model.extensions.ThirdPartyResourceList;
import io.ucosty.kubernetes.client.dsl.*;
import io.ucosty.kubernetes.client.dsl.internal.DaemonSetOperationsImpl;
import io.ucosty.kubernetes.client.dsl.internal.DeploymentOperationsImpl;
import io.ucosty.kubernetes.client.dsl.internal.IngressOperationsImpl;
import io.ucosty.kubernetes.client.dsl.internal.JobOperationsImpl;
import io.ucosty.kubernetes.client.dsl.internal.NetworkPolicyOperationsImpl;
import io.ucosty.kubernetes.client.dsl.internal.ReplicaSetOperationsImpl;
import io.ucosty.kubernetes.client.dsl.internal.ThirdPartyResourceOperationsImpl;
import okhttp3.OkHttpClient;

public class ExtensionsAPIGroupClient extends BaseClient implements ExtensionsAPIGroupDSL {

    public ExtensionsAPIGroupClient() throws KubernetesClientException {
        super();
    }

    public ExtensionsAPIGroupClient(OkHttpClient httpClient, final Config config) throws KubernetesClientException {
        super(httpClient, config);
    }

    @Override
    public MixedOperation<Job, JobList, DoneableJob, ScalableResource<Job, DoneableJob>> jobs() {
        return new JobOperationsImpl(httpClient, getConfiguration(), getNamespace());
    }

    @Override
    public MixedOperation<Deployment, DeploymentList, DoneableDeployment, ScalableResource<Deployment, DoneableDeployment>> deployments() {
        return new DeploymentOperationsImpl(httpClient, getConfiguration(), getNamespace());
    }

    @Override
    @Deprecated
    public MixedOperation<Ingress, IngressList, DoneableIngress, Resource<Ingress, DoneableIngress>> ingress() {
        return ingresses();
    }

    @Override
    public MixedOperation<Ingress, IngressList, DoneableIngress, Resource<Ingress, DoneableIngress>> ingresses() {
        return new IngressOperationsImpl(httpClient, getConfiguration(), getNamespace());
    }

    @Override
    public MixedOperation<NetworkPolicy, NetworkPolicyList, DoneableNetworkPolicy, Resource<NetworkPolicy, DoneableNetworkPolicy>> networkPolicies() {
        return new NetworkPolicyOperationsImpl(httpClient, getConfiguration(), getNamespace());
    }

    @Override
    public MixedOperation<DaemonSet, DaemonSetList, DoneableDaemonSet, Resource<DaemonSet, DoneableDaemonSet>> daemonSets() {
        return new DaemonSetOperationsImpl(httpClient, getConfiguration(), getNamespace());
    }

    public NonNamespaceOperation<ThirdPartyResource, ThirdPartyResourceList, DoneableThirdPartyResource, Resource<ThirdPartyResource, DoneableThirdPartyResource>> thirdPartyResources() {
        return new ThirdPartyResourceOperationsImpl(httpClient, getConfiguration());
    }

    public MixedOperation<ReplicaSet, ReplicaSetList, DoneableReplicaSet, RollableScalableResource<ReplicaSet, DoneableReplicaSet>> replicaSets() {
        return new ReplicaSetOperationsImpl(httpClient, getConfiguration(), getNamespace());
    }
}