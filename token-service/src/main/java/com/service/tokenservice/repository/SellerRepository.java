package com.service.tokenservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.tokenservice.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long>{

	Optional<Seller> findOneByUserId(String userId);
}
