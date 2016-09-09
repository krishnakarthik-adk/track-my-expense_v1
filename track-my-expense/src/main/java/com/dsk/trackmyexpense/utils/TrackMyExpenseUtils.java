package com.dsk.trackmyexpense.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dsk.trackmyexpense.constants.TrackMyExpenseConstants;

/**
 * 
 * @author Krishna
 *
 */
public class TrackMyExpenseUtils {

	/*@Autowired
	private MessageSource messageSource;
	  
	public List<String> populateItemCategories() {
		List<String> categoryList = new ArrayList<String>();
		
		categoryList.add(this.messageSource.getMessage(TrackMyExpenseConstants.GROCERIES, null, null));
		categoryList.add(this.messageSource.getMessage(TrackMyExpenseConstants.FUEL, null, null));
		categoryList.add(this.messageSource.getMessage(TrackMyExpenseConstants.MAINTENANCE, null, null));
		categoryList.add(this.messageSource.getMessage(TrackMyExpenseConstants.ENTERTAINMENT, null, null));
		categoryList.add(this.messageSource.getMessage(TrackMyExpenseConstants.UTILITY_BILLS, null, null));
		categoryList.add(this.messageSource.getMessage(TrackMyExpenseConstants.VEGETABLES, null, null));
		categoryList.add(this.messageSource.getMessage(TrackMyExpenseConstants.MOBILE_RECHARGE, null, null));
		categoryList.add(this.messageSource.getMessage(TrackMyExpenseConstants.PERSONAL_EXPENSE, null, null));
		categoryList.add(this.messageSource.getMessage(TrackMyExpenseConstants.SAVINGS, null, null));
		categoryList.add(this.messageSource.getMessage(TrackMyExpenseConstants.TOUR_VACATION, null, null));
		categoryList.add(this.messageSource.getMessage(TrackMyExpenseConstants.SHOPPING, null, null));
		categoryList.add(this.messageSource.getMessage(TrackMyExpenseConstants.VEHICLE_EXPENSE, null, null));
		categoryList.add(this.messageSource.getMessage(TrackMyExpenseConstants.TRANSPORT, null, null));
		categoryList.add(this.messageSource.getMessage(TrackMyExpenseConstants.MISCELLANEOUS, null, null));
		
		System.out.println("In Utils Class: categoryList " + categoryList);
		
		Collections.sort(categoryList);
		
		return categoryList;

	}
	
	public List<String> populatePaymentOptions(){
		List<String> paymentOptions = new ArrayList<String>();
		
		paymentOptions.add(this.messageSource.getMessage(TrackMyExpenseConstants.CASH, null, null));
		paymentOptions.add(this.messageSource.getMessage(TrackMyExpenseConstants.ONLINE_TRANSFER, null, null));
		paymentOptions.add(this.messageSource.getMessage(TrackMyExpenseConstants.NET_BANKING, null, null));
		paymentOptions.add(this.messageSource.getMessage(TrackMyExpenseConstants.CREDIT_CARD, null, null));
		
		System.out.println("IN Utils Class: paymentOptions " + paymentOptions);
		
		Collections.sort(paymentOptions);
		
		return paymentOptions;
	}*/
	
	public static List<String> populateItemCategories()
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
	
	public static List<String> populatePaymentOptions(){
		List<String> paymentOptions = new ArrayList<String>();
		paymentOptions.add(TrackMyExpenseConstants.CASH);
		paymentOptions.add(TrackMyExpenseConstants.DEBIT_CARD);
		paymentOptions.add(TrackMyExpenseConstants.NET_BANKING);
		paymentOptions.add(TrackMyExpenseConstants.ONLINE_TRANSFER);
		paymentOptions.add(TrackMyExpenseConstants.CREDIT_CARD);
		
		Collections.sort(paymentOptions);
		
		return paymentOptions;
	}
}
