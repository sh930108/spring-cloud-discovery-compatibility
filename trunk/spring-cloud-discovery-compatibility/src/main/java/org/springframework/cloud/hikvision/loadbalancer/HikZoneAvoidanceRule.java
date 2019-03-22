package org.springframework.cloud.hikvision.loadbalancer;

import org.springframework.cloud.hikvision.discovery.ServiceCatalogClient;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAvoidanceRule;

public class HikZoneAvoidanceRule extends ZoneAvoidanceRule
		implements HikLoadbalancerRule {

	private ServiceCatalogClient serviceCatalogClient;

	private ServiceIdSpliter serviceIdSpliter;

	public HikZoneAvoidanceRule(ServiceCatalogClient serviceCatalogClient,
			ServiceIdSpliter serviceIdSpliter) {
		super();
		this.serviceCatalogClient = serviceCatalogClient;
		this.serviceIdSpliter = serviceIdSpliter;
	}

	@Override
	public Server choose(Object key) {
		Server server = super.choose(key);
		if (server == null) {
			ILoadBalancer lb = getLoadBalancer();
			if (lb instanceof BaseLoadBalancer) {
				String serviceName = ((BaseLoadBalancer) lb).getName();
				ComponentIdAndSegmentId componentIdAndSegmentId = serviceIdSpliter
						.splite(serviceName);
				if (componentIdAndSegmentId != null) {
					server = serviceCatalogClient.findByServiceId(
							componentIdAndSegmentId.getComponentId(),
							componentIdAndSegmentId.getSegmentId());
				}
			}
		}
		return server;
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		super.initWithNiwsConfig(clientConfig);
	}

}
