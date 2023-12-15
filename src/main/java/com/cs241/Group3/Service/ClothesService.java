package com.cs241.Group3.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs241.Group3.SellClothes;
import com.cs241.Group3.Repository.ClothesRepository;



@Service
public interface ClothesService {
	
	
	public SellClothes save(SellClothes clothes, String email);
	public List<SellClothes> getClothes();
	public SellClothes findByClothId(Long id);
	
}