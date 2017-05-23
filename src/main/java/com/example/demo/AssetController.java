package com.example.demo;

import com.example.demo.domain.Asset;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author David Turanski
 **/
@RestController
public class AssetController {

	@PostMapping("/")
	public ResponseEntity<String> createAsset(Asset asset) {
		return null;

	}
}
