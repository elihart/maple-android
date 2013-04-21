package com.example.filters;

import com.jabistudio.androidjhlabs.filter.SmartBlurFilter;
import com.jabistudio.androidjhlabs.filter.util.AndroidUtils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.example.maple_android.R;

/** 
 * This filter sharpens an image very 
 * slightly using a 3x3 sharpening kernel. 
 * 
 * There are no parameters to this filter.
 *
 */

public class MapleSmartBlurFilter extends MapleFilter {

	
	@Override
	public Bitmap filterBitmap(Bitmap srcBitmap) {
		//Find the bitmap's width height
		int width = srcBitmap.getWidth();
		int height = srcBitmap.getHeight();
		
		SmartBlurFilter filter = new SmartBlurFilter();
		
		//Change int Array into a bitmap
		int[] src = AndroidUtils.bitmapToIntArray(srcBitmap);
		//Applies a filter.
		filter.filter(src, width, height);
		//Change the Bitmap int Array (Supports only ARGB_8888)
		Bitmap dstBitmap = Bitmap.createBitmap(src, width, height, Config.ARGB_8888);
		
		return dstBitmap;
	}

	@Override
	public int getPreview() {
		// TODO Auto-generated method stub
		return R.drawable.filter_smartblur;
	}

	@Override
	public String getName() {
		return "Smart Blur";
	}

}
