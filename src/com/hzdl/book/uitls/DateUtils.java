package com.hzdl.book.uitls;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static final String YYYY_MM_DD = "yyyy年MM月dd日";
	private static final String YYYY_MM_DD_HH_MM_SS = "yyyy年MM月dd日HH时mm分ss秒";

	private static SimpleDateFormat sdf;

	public static String getNowTime() {
		sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		return sdf.format(new Date());
	}

}
