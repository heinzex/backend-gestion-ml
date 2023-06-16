package com.service.tokenservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.tokenservice.model.SellerToken;

@Repository
public interface SellerTokenRepository extends JpaRepository<SellerToken, Long> {

}
