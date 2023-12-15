package com.cs241.Group3.Controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cs241.Group3.SellClothes;
import com.cs241.Group3.User;
import com.cs241.Group3.Purchases;
import com.cs241.Group3.Repository.ClothesRepository;
import com.cs241.Group3.Repository.UserRepository;
import com.cs241.Group3.Service.ClothesService;
import com.cs241.Group3.Service.PurchaseService;
import com.cs241.Group3.Service.RetrieveClothesService;
import com.cs241.Group3.Service.UserServiceImpl;


@Controller
public class MainController{
	@Autowired
	private ClothesService clothesService;
	@Autowired
	private PurchaseService purchaseService;
	@Autowired
	private RetrieveClothesService retrieveClothesService;
	
	

	
	@GetMapping("/")
	public String home() {
		return "HomePage";
	}
	@GetMapping("/SignIn")
	public String SignIn() {
		return "SignIn";
	}

	@PostMapping("/SellerForm")
	public String saveDetails(@ModelAttribute SellClothes clothes,Authentication authentication) {
			clothesService.save(clothes, authentication.getName());
			return "HomePage";
	}
	
	@PostMapping("/Purchase")
	public String Purchases(@ModelAttribute SellClothes clothes) {
		List<Purchases> purchase = purchaseService.addPurchasesByuserIdAndProductId((long) 1, clothes.getId());
		return "HomePage";
		
	}
	@GetMapping("/deleteCloth/{id}")
	public String deleteCloth(@PathVariable Long id, Model model) {
		retrieveClothesService.deleteClothes(id);
		return "redirect:/ClothList";
	}
	
	@GetMapping("/Cloth_Details")
	public String Details() {
		return "Cloth_Details";
	}
	
	@GetMapping("/HomePage")
	public String Home() {
		return "HomePage";
	}
	@GetMapping("/NewArrivals")
	public String New() {
		return "NewArrivals";
	}
	@GetMapping("/MostVisited")
	public String MostVisted() {
		return "MostVisited";
	}
}
