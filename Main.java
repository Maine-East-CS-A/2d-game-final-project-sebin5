import java.util.*;

public class Main{
    

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Miners, input length and width for your mine");
        int len = scan.nextInt();
        int wid = scan.nextInt();
        Mine cave = new Mine(len, wid);
        int money = 100;
        int score = 100;
        System.out.println("Rules are there are 5 rounds to collect treasure and each square is randomized, score as much as you can and use the coins from your mines to use abilites. You start with 100");
        for (int[] hole: cave.getArr()){
            for (int element: hole){
                System.out.print(element + " ");
            }
            System.out.println();
        }
        int countdown = 5;
        while (countdown > 0){
            System.out.println("Choose a spot to mine(m) or use an ability (a), Current Money: " + money);
            String act = scan.nextLine();
            if (act.toLowerCase().equals("m")){
                System.out.println("Input row and column for spot");
                int hit = scan.nextInt();
                int make = scan.nextInt();
                money += cave.mineSpace(hit, make);
                score += (cave.mineSpace(hit, make))*10;
                for (int[] hole: cave.getArr()){
                    for (int element: hole){
                        System.out.print(element);
                    }
                    System.out.println();
                }

            }


            else if (act.toLowerCase().equals("a")){
                if (cave.abilityActive(money) == false){
                    System.out.println("Sorry, need more money");
                }

                else{
                    System.out.println("Would you like to remove a row or colomun?(r/c)");
                    if(scan.nextLine().toLowerCase().equals("r")){
                        System.out.println("Which row?");
                        int pick = scan.nextInt();
                        for (int i = pick; i < pick+1; i++){
                            for (int j = 0; j > cave.getArr()[i].length; j++){
                                cave.getArr()[i][j] = (int)((Math.random()*100)+1);
                                money += cave.getArr()[i][j];
                                score += cave.getArr()[i][j] * 10;
                            }
                        }
                        cave.changeF();
                        for (int[] hole: cave.getArr()){
                            for (int element: hole){
                                System.out.print(element);
                            }
                            System.out.println();
                        }
                    }

                    else if (scan.nextLine().toLowerCase().equals("c")){
                        System.out.println("Which column?");
                        int which = scan.nextInt();
                        for (int h = 0; h < cave.getArr().length; h++){
                            for (int k = which; k < which+1; k++){
                                cave.getArr()[h][k] = (int)((Math.random()*100)+1);
                                money += cave.getArr()[h][k];
                                score += cave.getArr()[h][k] * 10;
                            }
                        }
                        cave.changeF();

                        for (int[] hole: cave.getArr()){
                            for (int element: hole){
                                System.out.print(element);
                            }
                            System.out.println();
                        }
                    }
                }

            }
            countdown--;
        }

        System.out.println("You ended with $" + money + " and final score of " + score + " points");
    }
}
 