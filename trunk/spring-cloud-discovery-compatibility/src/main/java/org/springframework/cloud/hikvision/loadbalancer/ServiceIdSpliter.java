package org.springframework.cloud.hikvision.loadbalancer;

public interface ServiceIdSpliter {

	ComponentIdAndSegmentId splite(String springCloudServiceId);

}
