//Mining game
import java.util.*;
import java.lang.*;
public class Mine{
    private int [][] cave;
    private boolean special;

    public Mine(){
        cave = new int [5][5];
        special = false;
    }

    public int [][] getArr(){
        return cave;
    }

    public Mine(int rows, int cols){
        cave = new int [rows][cols]; 
        special = false;
    }

    public int mineSpace (int row, int col){
        if (row < cave.length){
            if (col < cave[row].length){
                cave[row][col] = (int)((Math.random()*100)+1);
            }
        }

        return cave[row][col];
    }

    public boolean checkAA(){
        return special;
    }
    
    public boolean abilityActive(int money){
        if (money >= 100){
            money -= 100;
            special = true;
        }

        else{
            special = false;
        }

        return special;
    }

    public void changeF(){
        special = false;
    }


}

