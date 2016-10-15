package com.fisher.ScreenHoverer.utils;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice.WindowTranslucency;

import javax.swing.JFrame;

import com.sun.awt.AWTUtilities;

/**
 * Created by Fisher at 00:50 on 2016-10-15.
 * 
 * @author fisher
 *
 *         Util for AWT to set window opacity.
 */

public class AWTUtil {

	/**
	 * Detect system support.
	 * 
	 * @return Whether is supported.
	 */
	public static boolean isWindowOpacitySupported() {
		// decide the system screen support.
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		if (gd.isWindowTranslucencySupported(WindowTranslucency.TRANSLUCENT)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Set window opacity(transparency).
	 * 
	 * @param frame A frame.
	 * @param alpha Alpha of the frame will be set.
	 * @return Whether succeeded setting opacity. 
	 */
	public static boolean setWindowOpacity(JFrame frame, float alpha) {
		if (isWindowOpacitySupported()) {
			AWTUtilities.setWindowOpacity(frame, alpha);
			return true;
		} else {
			return false;
		}
	}

}
