package util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format implements Serializable {

	public static String getDateString(Date date) {
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyy/MM/dd");
		return dt1.format(date);
	}

	public static String getTimeString(Date date) {
		SimpleDateFormat dt1 = new SimpleDateFormat("hh:mm");
		return dt1.format(date);
	}
}
