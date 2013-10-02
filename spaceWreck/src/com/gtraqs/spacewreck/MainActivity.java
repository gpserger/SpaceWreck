package com.gtraqs.spacewreck;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private String[][] myArray;
    private int row;
    private int col;
    
    public void MainActivity(){
        //Detta ar en constructor, dvs denna function/method anropas automatiskt nar du skapar ett ny object av typ MainActivity
        myArray = new String[3][3];
        
   		
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                myArray[i][j] = "0";
            }
        }
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Multidimensional array for coordinate system. 
        //For better GUI, i would use IDs like 0 is air, 1 is stone e.t.c. and they would have different properties.
   		/*String array[][]={{"0 "," 0 "," 0"},
   						  {"0 "," 0 "," 0"},
				          {"0 "," 0 "," 0"}};*/
   		//Keep track of where the "cursor"/"Character" is.
   		
   		
   		//Print the array.
   		printText();//array);
   		
   		//Wait for user to press "Place X".
   	    setButtonClickListener();
    }
    private void printText(){//String array[][]) {
    	/*TextViews are XML widgets (see "spaceWreck/res/activity_main.xml")
    	this overwrites the TextView grid, with the array*/
    	TextView text = (TextView) findViewById(R.id.grid);
   		text.setText(myArray[0][0] + myArray[0][1] + myArray[0][2] + "\n" 
   					 + myArray[1][0] + myArray[1][1] + myArray[1][2] + "\n" 
   				     + myArray[2][0] + myArray[2][1] + myArray[2][2]);
   		
   		
    }
    
    private void setButtonClickListener() {
    	 Button toggleButton = (Button)findViewById(R.id.placeX);
    	 toggleButton.setOnClickListener(new View.OnClickListener() {
    		 //This method was mostly copied from http://developer.android.com/reference/android/widget/Button.html
			@Override
			public void onClick(View v/*Not sure what View v is */) {
				// TODO Auto-generated method stub
				/*I had to make a copy of the array because i couldn't access it for some reason even when I called the 
				method like: "setButtonClickListener(array);" and the method is "made" like this: 
				"private void setButtonClickListener(String array[][]){}"
				a*/
				/*String array[][]={{"0 "," 0 "," 0"},
 						  		  {"0 "," 0 "," 0"},
 						  		  {"0 "," 0 "," 0"}};*/
				myArray[1][1] = "X";
				row = 1;
				col = 1;
				
				printText();//array);
			}
		});
    	 }
    private void setButtonClickListenerUp() {
   	 Button toggleButton = (Button)findViewById(R.id.up);
   	 toggleButton.setOnClickListener(new View.OnClickListener() {
			//This is the first of the four directional buttons
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//I'm supposed to move the X up here
				if(row!=0){
				myArray[row][col]="0";
				row--;
				myArray[row][col]="X";
				printText();
				}
			}
		});
   	 }
}
