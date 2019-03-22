package org.springframework.cloud.hikvision.loadbalancer.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.hikvision.discovery.ServiceCatalogClient;
import org.springframework.cloud.hikvision.discovery.ServiceCatalogClientDefaultImpl;
import org.springframework.cloud.hikvision.loadbalancer.ServiceIdSpliter;
import org.springframework.cloud.hikvision.loadbalancer.ServiceIdSpliterImpl;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClients(defaultConfiguration = LoadbalancerRuleConfiguration.class)
public class HikDiscoveryAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean({ ServiceCatalogClient.class })
	public ServiceCatalogClient serviceCatalogClient() {
		return new ServiceCatalogClientDefaultImpl();
	}

	@Bean
	@ConditionalOnMissingBean({ ServiceIdSpliter.class })
	public ServiceIdSpliter serviceIdSpliter() {
		return new ServiceIdSpliterImpl();
	}

}
