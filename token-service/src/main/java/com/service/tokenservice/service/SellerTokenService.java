package com.service.tokenservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.tokenservice.model.SellerToken;
import com.service.tokenservice.repository.SellerTokenRepository;

@Service
public class SellerTokenService {

	@Autowired
	SellerTokenRepository STRepo;

	public SellerToken guardarActualizar(SellerToken obj) {

		SellerToken resp = STRepo.save(obj);
		return resp;
	}

	public void eliminar(Long id) {
		STRepo.deleteById(id);
	}
	
	public SellerToken traer(Long id) {
		return STRepo.findById(id).orElse(null);
	}

}
