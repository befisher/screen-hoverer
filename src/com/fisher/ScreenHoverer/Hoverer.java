package com.fisher.ScreenHoverer;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.fisher.ScreenHoverer.utils.AWTUtil;
import com.fisher.ScreenHoverer.utils.LogUtil;

@SuppressWarnings("serial")
public class Hoverer extends JFrame {

	private JFrame mHoverer;
	/**
	 * Hoverer default rectangle; which represent the size and position.
	 */
	private Rectangle mRect = new Rectangle(130, 666, 1000, 52);
	/**
	 * Hoverer default alpha value.
	 * For 0.0f is completely transparent while 1.0f is not transparent.
	 */
	private float mAlpha = 0.94f;

	/**
	 * Hoverer position step scale; In pixel.
	 */
	private int mPositionScale = 2;
	/**
	 * Hoverer width and height step scale; In pixel.
	 */
	private int mWidthOrHeightScale = 2;
	/**
	 * Step for alpha value changes.
	 */
	private float mAlphaScale = 0.002f;

	public Hoverer() {
		mHoverer = new JFrame();
		mHoverer.setLayout(null);
		mHoverer.setUndecorated(true);

		JPanel panel = new JPanel();
		// Make it large enough
		panel.setBounds(0, 0, 10000, 10000);
		panel.setBackground(Color.black);
		mHoverer.add(panel);

		flushHovererSize();
		flushHovererAlpha();

		mHoverer.setAlwaysOnTop(true);
		mHoverer.setVisible(true);
	}

	/**
	 * Moving up, down, left and right.
	 */
	public void moveUp() {
		mRect.y -= mPositionScale;
		flushHovererSize();
	}

	public void moveDown() {
		mRect.y += mPositionScale;
		flushHovererSize();
	}

	public void moveLeft() {
		mRect.x -= mPositionScale;
		flushHovererSize();
	}

	public void moveRight() {
		mRect.x += mPositionScale;
		flushHovererSize();
	}

	/**
	 * Widen or narrow, and heighten or shorten the hoverer.
	 */
	public void widen() {
		mRect.width += 2 * mWidthOrHeightScale;
		mRect.x -= mWidthOrHeightScale;
		flushHovererSize();
	}

	public void narrow() {
		mRect.width -= 2 * mWidthOrHeightScale;
		mRect.x += mWidthOrHeightScale;
		flushHovererSize();
	}

	public void heighten() {
		mRect.height += mWidthOrHeightScale;
		flushHovererSize();
	}

	public void shorten() {
		mRect.height -= mWidthOrHeightScale;
		flushHovererSize();
	}

	/**
	 * Change the degree of transparency.
	 */
	public void fadeIn() {
		mAlpha -= mAlphaScale;
		mAlpha = mAlpha < 0 ? 0f : mAlpha;
		flushHovererAlpha();
	}

	public void fadeOut() {
		mAlpha += mAlphaScale;
		mAlpha = mAlpha > 1 ? 1f : mAlpha;
		flushHovererAlpha();
	}

	/**
	 * Flush hoverer size after setting a specific value.
	 */
	public void flushHovererSize() {
		mHoverer.setBounds(mRect);
	}
	/**
	 * Flush hoverer alpha after setting a specific value.
	 */
	public void flushHovererAlpha() {
		boolean isOkay = AWTUtil.setWindowOpacity(mHoverer, mAlpha);
		if (!isOkay) {
			LogUtil.warning("Setting Opacity failed!");
		}
	}
}
