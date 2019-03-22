package org.springframework.cloud.hikvision.loadbalancer;

/**
 * 服务目录寻址所需的组件标识、段标识
 *
 * @author dengyishi
 *
 */
public class ComponentIdAndSegmentId {

	private String componentId;

	private String segmentId;

	public String getComponentId() {
		return componentId;
	}

	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	public String getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}

	public ComponentIdAndSegmentId(String componentId, String segmentId) {
		super();
		this.componentId = componentId;
		this.segmentId = segmentId;
	}

}
