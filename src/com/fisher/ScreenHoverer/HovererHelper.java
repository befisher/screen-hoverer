package com.fisher.ScreenHoverer;

import java.io.InputStream;

import com.fisher.ScreenHoverer.utils.LogUtil;

/**
 * Created by FIsher at 01:15 on 2016-10-15.
 * 
 * @author fisher
 *
 *         ScreenHover helper. Main logic for ScreenHover.
 */

public class HovererHelper {

	
	private Hoverer mHoverer;
	/**
	 * Standard input(default console).
	 */
	private InputStream mConsoleInput = System.in;

	public HovererHelper() {

	}

	/**
	 * Initialize the hoverer and bind console.
	 */
	public void showHoverer() {
		mHoverer = new Hoverer();
		bindConsole();
	}

	/**
	 * Bind console for commands to input.
	 */
	public void bindConsole() {
		try {
			int key = -1;
			while ((key = mConsoleInput.read()) != -1) {
				if ('a' <= key && key <= 'z') {
					key -= 32;
				} else if ('A' <= key && key <= 'Z') {

				} else if (key == '<' || key == '>') {

				} else if (key == '?') {

				} else if (key == '1') {
					break;
				} else{
					continue;					
				}
				runCommand(key);
			}
		} catch (Exception e) {
			LogUtil.log("Error when reading char: " + e.toString());
		} finally {
			if (mConsoleInput != null) {
				try {
					mConsoleInput.close();
				} catch (Exception e) {
					LogUtil.log("Error when closing System.in: " + e.toString());
				}
			}
		}
	}

	/**
	 * Run command.
	 * 
	 * @param command Command needed.
	 * @throws Exception Closing console input exception.
	 */
	public void runCommand(int command) throws Exception {
		switch (command) {
		case '?':
			HovererHelper.showHelp();
			break;
		case 'Q':
		case 'q':
			mConsoleInput.close();
			LogUtil.log("Listening has shut up");
			return;
		case 'W':
			mHoverer.moveUp();
			break;
		case 'S':
			mHoverer.moveDown();
			break;
		case 'A':
			mHoverer.moveLeft();
			break;
		case 'D':
			mHoverer.moveRight();
			break;
		case 'I':
			mHoverer.heighten();
			break;
		case 'K':
			mHoverer.shorten();
			break;
		case 'J':
			mHoverer.widen();
			break;
		case 'L':
			mHoverer.narrow();
			break;
		case '<':
			mHoverer.fadeIn();
			break;
		case '>':
			mHoverer.fadeOut();
			break;
		default:
			LogUtil.log("Unknown Order!");
			break;
		}
	}

	/**
	 * Show greeting to user.
	 */
	public static void showGreeting() {
		LogUtil.log("Input '?' for help!");
	}

	/**
	 * Show help info to user.
	 */
	public static void showHelp() {
		LogUtil.log("Wanna Up, Down, Left, Right, please use -->> W S A D;");
		LogUtil.log("Wanna Highten, Shorten, Widen, Narrow, please use -->> I K J L;");
		LogUtil.log("Wanna Shadow, Brighten, please use -->> < >;");
		LogUtil.log("Wanna See The Parameter, please input -->> E");
		LogUtil.log("Tip: All letters will be ignored cases;");
		LogUtil.log("");
	}
}
