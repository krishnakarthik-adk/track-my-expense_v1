package com.dsk.trackmyexpense.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Krishna
 *
 */
@Entity
@Table(name="T_TRACKMYEXPENSE_RECORD")
public class TrackMyExpenseDomain {

	@Id
	@SequenceGenerator(name="SEQ_GEN", sequenceName="TME_SEQUENCE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
	@Column(name="EXPENSE_ID")
	private Long id;
	
	@Column(name="ITEM_NAME", nullable=false)
	private String itemName;
	
	@Column(name="PRICE", nullable=false)
	private String price;
	
	@Column(name="PAYMENT_MODE", nullable=false)
	private String payment;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	// The default constructor only exists for the sake of JPA
	public TrackMyExpenseDomain() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}