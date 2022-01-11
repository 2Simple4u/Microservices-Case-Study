package com.timesheet.timesheetservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.timesheet.timesheetservice.model.Timesheet;


@EnableMongoRepositories
public interface TimesheetRepo extends MongoRepository<Timesheet, String> {
	
	 public Timesheet findByTimeSheetId(String tId);
		public void deleteByTimeSheetId(String tId);

}
