package com.andrew.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.andrew.app.MvcandhystrixApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MvcandhystrixApplication.class)
@WebAppConfiguration
public class MvcandhystrixApplicationTests {

	@Test
	public void contextLoads() {
	}

}
