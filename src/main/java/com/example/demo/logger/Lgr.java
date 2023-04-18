package com.example.demo.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lgr 
{
	public static Logger getLogger(Class className)
	{
		return LoggerFactory.getLogger(className);
	}

}
