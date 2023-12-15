package com.cs241.Group3.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cs241.Group3.SellClothes;
import com.cs241.Group3.Service.ClothesService;



@Controller
@RequestMapping("/SellerForm")
public class AddClothesController {
	@Autowired
	private ClothesService clothesService;

	@GetMapping
	public String showAddClothesForm(Model model) {
		model.addAttribute("clothes", new SellClothes());
		return "SellerForm";
	}
	
	
}
