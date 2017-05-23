package com.example.demo.repository;

import com.example.demo.domain.Asset;
import org.springframework.data.repository.CrudRepository;

/**
 * @author David Turanski
 **/
public interface AssetsRepository extends CrudRepository<Asset,Long> {

}
