package com.fisher.ScreenHoverer;

/**
 * Created by Fisher at 00:18 on 15th October, 2016.
 * 
 * @author Fisher
 *
 *         Screen hover launcher.
 */

public class Launcher {

	/**
	 * Set up and show hoverer.
	 * 
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			HovererHelper.showHelp();
			return;
		}
		HovererHelper.showHelp();
		HovererHelper.showGreeting();
		HovererHelper helper = new HovererHelper();
		helper.showHoverer();
	}

}
