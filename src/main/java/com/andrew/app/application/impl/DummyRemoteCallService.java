package com.andrew.app.application.impl;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.andrew.app.application.RemoteCallService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import static org.mockito.Mockito.*;

public class DummyRemoteCallService implements RemoteCallService {
	private RemoteCallService mockedDelegate;

	public DummyRemoteCallService() {

		try {
			mockedDelegate = mock(RemoteCallService.class);
			when(mockedDelegate.call(anyString()))
			.thenThrow(new RuntimeException("Deliberately throwing an exception 1"))
			.thenThrow(new RuntimeException("Deliberately throwing an an exception 2"))
			.thenAnswer(new Answer<String>() {
				@Override
				public String answer(InvocationOnMock invocationOnMock) throws Throwable {
					return (String) invocationOnMock.getArguments()[0];
				}
			});

		} catch(Exception e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallBackCall")
	public String call(String request) throws Exception {

		return this.mockedDelegate.call(request);

	}

    public String fallBackCall(String request) {

        return "FALLBACK: " + request;
    }
}
