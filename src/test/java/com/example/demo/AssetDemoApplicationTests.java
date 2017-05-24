package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest({ "eureka.client.enabled=false", "debug=true" })
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.HSQL)
public class AssetDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
