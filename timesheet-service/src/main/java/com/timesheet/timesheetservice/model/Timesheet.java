package com.timesheet.timesheetservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Timesheet")
public class Timesheet {
	
	@Id
	private String tId;
	private String 

}
