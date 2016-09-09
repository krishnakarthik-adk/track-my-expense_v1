package com.dsk.trackmyexpense.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsk.trackmyexpense.domain.TrackMyExpenseDomain;
import com.dsk.trackmyexpense.model.TrackMyExpense;
import com.dsk.trackmyexpense.repo.TrackMyExpenseRepo;

/**
 * 
 * @author Krishna
 *
 */
@Service
public class TrackMyExpenseServiceImpl implements ITrackMyExpenseService{

	@Autowired(required=true)
	private TrackMyExpenseRepo expenseRepo;
	
	@Transactional
	public void submitExpenses(TrackMyExpense expense) {
		TrackMyExpenseDomain expenseDomain = new TrackMyExpenseDomain();
		expenseDomain.setItemName(expense.getItemName());
		expenseDomain.setPayment(expense.getPayment());
		expenseDomain.setPrice(expense.getPrice());
		expenseDomain.setDescription(expense.getDescription());
		expenseDomain.setItemCategory(expense.getCategory());
		
		// Save the expense entry with the current time stamp
		LocalDateTime dateTime = LocalDateTime.now();
		Timestamp ts = Timestamp.valueOf(dateTime);
		
		expenseDomain.setExpenseEntryDate(ts);
		
		
		expenseDomain.setExpenseDate(expense.getExpenseDate());
		
		expenseRepo.save(expenseDomain);
	}

}
