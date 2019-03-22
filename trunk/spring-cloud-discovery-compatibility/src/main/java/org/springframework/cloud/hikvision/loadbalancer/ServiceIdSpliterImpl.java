package org.springframework.cloud.hikvision.loadbalancer;

import org.springframework.util.StringUtils;

public class ServiceIdSpliterImpl implements ServiceIdSpliter {

	@Override
	public ComponentIdAndSegmentId splite(String springCloudServiceId) {

		String[] pattern = StringUtils.split(springCloudServiceId, ".");
		if (pattern != null && StringUtils.hasText(pattern[0])
				&& StringUtils.hasText(pattern[1])) {
			return new ComponentIdAndSegmentId(pattern[0], pattern[1]);
		}
		pattern = StringUtils.split(springCloudServiceId, "-");
		if (pattern != null && StringUtils.hasText(pattern[0])
				&& StringUtils.hasText(pattern[1])) {
			return new ComponentIdAndSegmentId(pattern[0], springCloudServiceId);
		}
		return null; 
	}

}
