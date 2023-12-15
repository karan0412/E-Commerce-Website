package com.cs241.Group3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs241.Group3.Purchases;
import com.cs241.Group3.SellClothes;
import com.cs241.Group3.Service.ClothesServiceImpl;
import com.cs241.Group3.Service.RetrieveClothesService;
import com.cs241.Group3.Service.UserService;

@Controller
public class ClothesController {
	
	@Autowired
	private RetrieveClothesService retrieveClothesService;
	
	@GetMapping("/ClothList")
	public String getAll(Model model)
	{
		List<SellClothes> clothes = retrieveClothesService.getAll();
		model.addAttribute("clothes", clothes);
		return "ClothList";
				
	}
	@PostMapping(value = "/clothes")
	public String Dropdownvalue(Model model, @RequestParam("category") String keyword)
	{
		model.addAttribute("clothes", retrieveClothesService.findByKeyword(keyword));
		return "ClothList";
	}


	@GetMapping("/Purchases/{clothId}")
	public String purchase(@PathVariable Long clothId, Model model)
	{
		SellClothes clothes = retrieveClothesService.getById(clothId);
		model.addAttribute("clothes", clothes);
		return "Purchases";
	}

	@PostMapping("/Purchases")
	public String displayPurchases(Model model, @RequestParam("id")Long id) {
		
		
		return "/Purchases";
	}
	
	
}
