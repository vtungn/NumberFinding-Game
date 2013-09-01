package com.example.helloword;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnClickListener {
	
	private Game game;
	int score = 0;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		
//		Log.v(LogCatTag.TEST, "onCreate called");
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        int difficulty = 20;
        
        
        game = new Game();
        game.Init(difficulty);
        
        RelativeLayout LOmain = (RelativeLayout)findViewById(R.id.LL1);      
        
        int maxX=550;
        int maxY=800;
        for (int i = 1; i <= difficulty; i++) {
        	Button shareButton = new Button(this);
            shareButton.setBackgroundResource(android.R.drawable.btn_radio);
            shareButton.setId(i);
            shareButton.setText(i+" ");
            shareButton.setTextSize(10);
            shareButton.setOnClickListener(this); 
            
            Random r = new Random();
            
            int randX=r.nextInt(maxX);
            int randY=r.nextInt(maxY);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(70, 90);
            params.leftMargin = randX;
            params.topMargin = randY; 
//            shareButton.setLayoutParams(shareParams);
            
            LOmain.addView(shareButton,params);
            
        }
        
        
       
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        return true;
    }

	@Override
	public void onClick(View v) {
		
		Log.v(LogCatTag.TEST, "onClick called");
		
		int id = v.getId();
		Log.v(LogCatTag.TEST, ((Integer)id).toString());

		if (game.ChooseNumber(id))
		{
			// TODO: Remove clicked button here
			Log.v(LogCatTag.TEST, "Correct");
			score++;
			((RelativeLayout)v.getParent()).removeView(v);
			
			Log.v(LogCatTag.TEST, "isWon" + ((Boolean)game.IsWon()).toString());
	        if (game.IsWon() == true) {		
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						this);
		 
					// set title
					alertDialogBuilder.setTitle("You have WON");
		 
					// set dialog message
					alertDialogBuilder
						.setMessage("Your score is "+ score + ".Click yes to exit!")
						.setCancelable(false)
						.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int id) {
								// if this button is clicked, close
								// current activity
								MainActivity.this.finish();
							}
						  })
						.setNegativeButton("No",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int id) {
								// if this button is clicked, just close
								// the dialog box and do nothing
								dialog.cancel();
							}
						});
		 
						// create alert dialog
						AlertDialog alertDialog = alertDialogBuilder.create();
		 
						// show it
						alertDialog.show();
			}
		}
	}
}
