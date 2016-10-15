package com.fisher.ScreenHoverer.utils;

import java.util.Date;

/**
 * Created by Fisher at 01:00 on 2016-10-15.
 * 
 * @author fisher
 *
 *         util for log.
 */
public class LogUtil {

	/**
	 * Print the general log to console.
	 * 
	 * @param text Text required to be logged.
	 */
	public static void log(String text) {
		System.out.println(text);
	}

	/**
	 * Print some warnings to console.
	 * 
	 * @param text Text required to be warned.
	 */
	public static void warning(String text) {
		log(new Date() + "Warning: " + text);
	}

}
