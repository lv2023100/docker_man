package com.server.util;

import java.math.BigDecimal;

public class UnitConversion {
	
	public  static String conversionKBAndMB(BigDecimal capacity){
		BigDecimal size = new BigDecimal(1024);
		String unit = "KB";
		for(int i=0 ;i<=1 ; i++){		
			BigDecimal result = capacity.divide(size,2,BigDecimal.ROUND_HALF_UP);
			if(result.doubleValue()<1){
				break;
			}		
			if(i==1){
				unit = "MB";
			}
			capacity = result;
		}
		
		return capacity.toString()+unit;
	}

}
