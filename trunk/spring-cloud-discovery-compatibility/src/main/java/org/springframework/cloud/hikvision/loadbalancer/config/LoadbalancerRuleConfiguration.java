package org.springframework.cloud.hikvision.loadbalancer.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.hikvision.discovery.ServiceCatalogClient;
import org.springframework.cloud.hikvision.loadbalancer.HikLoadbalancerRule;
import org.springframework.cloud.hikvision.loadbalancer.HikZoneAvoidanceRule;
import org.springframework.cloud.hikvision.loadbalancer.ServiceIdSpliter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class LoadbalancerRuleConfiguration {

	@Bean
	@ConditionalOnMissingBean({ HikLoadbalancerRule.class })
	public IRule ribbonRule(ServiceCatalogClient serviceCatalogClient,
			ServiceIdSpliter serviceIdSpliter) {
		return new HikZoneAvoidanceRule(serviceCatalogClient, serviceIdSpliter);
	}

}
