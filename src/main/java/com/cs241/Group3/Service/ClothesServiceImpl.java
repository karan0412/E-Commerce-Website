package com.cs241.Group3.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs241.Group3.SellClothes;
import com.cs241.Group3.User;
import com.cs241.Group3.Repository.ClothesRepository;
import com.cs241.Group3.Repository.UserRepository;

@Service
public class ClothesServiceImpl implements ClothesService {
	
	@Autowired
	private ClothesRepository clothesRepo;
	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public List<SellClothes> getClothes()
	{
		return clothesRepo.findAll();
	}
	
	public ClothesServiceImpl(ClothesRepository clothesRepo,UserRepository userRepo) {
		super();
		this.clothesRepo = clothesRepo;
		this.userRepo = userRepo;
	}

	public SellClothes save(SellClothes product,String email) {
		product= new SellClothes(product.getTitle(), product.getFirstName(),product.getPrice(), product.getCategory(), product.getSize(), product.getCondition(),email);
		return clothesRepo.save(product);
		
	}
	public SellClothes findByClothId(Long id)
	{
		SellClothes clothes = clothesRepo.findByClothId(id);
	        return clothes;
	}

}
