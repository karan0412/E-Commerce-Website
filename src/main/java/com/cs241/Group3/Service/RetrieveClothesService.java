package com.cs241.Group3.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs241.Group3.SellClothes;
import com.cs241.Group3.Repository.ClothesRepository;

@Service
public class RetrieveClothesService {

	@Autowired
	private ClothesRepository clothesRepository;

	public List<SellClothes> getAll() {
		return clothesRepository.findAll();
	}

	public SellClothes getById(Long clothId)
	{
		return clothesRepository.findById(clothId).orElse(null);
	}
	
	public void deleteClothes(Long clotheId)
	{
		clothesRepository.deleteById(clotheId);
	}
	
	public List<SellClothes> findByKeyword(String category)
	{
		return clothesRepository.findByKeyword(category); 
	}

}
