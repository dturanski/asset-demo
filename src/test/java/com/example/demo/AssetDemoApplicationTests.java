package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest({
			"eureka.client.enabled=false",
			"debug=true"})
public class AssetDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
