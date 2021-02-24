/**
 * author: Bryan Sullivan
 * Date: Tuesday Feb 23
 *
 */

import java.util.Scanner;

public class BranchCSC109 {
    String[][] fourBoard;
    String Player1;
    String Player2;
    Scanner input ;
    boolean win;
    public BranchCSC109(){
        fourBoard = new String[7][6];
        input =  new Scanner(System.in);
        win = false;
        run();
    }
    public static void main(String[] args){
        BranchCSC109 Connectfour = new BranchCSC109();

    }
    public void run(){
        System.out.println("please enter player 1's name");
        Player1 = input.nextLine();
        System.out.println("please enter player 2's name");
        Player2 = input.nextLine();
        System.out.println("Welcome to my connect four game "+Player1+" and "+ Player2);
        //im going to have to incorporate populating the
        System.out.println("Rules: \n1)Player one is x and goes first \n" +
                "2)First player with a continuation of 4 wins \n3)When playing your turn you can only go in a not full column of 1 through 7");

        while(!win){
            System.out.println("Please enter which column you are dropping your tocken in");
            String Col = input.nextLine();

        }

    }

}
