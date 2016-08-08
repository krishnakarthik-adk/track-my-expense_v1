package com.dsk.trackmyexpense.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dsk.trackmyexpense.domain.TrackMyExpenseDomain;

/**
 * 
 * @author Krishna
 *
 */
@Repository
public interface TrackMyExpenseRepo extends CrudRepository<TrackMyExpenseDomain, Long>{

}
