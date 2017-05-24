package com.example.demo;

import com.example.demo.domain.Asset;
import com.example.demo.repository.AssetsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author David Turanski
 **/
@RunWith(SpringRunner.class)
@WebMvcTest(AssetController.class)
@TestPropertySource(properties = {"security.basic.enabled=false"})
public class AssetsControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private AssetsRepository assetsRepository;

	@Test
	public void testGet() throws Exception {
		Asset asset = new Asset("10.0.0.1", "ac:bc:32:ab:e7:c7");
		given(this.assetsRepository.findOne(1L))
				.willReturn(asset);

		this.mvc.perform(get("/assets/{id}",1L))
				.andExpect(status().isOk())
				.andExpect(content().json(objectMapper.writeValueAsString(asset)));
	}

	@Test
	public void testGetNotFound() throws Exception {
		given(this.assetsRepository.findOne(1L))
				.willReturn(null);

		this.mvc.perform(get("/assets/{id}",1L))
				.andExpect(status().isNotFound());
	}


	@Test
	public void testDelete() throws Exception {
		Asset asset = new Asset("10.0.0.1", "ac:bc:32:ab:e7:c7");
		given(this.assetsRepository.findOne(1L))
				.willReturn(asset);

		this.mvc.perform(delete("/assets/{id}",1L))
				.andExpect(status().isNoContent());
	}

	@Test
	public void testDeleteNotFound() throws Exception {
		given(this.assetsRepository.findOne(1L))
				.willReturn(null);

		this.mvc.perform(delete("/assets/{id}",1L))
				.andExpect(status().isNotFound());
	}

	@Test
	public void testCreate() throws Exception {
		Asset asset = new Asset("10.0.0.1", "ac:bc:32:ab:e7:c7");
		given(this.assetsRepository.save(any(Asset.class)))
				.willReturn(asset);
		this.mvc.perform(post("/assets",objectMapper.writeValueAsString(asset)))
				.andExpect(status().isCreated());

	}


}
