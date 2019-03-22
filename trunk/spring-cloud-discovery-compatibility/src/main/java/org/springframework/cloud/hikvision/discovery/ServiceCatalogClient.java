package org.springframework.cloud.hikvision.discovery;

import com.netflix.loadbalancer.Server;

public interface ServiceCatalogClient {

	Server findByServiceId(String componentId, String serviceId);

}
