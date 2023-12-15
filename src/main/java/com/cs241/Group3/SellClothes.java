package com.cs241.Group3;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name =  "Clothes", uniqueConstraints = @UniqueConstraint(columnNames = "clothId"))
public class SellClothes {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long clothId;
	private String clotheTitle;
	private String firstName;
	private Float price;
	private String category;
	private String size;
	private String condition;
	private String email;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SellClothes()
	{
		
	}
	public SellClothes(String clotheTitle, String firstName, float price, String category, String size,
			String condition,String email) {
		super();
		this.firstName = firstName;
		this.price = price;
		this.clotheTitle = clotheTitle;
		this.category = category;
		this.size = size;
		this.condition = condition;
		this.email = email;
	}

	
	public String getClotheTitle() {
		return clotheTitle;
	}
	public void setClotheTitle(String clotheTitle) {
		this.clotheTitle = clotheTitle;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Long getId() {
		return clothId;
	}
	public void setId(Long clothId) {
		this.clothId = clothId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getTitle() {
		return clotheTitle;
	}
	public void setType(String type) {
		this.clotheTitle = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
}
