package com.example.project1;

import java.util.Random;


import android.os.Bundle;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class ExpertActivity extends Activity {
	  public int c[][];
	    static public int i, j, k = 0;
	    public Button b[][];
	    public TextView textView;
	    AI ai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert);
        textView=(TextView) findViewById(R.id.textView1);
        setBoard();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
         MenuItem item = menu.add("New Game");
         return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
         setBoard();
         return true;
    }

    public void setBoard() {
         ai = new AI();
         b = new Button[5][5];
         c = new int[5][5];


         textView = (TextView) findViewById(R.id.textView1);

         b[1][4] = (Button) findViewById(R.id.button8);
         b[1][3] = (Button) findViewById(R.id.button7);
         b[1][2] = (Button) findViewById(R.id.button6);
         b[1][1] = (Button) findViewById(R.id.button5);

         b[2][4] = (Button) findViewById(R.id.button4);
         b[2][3] = (Button) findViewById(R.id.button3);
         b[2][2] = (Button) findViewById(R.id.button1);
         b[2][1] = (Button) findViewById(R.id.two);

         b[3][4] = (Button) findViewById(R.id.button2);
         b[3][3] = (Button) findViewById(R.id.three);
         b[3][2] = (Button) findViewById(R.id.five);
         b[3][1] = (Button) findViewById(R.id.six);
         
         b[4][4] = (Button) findViewById(R.id.one);
         b[4][3] = (Button) findViewById(R.id.four);
         b[4][2] = (Button) findViewById(R.id.seven);
         b[4][1] = (Button) findViewById(R.id.nine);
        
         for (i = 1; i <= 4; i++) {
              for (j = 1; j <= 4; j++)
                   c[i][j] = 2;
         }


         textView.setText("Click a button to start.");

         for (i = 1; i <=4; i++) {
              for (j = 1; j <=4; j++) {
                   b[i][j].setOnClickListener(new MyClickListener(i, j));
                   if(!b[i][j].isEnabled()) {
                        b[i][j].setText(" ");
                        b[i][j].setEnabled(true);
                   }
              }
         }
    }
    public class MyClickListener extends AI implements View.OnClickListener {
    	int x;
    	int y;

    	public MyClickListener(int x, int y) {
    		// TODO Auto-generated constructor stub
    		 this.x = x;
             this.y = y;
    	}
    	  public void onClick(View view) 
    	  {
              if(b[x][y].isEnabled()) 
              {
                   b[x][y].setEnabled(false);
                   b[x][y].setText("O");
                   c[x][y] = 0;
                   textView.setText("");
                   if (!checkBoard()) 
                   {
                        ai.takeTurn();
                   }
              }
         }
    }

    private class AI
    {
        public void takeTurn() 
        {
        //int[][] c;
    	if(c[1][1]==2 &&((c[1][2]==0 && c[1][3]==0 && c[1][4]==0) ||(c[2][2]==0 && c[3][3]==0 && c[4][4]==0) ||(c[2][1]==0 && c[3][1]==0 && c[4][1]==0))) 
        {
             markSquare(1,1);
        }
        else if (c[1][2]==2 &&((c[2][2]==0 && c[3][2]==0&&c[4][2]==0) ||(c[1][1]==0 && c[1][3]==0&&c[1][4]==0))) 
        {
             markSquare(1,2);
        } 
        else if(c[1][3]==2 &&((c[1][1]==0 && c[1][2]==0&&c[1][4]==0) ||(c[2][3]==0 && c[3][3]==0&&c[4][3]==0))) 
        {
             markSquare(1,3);
        }
        else if(c[1][4]==2&&((c[2][3]==0&&c[3][2]==0&&c[4][1]==0)||(c[2][4]==0&&c[3][4]==0&&c[4][4]==0)||(c[1][1]==0&&c[1][2]==0&&c[1][3]==0)))
        		{
        	 markSquare(1,4);
        		}
        else if(c[2][1]==2 &&((c[2][2]==0 && c[2][3]==0&&c[2][4]==0) ||(c[1][1]==0 && c[3][1]==0&&c[4][1]==0)))
        {
             markSquare(2,1);
        }
        else if(c[2][2]==2 &&((c[1][1]==0 && c[3][3]==0 && c[4][4]==0) ||(c[1][2]==0 && c[3][2]==0&&c[4][2]==0) ||(c[2][1]==0 && c[2][3]==0&&c[2][4]==0))) 
        {
             markSquare(2,2);
        }
        else if(c[2][3]==2 &&((c[2][1]==0 && c[2][2]==0&&c[2][4]==0) ||(c[1][3]==0 && c[3][3]==0&&c[4][3]==0)||(c[1][4]==0&&c[3][2]==0&&c[4][1]==0))) 
        {
             markSquare(2,3);
        }
        else if(c[2][4]==2 &&((c[1][4]==0 && c[3][4]==0 && c[4][4]==0) ||(c[2][1]==0 && c[2][2]==0&&c[2][3]==0))) 
        {
             markSquare(2,4);
        }
        else if(c[3][1]==2 &&((c[1][1]==0 && c[2][1]==0&&c[4][1]==0) ||(c[3][2]==0 && c[3][3]==0&&c[3][4]==0)))
        {
             markSquare(3,1);
        } 
        else if(c[3][2]==2 &&((c[1][2]==0 && c[2][2]==0&&c[4][2]==0) ||(c[3][1]==0 && c[3][3]==0&&c[3][4]==0)||(c[1][4]==0&&c[2][3]==0&&c[4][1]==0))) 
        {
             markSquare(3,2);
        }
        else if( c[3][3]==2 &&((c[1][1]==0 && c[2][2]==0&&c[4][4]==0) ||(c[1][3]==0 && c[2][3]==0&&c[4][3]==0) ||(c[3][1]==0 && c[3][2]==0&&c[3][4]==0))) 
        {
             markSquare(3,3);
        } 
        else if(c[3][4]==2 &&((c[3][1]==0 && c[3][2]==0 && c[3][3]==0) ||(c[1][4]==0 && c[2][4]==0&&c[4][4]==0))) 
        {
             markSquare(3,4);
        }
        else if(c[4][1]==2 &&((c[1][1]==0 && c[2][1]==0 && c[3][1]==0) ||(c[4][2]==0 && c[4][3]==0&&c[4][4]==0) ||(c[3][2]==0 && c[2][3]==0&&c[1][4]==0))) 
        {
             markSquare(4,1);
        }
        else if(c[4][2]==2 &&((c[4][1]==0 && c[4][3]==0 && c[4][4]==0) ||(c[1][2]==0 && c[2][2]==0&&c[3][2]==0) )) 
        {
             markSquare(4,2);
        }
        else if(c[4][3]==2 &&((c[4][1]==0 && c[4][2]==0 && c[4][3]==0) ||(c[1][4]==0 && c[2][4]==0&&c[2][4]==0))) 
        {
             markSquare(4,3);
        }
        else if(c[4][4]==2 &&((c[4][1]==0 && c[4][2]==0 && c[4][3]==0) ||(c[1][1]==0 && c[2][2]==0&&c[3][3]==0) ||(c[1][4]==0 && c[2][4]==0&&c[3][4]==0))) 
        {
             markSquare(4,4);
        }
        else 
        {
             Random rand = new Random();
             
             int a = rand.nextInt(4);
             int b1 = rand.nextInt(4);
             while(a==0 || b1==0 || c[a][b1]!=2) 
             {
                  a = rand.nextInt(4);
                  b1 = rand.nextInt(4);
             }
             markSquare(a,b1);
        }
    }


        public void markSquare(int x, int y) 
        {
           
    		b[x][y].setEnabled(false);
             b[x][y].setText("X");
             c[x][y] = 1;
             checkBoard();
        }



    // check the board to see if someone has won
    public boolean checkBoard() {
        boolean gameOver = false;
        if ((c[1][1] == 0 && c[2][2] == 0 && c[3][3] == 0 && c[4][4]==0)
                  || (c[1][4] == 0 && c[2][3] == 0 && c[3][2] == 0 && c[4][1]==0)
                  || (c[1][2] == 0 && c[2][2] == 0 && c[3][2] == 0 && c[4][2]==0)
                  || (c[1][3] == 0 && c[2][3] == 0 && c[3][3] == 0 && c[4][3]==0)
                  || (c[1][1] == 0 && c[1][2] == 0 && c[1][3] == 0 && c[1][4]==0)
                  || (c[2][1] == 0 && c[2][2] == 0 && c[2][3] == 0 && c[2][4]==0)
                  || (c[3][1] == 0 && c[3][2] == 0 && c[3][3] == 0 && c[3][4]==0)
                  || (c[1][1] == 0 && c[2][1] == 0 && c[3][1] == 0 && c[4][1]==0)
                  || (c[1][4] == 0 && c[2][4] == 0 && c[3][4] == 0 && c[4][4]==0)
                  || (c[4][1] == 0 && c[4][2] == 0 && c[4][3] == 0 && c[4][4]==0)) 
        {
             textView.setText("Game over. You win!");
             gameOver = true;
        } 
        else if ((c[1][1] == 1 && c[2][2] == 1 && c[3][3] == 1 && c[4][4]==1)
                || (c[1][4] == 1 && c[2][3] == 1 && c[3][2] == 1 && c[4][1]==1)
                || (c[1][2] == 1 && c[2][2] == 1 && c[3][2] == 1 && c[4][2]==1)
                || (c[1][3] == 1 && c[2][3] == 1 && c[3][3] == 1 && c[4][3]==1)
                || (c[1][1] == 1 && c[1][2] == 1 && c[1][3] == 1 && c[1][4]==1)
                || (c[2][1] == 1 && c[2][2] == 1 && c[2][3] == 1 && c[2][4]==1)
                || (c[3][1] == 1 && c[3][2] == 1 && c[3][3] == 1 && c[3][4]==1)
                || (c[1][1] == 1 && c[2][1] == 1 && c[3][1] == 1 && c[4][1]==1)
                || (c[1][4] == 1 && c[2][4] == 1 && c[3][4] == 1 && c[4][4]==1)
                || (c[4][1] == 1 && c[4][2] == 1 && c[4][3] == 1 && c[4][4]==1)) 
        {
             textView.setText("Game over. You lost!");
             gameOver = true;
        } 
        else 
        {
             boolean empty = false;
             for(int i=1; i<=3; i++) {
                  for(int j=1; j<=3; j++) {
                       if(c[i][j]==2) {
                            empty = true;
                            break;
                       }
                  }
             }
             if(!empty) {
                  gameOver = true;
                  textView.setText("Game over. It's a draw!");
             }
        }
        return gameOver;
    }
    }

}
