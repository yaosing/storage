package com.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.storage.dao.vendorDao;
import com.storage.data.Vendor;
import com.storage.vo.VendorPageVo;

@Service
public class VendorServiceImpl implements VendorService {
	private @Autowired vendorDao vendorDao;

	@Override
	public boolean addVendor(String sku, String name, String address, String phoneNumber, String comment, String saler,
			String salerLink) throws Exception {
		Vendor vendor = new Vendor(sku, name, address, phoneNumber, comment, saler, salerLink);
		vendorDao.save(vendor);
		return true;
	}

	@Override
	public boolean deleteByVendorId(Long id) throws Exception {
		boolean exist = vendorDao.exists(id);
		
		if (exist) {
			vendorDao.delete(id);
		}
		
		return true;
	}

	@Override
	public boolean updateVendor(Long id, String sku, String name, String address, String phoneNumber, String comment,
			String saler, String salerName) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addVendorViaExcelFile(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VendorPageVo getVendors(Pageable pageable) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
