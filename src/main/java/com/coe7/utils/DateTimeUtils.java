package com.coe7.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;

public class DateTimeUtils {

	private static final String FORMAT = "yyyy/MMM/dd HH:mm:ss";

	public static void main(String argv[]) {
		Calendar cal = GregorianCalendar.getInstance();
		// define it locally as this class is not thread-safe
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
		// You may think it is midnight 1st of Jan 2009
		cal.set(2009, 1, 1, 0, 0, 0);
		System.out.println("Bad=" + sdf.format(cal.getTime()));
		cal.set(2009, 0, 1, 0, 0, 0);
		System.out.println("Good=" + sdf.format(cal.getTime()));

		System.out.println("===== zero and one index based gotchas =======");
		System.out
				.println("Day Of The Month=" + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Month=" + cal.get(Calendar.MONTH));
		System.out.println("===== Joda to the rescue =======");
		// best - intuitive and immutable(hence thread-safe)
		DateTime dateTime = new DateTime(2009, 1, 1, 0, 0, 0, 0);
		System.out.println("bestWithJoda=" + dateTime.toString(FORMAT));
	}
}
