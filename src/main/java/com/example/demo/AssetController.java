package com.example.demo;

import com.example.demo.domain.Asset;
import com.example.demo.repository.AssetsRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author David Turanski
 **/
@RestController
public class AssetController {

	@Autowired
	private AssetsRepository assetsRepository;

	@PostMapping("/assets")
	public ResponseEntity<Asset> createAsset(Asset asset) {
		Asset saved = assetsRepository.save(asset);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@GetMapping("/assets/{id}")
	public ResponseEntity<Asset> getAsset(@PathVariable("id") long id) {
		Asset asset = assetsRepository.findOne(id);
		if (asset == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(asset, HttpStatus.OK);
		}
	}

	@DeleteMapping("/assets/{id}")
	public ResponseEntity<Object> deleteAsset(@PathVariable("id") long id) {
		Asset asset = assetsRepository.findOne(id);
		if (asset == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		assetsRepository.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
