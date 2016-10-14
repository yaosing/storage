package com.storage.service;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.storage.vo.VendorPageVo;

/**
 * Vendor Service
 * 
 * @author terry.yao
 *
 */
public interface VendorService {
	/**
	 * create vendor
	 * 
	 * @param sku
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param comment
	 * @param saler
	 * @param salerLink
	 * @return
	 * @throws Exception
	 */
	public boolean addVendor(String sku, String name, String address, String phoneNumber, String comment, String saler,
			String salerLink) throws Exception;

	/**
	 * delete vendor
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteByVendorId(Long id) throws Exception;

	/**
	 * update vendor
	 * 
	 * @param id
	 * @param sku
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param comment
	 * @param saler
	 * @param salerName
	 * @return
	 * @throws Exception
	 */
	public boolean updateVendor(Long id, String sku, String name, String address, String phoneNumber, String comment,
			String saler, String salerName) throws Exception;

	/**
	 * create vendor via excel file
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public boolean addVendorViaExcelFile(MultipartFile file) throws Exception;

	/**
	 * vendor page
	 * 
	 * @param pageable
	 * @return
	 * @throws Exception
	 */
	public VendorPageVo getVendors(Pageable pageable) throws Exception;
}
