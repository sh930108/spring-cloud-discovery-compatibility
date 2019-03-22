package org.springframework.cloud.hikvision.discovery;

import com.netflix.loadbalancer.Server;

public class ServiceCatalogClientDefaultImpl implements ServiceCatalogClient {

	@Override
	public Server findByServiceId(String componentId, String serviceId) {
		Server server = new Server("localhost", 80);
		return server;
	}

}
