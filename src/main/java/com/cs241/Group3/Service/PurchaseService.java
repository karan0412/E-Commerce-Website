package com.cs241.Group3.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs241.Group3.Purchases;
import com.cs241.Group3.SellClothes;
import com.cs241.Group3.User;
import com.cs241.Group3.Repository.PurchasesRepository;
@Service
public class PurchaseService {
	
	@Autowired
	private PurchasesRepository purchaseRepo;
	
	public List<Purchases> addPurchasesByuserIdAndProductId(Long user_id, Long product_id) {
		Purchases obj = new Purchases();
		obj.setUser_id(user_id);
		obj.setPurchaseId(product_id);
		purchaseRepo.save(obj);
		return this.getPurchasesByUserId(user_id);
		
		
	}
	public List<Purchases> getPurchasesByUserId(Long user_id){
		return purchaseRepo.getPurchasesByUserId(user_id);
		
		
	}
			
	

}
