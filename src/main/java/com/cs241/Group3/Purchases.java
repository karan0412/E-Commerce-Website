package com.cs241.Group3;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name =  "MyPurchases", uniqueConstraints = @UniqueConstraint(columnNames = "purchaseId"))
public class Purchases {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long purchaseId;
	private Long user_id;
	private Long product_id;;
	

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getPurchaseId() {
		return purchaseId;
	}



	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

}
