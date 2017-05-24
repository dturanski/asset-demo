package com.example.demo.reposiitory;

import com.example.demo.domain.Asset;
import com.example.demo.repository.AssetsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author David Turanski
 **/
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.HSQL)
public class AssetsRepositoryTests {
	@Autowired
	AssetsRepository assetsRepository;

	@Test
	public void testCreate() {
		Asset asset = new Asset("127.0.0.1", "ac:bc:32:ab:e7:c7");
		Asset expected = assetsRepository.save(asset);
		Asset actual = assetsRepository.findOne(expected.getId());
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testDelete() {
		Asset asset = new Asset("127.0.0.1", "ac:bc:32:ab:e7:c7");
		assertThat(assetsRepository.findAll()).isEmpty();
		assetsRepository.save(asset);
		assertThat(assetsRepository.findAll()).hasSize(1);
		assetsRepository.delete(asset);
		assertThat(assetsRepository.findAll()).isEmpty();
	}

	@Test
	public void testUpdate() {
		Asset asset = new Asset("127.0.0.1", "ac:bc:32:ab:e7:c7");
		Asset original = assetsRepository.save(asset);
		original.setIpAddress("10.52.1.3");
		Asset actual = assetsRepository.save(original);
		assertThat(actual.getId()).isEqualTo(original.getId());
		assertThat(actual.getIpAddress()).isEqualTo("10.52.1.3");
		assertThat(actual.getMacAddress()).isEqualTo("ac:bc:32:ab:e7:c7");


	}
}
