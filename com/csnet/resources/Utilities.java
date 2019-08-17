package com.csnet.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class Utilities {
    private static final Random RANDOM_NUMBER_GENERATOR = new Random();
	
	/*
	 * Get Local User Properties.
	 */
	public static Properties getPropertyValues() throws IOException {
		String propFileName = "properties\\user_default_local.properties";
		FileInputStream inputStream = new FileInputStream(propFileName);
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return properties;
		
	}
	
	public static String randomNumber(int numberLength) {

		String numFormat = "%0" + numberLength + "d";
		Random r = new Random();
		int randomNumber = 0;
		int minValue = 1;
		int maxValue = (int) (Math.pow(10, numberLength) - 1);
		randomNumber = r.nextInt(maxValue-minValue+1)+minValue;
		String numberString = String.format (numFormat, randomNumber);
		return(numberString);
	}

    public static String generateUniqueName(String prefix)
    {
        Integer randomNumber = RANDOM_NUMBER_GENERATOR.nextInt(1000);
        String name = prefix.concat("_").concat(randomNumber.toString());
        return name;
    }
    
    public static String generateUniqueFtpId(String prefix)
    {
        Integer randomNumber = RANDOM_NUMBER_GENERATOR.nextInt(10000);
        String name = prefix.concat(randomNumber.toString());
        return name;
    }
    
    public static String getTodaysDate() {
    	return formateDate(new Date());
    }
    
    public static String getFutureDate(int daysAhead) {
//    	String today = null;
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.DATE, 7);
    	Date futureDate = cal.getTime();
    	return formateDate(futureDate);
    }
    
    public static String formateDate(Date date) {
    	String pattern = "yyyy-MM-dd";
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    	return simpleDateFormat.format(date);
    }

}
