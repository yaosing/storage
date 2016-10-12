package com.storage.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.storage.data.Vendor;

public interface vendorDao extends PagingAndSortingRepository<Vendor, Long> {

}
