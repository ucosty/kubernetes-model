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

import io.ucosty.kubernetes.api.model.DoneableHorizontalPodAutoscaler;
import io.ucosty.kubernetes.api.model.HorizontalPodAutoscaler;
import io.ucosty.kubernetes.api.model.HorizontalPodAutoscalerList;
import io.ucosty.kubernetes.client.dsl.*;
import io.ucosty.kubernetes.client.dsl.internal.HorizontalPodAutoscalerOperationsImpl;
import okhttp3.OkHttpClient;

public class AutoscalingAPIGroupClient extends BaseClient implements AutoscalingAPIGroupDSL {

  public AutoscalingAPIGroupClient() throws KubernetesClientException {
    super();
  }

  public AutoscalingAPIGroupClient(OkHttpClient httpClient, final Config config) throws KubernetesClientException {
    super(httpClient, config);
  }

  public MixedOperation<HorizontalPodAutoscaler, HorizontalPodAutoscalerList, DoneableHorizontalPodAutoscaler, Resource<HorizontalPodAutoscaler, DoneableHorizontalPodAutoscaler>> horizontalPodAutoscalers() {
    return new HorizontalPodAutoscalerOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }
}