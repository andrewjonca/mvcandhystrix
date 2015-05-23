package com.andrew.app.application.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.andrew.app.application.RemoteCallService;
import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRemoteCallServiceHystrix {

	@Autowired
	private RemoteCallService remoteCallService;

	@Test
	public void testRemoteCall() throws Exception {
		assertThat(this.remoteCallService.call("test"), is("FALLBACK: test"));
		assertThat(this.remoteCallService.call("test"), is("FALLBACK: test"));
		assertThat(this.remoteCallService.call("test"), is("test"));

	}

	@Configuration
	@EnableAspectJAutoProxy
	public static class SpringConfig {

		@Bean
		public HystrixCommandAspect hystrixCommandAspect() {
			return new HystrixCommandAspect();
		}

		@Bean
		public RemoteCallService remoteCallService() {
			return new DummyRemoteCallService();
		}
	}
}
