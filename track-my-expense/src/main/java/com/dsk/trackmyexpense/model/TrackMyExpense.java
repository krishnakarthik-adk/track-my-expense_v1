package com.dsk.trackmyexpense.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dsk.trackmyexpense.constants.TrackMyExpenseConstants;

/**
 * 
 * @author Krishna
 *
 */

public class TrackMyExpense {
	
	private String itemName;
	private String price;
	private String payment;
	private String description;
	private String category;
	
	
	// Just for test
	@SuppressWarnings("unused")
	private List<String> listOfCategories;
	@SuppressWarnings("unused")
	private List<String> paymentOptions;
	
	public List<String> getPaymentOptions() {
		return populatePaymentOptions();
	}
	public void setPaymentOptions(List<String> paymentOptions) {
		this.paymentOptions = paymentOptions;
	}
	public List<String> getListOfCategories() {
		return populateItemCategories();
	}
	public void setListOfCategories(List<String> listOfCategories) {
		this.listOfCategories = listOfCategories;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	// Just for Test
	public List<String> populateItemCategories()
	{
		List<String> categoryList = new ArrayList<String>();
		categoryList.add(TrackMyExpenseConstants.GROCERIES);
		categoryList.add(TrackMyExpenseConstants.FUEL);
		categoryList.add(TrackMyExpenseConstants.MAINTENANCE);
		categoryList.add(TrackMyExpenseConstants.ENTERTAINMENT);
		categoryList.add(TrackMyExpenseConstants.UTILITY_BILLS);
		categoryList.add(TrackMyExpenseConstants.VEGETABLES);
		categoryList.add(TrackMyExpenseConstants.MOBILE_RECHARGE);
		categoryList.add(TrackMyExpenseConstants.PERSONAL_EXPENSE);
		categoryList.add(TrackMyExpenseConstants.SAVINGS);
		categoryList.add(TrackMyExpenseConstants.TOUR_VACATION);
		categoryList.add(TrackMyExpenseConstants.SHOPPING);
		categoryList.add(TrackMyExpenseConstants.VEHICLE_EXPENSE);
		categoryList.add(TrackMyExpenseConstants.TRANSPORT);
		categoryList.add(TrackMyExpenseConstants.MISCELLANEOUS);
		
		Collections.sort(categoryList);
		
		return categoryList;
	}
	
	public List<String> populatePaymentOptions(){
		List<String> paymentOptions = new ArrayList<String>();
		paymentOptions.add(TrackMyExpenseConstants.CASH);
		paymentOptions.add(TrackMyExpenseConstants.ONLINE_TRANSFER);
		paymentOptions.add(TrackMyExpenseConstants.NET_BANKING);
		paymentOptions.add(TrackMyExpenseConstants.CREDIT_CARD);
		
		Collections.sort(paymentOptions);
		
		return paymentOptions;
	}
}
