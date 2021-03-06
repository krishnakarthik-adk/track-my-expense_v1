package com.dsk.trackmyexpense.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@Column(name="PRICE", precision=19, scale=2, nullable=false)
	private BigDecimal price;
	
	@Column(name="PAYMENT_MODE", nullable=false)
	private String payment;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="ITEM_CATEGORY", nullable=false)
	private String itemCategory;
	
	@Column(name="ENTRY_DATE", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date expenseEntryDate;
	
	@Column(name="EXPENSE_DATE")
	@Temporal(TemporalType.DATE)
	private Date expenseDate;
	
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
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

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public Date getExpenseEntryDate() {
		return expenseEntryDate;
	}

	public void setExpenseEntryDate(Date expenseEntryDate) {
		this.expenseEntryDate = expenseEntryDate;
	}

	public Date getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}
	
	
	
}
