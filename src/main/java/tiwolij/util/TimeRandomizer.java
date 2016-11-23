package tiwolij.util;

import java.util.Random;

/**
 * Get randomized time within a default or specified timeframe
 * @author jhermes
 *
 */
public class TimeRandomizer {
	
	public static String getRandomizedTime(int startTime, int endTime){
		
		if(startTime<0||startTime>24){
			startTime = 0;
		}
		
		if(endTime<0||endTime>24){
			endTime = 24;
		}
		
		Random random = new Random();
		
		if(endTime<startTime){
			endTime += 24;
		}
		int span = endTime-startTime;
		if(span<0){
			span = span*-1;
		}
		StringBuffer toReturn = new StringBuffer();
		startTime = startTime + random.nextInt(span);
		if(startTime>23){
			startTime-=24;
		}
		
		if(startTime<10){
			toReturn.append("0");
		}
		toReturn.append(startTime);
		toReturn.append(":");
		
		int minutes = random.nextInt(60);
		if(minutes<10){
			toReturn.append("0");			
		}
		toReturn.append(minutes);
		return toReturn.toString();
	}
	
	/**
	 * Returns a randomized time String between 4 and 8 pm.
	 * @return
	 */
	public static String getRandomizedTime(){
		return getRandomizedTime(14,20);		
	}

}
