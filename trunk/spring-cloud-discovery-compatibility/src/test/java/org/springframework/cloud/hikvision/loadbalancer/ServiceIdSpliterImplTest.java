package org.springframework.cloud.hikvision.loadbalancer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ServiceIdSpliterImplTest {

	ServiceIdSpliter serviceIdSpliter;

	@Before
	public void setUp() throws Exception {
		serviceIdSpliter = new ServiceIdSpliterImpl();
	}

	@Test
	public final void testSplite() {
		String t1 = "-ccc-ss";
		String t2 = ".ccc-ss";
		String t3 = "ccc-ss";
		String t4 = "ccc-ss-xxx";
		String t5 = "ccc-ss.xxx";
		String t6 = "ccc.ss-xxx";
		String t7 = "ccccccc";
		ComponentIdAndSegmentId cas = serviceIdSpliter.splite(t1);
		assertTrue("校验字符串" + t1, cas == null);
		cas = serviceIdSpliter.splite(t2);
		assertTrue("校验字符串" + t2,
				".ccc".equals(cas.getComponentId()) && t2.equals(cas.getSegmentId()));
		cas = serviceIdSpliter.splite(t3);
		assertTrue("校验字符串" + t3,
				"ccc".equals(cas.getComponentId()) && t3.equals(cas.getSegmentId()));
		cas = serviceIdSpliter.splite(t4);
		assertTrue("校验字符串" + t4,
				"ccc".equals(cas.getComponentId()) && t4.equals(cas.getSegmentId()));
		cas = serviceIdSpliter.splite(t5);
		assertTrue("校验字符串" + t5, "ccc-ss".equals(cas.getComponentId())
				&& "xxx".equals(cas.getSegmentId()));
		cas = serviceIdSpliter.splite(t6);
		assertTrue("校验字符串" + t6, "ccc".equals(cas.getComponentId())
				&& "ss-xxx".equals(cas.getSegmentId()));
		cas = serviceIdSpliter.splite(t7);
		assertTrue("校验字符串" + t7, cas == null);
	}

}
