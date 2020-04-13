package util;

import java.util.Calendar;

public class DateTime {
	private Calendar cc;

	public DateTime() {
		cc = Calendar.getInstance();
	}
	
	public String getUNIX() {
		return String.valueOf(cc.getTimeInMillis());
	}
	
	public String getUNIX(String value) {
		
		String tempStr[] = value.split(" ");

		if (tempStr[1].equalsIgnoreCase("second")) {
			cc.add(Calendar.SECOND, Integer.parseInt(tempStr[0]));
		} else if (tempStr[1].equalsIgnoreCase("minute")) {
			cc.add(Calendar.MINUTE, Integer.parseInt(tempStr[0]));
		} else if (tempStr[1].equalsIgnoreCase("hour")) {
			cc.add(Calendar.HOUR, Integer.parseInt(tempStr[0]));
		} else if (tempStr[1].equalsIgnoreCase("day")) {
			cc.add(Calendar.DAY_OF_MONTH, Integer.parseInt(tempStr[0]));
		} else if (tempStr[1].equalsIgnoreCase("month")) {
			cc.add(Calendar.MONTH, Integer.parseInt(tempStr[0]));
		} else if (tempStr[1].equalsIgnoreCase("year")) {
			cc.add(Calendar.YEAR, Integer.parseInt(tempStr[0]));
		}

		return String.valueOf(cc.getTimeInMillis());
	}
}
