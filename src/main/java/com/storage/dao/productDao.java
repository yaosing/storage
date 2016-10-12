package com.storage.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.storage.data.Product;

public interface productDao extends PagingAndSortingRepository<Product, Long> {

}
