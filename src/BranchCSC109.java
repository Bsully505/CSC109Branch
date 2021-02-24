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
        fourBoard = new String[6][7];
        ShowBoard();
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

            int Column  = 0;//this is what the players column is going to be
            if(fourBoard[0][Column]== null){
                int zed = 0;
                boolean pass = true;
                while(zed < fourBoard.length-1 && pass){
                    System.out.println("running search");
                    if(fourBoard[zed+1][Column]!= null){
                        pass = false;
                    }
                    else {
                        zed = zed + 1;
                    }

                }
                //if statment required for whose turn it is
                fourBoard[zed][Column] = "X";
            }
            ShowBoard();
        }

    }
    public void ShowBoard(){
        System.out.println("*_*_*_*_*_*_*_*");
        for(int i = 0; i < fourBoard.length;i++){
            for(int z =0;z< fourBoard[i].length;z++){
                if(fourBoard[i][z] == null){
                    System.out.print("| " );
                }
                else {
                    System.out.print("|" + fourBoard[i][z]);
                }
            }
            System.out.println("|");
            
        }
        System.out.println("*_*_*_*_*_*_*_*");
        System.out.println(" 1 2 3 4 5 6 7");


    }

}
