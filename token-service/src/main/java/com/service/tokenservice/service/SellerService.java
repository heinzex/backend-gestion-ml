package com.service.tokenservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.tokenservice.model.Seller;
import com.service.tokenservice.model.SellerToken;
import com.service.tokenservice.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	SellerRepository SRepo;

	public Seller guardarActualizar(Seller obj) {

		Seller resp = SRepo.save(obj);
		return resp;
	}

	public void eliminar(Long id) {
		SRepo.deleteById(id);
	}
	
	public Seller traer(Long id) {
		return SRepo.findById(id).orElse(null);
	}
	
	public Seller traerBySellerID(String sellerID) {
		return SRepo.findOneByUserId(sellerID).orElse(null);
	}
}
