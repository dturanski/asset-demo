package com.example.demo.reposiitory;

import com.example.demo.domain.Asset;
import com.example.demo.repository.AssetsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author David Turanski
 **/
@RunWith(SpringRunner.class)
@DataJpaTest
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
		assert()
	}
}
