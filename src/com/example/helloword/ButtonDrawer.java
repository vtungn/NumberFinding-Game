package com.example.helloword;

import android.content.Context;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class ButtonDrawer{
	Context ctx;
	public ButtonDrawer(Context context) {
		ctx = context;
	}
	
	public void setNumberofButton(int i) {
		// TODO Auto-generated method stub
		
	}

	public void Draw(LinearLayout btnLO) {
		// TODO Auto-generated method stub
		ImageButton btnNum = new ImageButton(ctx);
		btnNum.setBackgroundResource(android.R.drawable.ic_media_next);
//		btnNum.setBackgroundResource(R.drawable.ic_launcher);
		
	}
}
