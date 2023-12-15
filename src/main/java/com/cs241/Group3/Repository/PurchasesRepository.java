package com.cs241.Group3.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cs241.Group3.Purchases;
import com.cs241.Group3.SellClothes;
import com.cs241.Group3.User;

public interface PurchasesRepository  extends JpaRepository<Purchases, Long>{
	//public List<Purchases> findByUser(User user);
	@Query("Select p FROM Purchases p WHERE p.user_id = :user_id")
	List<Purchases> getPurchasesByUserId(@Param("user_id") Long user_id); 
	
}
