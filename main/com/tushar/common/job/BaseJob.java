package com.tushar.common.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tushar.common.utils.MDate;

public abstract class BaseJob {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(BaseJob.class);
	private static final String INCORRECT_FORMAT_ERROR = "Please enter applicationFileName,  jobName (and date yyyy-MM-dd, optionally)";
	
	public abstract void executeInternal(MDate businessDate);
	
	public static void main(String[] args){
		if(args.length < 2){
			logger.error(INCORRECT_FORMAT_ERROR);
			return;
		}
		String applicationContextFileName = args[0];
		String jobBean = args[1];
		MDate businessDate = new MDate();
		if(args.length >= 3){
			String[] yyyyMMdd = args[2].split("-");
			businessDate = new MDate(
					Integer.parseInt(yyyyMMdd[0]), 
					Integer.parseInt(yyyyMMdd[1]), 
					Integer.parseInt(yyyyMMdd[2])
							);
		}
		logger.info("Configuration file passed: {}", applicationContextFileName);
		logger.info("Bean Name for Job: {}", jobBean);
		ApplicationContext appContext = new ClassPathXmlApplicationContext(applicationContextFileName);
		((ClassPathXmlApplicationContext)(appContext)).refresh();
		try{
			((BaseJob) appContext.getBean(jobBean)).executeInternal(businessDate);
		}catch(Exception e){
			logger.error("Failed to execute job.\nError: {}", e.getMessage());
		}
		((ClassPathXmlApplicationContext)(appContext)).close();
	}

}
