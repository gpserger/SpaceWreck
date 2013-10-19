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
    Boolean XExist = false;
    
    public MainActivity(){
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

       
   		
   		
   		//Print the array.
   		printText();//array);
   		
   		//Wait for user to press "Place X".
   	    setButtonClickListenerX();//To place X
   	    setButtonClickListenerUp();//Move up
   	    setButtonClickListenerDown();//Move down
   	    setButtonClickListenerRight();//Move right
   	    setButtonClickListenerLeft();//Move left
   	 
   	    
   	    
    }
    private void printText(){//String array[][]) {
    	/*TextViews are XML widgets (see "spaceWreck/res/activity_main.xml")
    	this overwrites the TextView grid, with the array*/
    	TextView text = (TextView) findViewById(R.id.grid);
   		text.setText(myArray[0][0] + myArray[0][1] + myArray[0][2] + "\n" 
   					 + myArray[1][0] + myArray[1][1] + myArray[1][2] + "\n" 
   				     + myArray[2][0] + myArray[2][1] + myArray[2][2]);
   		
   		
    }
    
    private void setButtonClickListenerX() {
    	 Button toggleButton = (Button)findViewById(R.id.placeX);
    	 toggleButton.setOnClickListener(new View.OnClickListener() {
    		 //This method was mostly copied from http://developer.android.com/reference/android/widget/Button.html
			@Override
			public void onClick(View v/*Not sure what View v is */) {
				// TODO Auto-generated method stub
				
				if(XExist==false){
					myArray[1][1] = "X";//"Print" the X in the array
					XExist = true;//Let the program know that X now exists
					row = 1;//Place the "master" vertical point of the X
					col = 1;//Place the "master" horizontal point of the X
				}else{
					myArray[row][col]="0";//Remove the X
					XExist = false;//Let the program know the X is gone
					row = 1;//Reset horizontal coordinates for X
					col = 1;//Reset vertical coordinates for X
				}
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
				if(XExist==true){
					if(row!=0){//Make sure the X can move up
						myArray[row][col]="0";//Remove the old X so we don't have duplicates by replacing it with 0 or "air"
						row--;//Move the "master" vertical point up
						myArray[row][col]="X";//Replace the X in the array
					printText();//print array to the user
					}
				}
			}
		});
    }
    private void setButtonClickListenerDown() {
   	 Button toggleButton = (Button)findViewById(R.id.down);
   	 toggleButton.setOnClickListener(new View.OnClickListener() {
			//This is the second of the four directional buttons
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//I'm supposed to move the X down here
				if(XExist==true){
					if(row!=2){//Make sure the X can move down
						myArray[row][col]="0";//Remove the old X so we don't have duplicates by replacing it with 0 or "air"
						row++;//Move the "master" vertical point down
						myArray[row][col]="X";//Replace the X in the array
					printText();//print array to the user
					}
				}
			}
		});
   	}
   	private void setButtonClickListenerRight() {
      	 Button toggleButton = (Button)findViewById(R.id.right);
      	 toggleButton.setOnClickListener(new View.OnClickListener() {
   			//This is the second of the four directional buttons
   			@Override
   			public void onClick(View v) {
   				// TODO Auto-generated method stub
   				//I'm supposed to move the X right here
   				if(XExist==true){
   					if(col!=2){//Make sure the X can move right
	   					myArray[row][col]="0";//Remove the old X so we don't have duplicates by replacing it with 0 or "air"
	   					col++;//Move the "master" horizontal point right
	   					myArray[row][col]="X";//Replace the X in the array
	   				printText();//print array to the user
   					}
   				}
   			}
   		});
   	 }
   	private void setButtonClickListenerLeft() {
     	 Button toggleButton = (Button)findViewById(R.id.left);
     	 toggleButton.setOnClickListener(new View.OnClickListener() {
  			//This is the second of the four directional buttons
  			@Override
  			public void onClick(View v) {
  				// TODO Auto-generated method stub
  				//I'm supposed to move the X left here
  				if(XExist==true){
  					if(col!=0){//Make sure the X can move left
  						myArray[row][col]="0";//Remove the old X so we don't have duplicates by replacing it with 0 or "air"
  						col--;//Move the "master" horizontal point left
  						myArray[row][col]="X";//Replace the X in the array
  					printText();//print array to the user
  					}
  				}
  			}
  		});
  	 }
}
