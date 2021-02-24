/**
 * author: Bryan Sullivan
 * Date: Tuesday Feb 23
 *
 * Still need to implement: diagonal winning
 * Possible ideas to add on: playing again after someone has won or a stalemate, a quit command
 */

import java.util.Scanner;

public class BranchCSC109 {
    String[][] fourBoard;
    String Player1 = "Bob";
    String Player2 = "Dylan";
    Scanner input ;
    int MoveNum;
    boolean win;
    public BranchCSC109(){
        fourBoard = new String[6][7];
        ShowBoard();
        input =  new Scanner(System.in);
        win = false;
        MoveNum = 0;
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
        System.out.println("Rules: \n1)Player one is x and goes first \n" +
                "2)First player with a continuation of 4 wins \n3)When playing your turn you can only go in a not full column of 1 through 7");
        boolean turner = true;
        while(!win && MoveNum < 42){

            System.out.println("Please enter which column you are dropping your tocken in");
            boolean flagger = true;
            boolean ColFlag = true;
            int Column =-1;
            while(ColFlag) {
                while (flagger) {
                    String Col = input.nextLine();
                    try {
                        Column = Integer.parseInt(Col) - 1;
                        if (Column >= 0 && Column < 7) {
                            flagger = false;
                        } else {
                            System.out.println("please enter a number 1 through 7 ex. 3");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("You did not enter a number, please enter a number 1 through 7 ex. 3");
                    }

                }

                if (fourBoard[0][Column] == null) {
                    ColFlag = false;
                    int zed = 0;
                    boolean pass = true;
                    while (zed < fourBoard.length - 1 && pass) {
                        System.out.println("running search");
                        if (fourBoard[zed + 1][Column] != null) {
                            pass = false;
                        } else {
                            zed = zed + 1;
                        }

                    }
                    //if statment required for whose turn it is
                    if (turner) {
                        fourBoard[zed][Column] = "X";
                        win = DidWin(Column, zed);
                        turner = false;
                        MoveNum++;
                    } else {
                        fourBoard[zed][Column] = "0";
                        turner = true;
                        win = DidWin(Column, zed);
                        MoveNum++;
                    }
                } else {
                    System.out.println("This slot is full. Choose another.");
                    flagger = true;
                }
            }
            ShowBoard();
        }
        if(win) {
            if (!turner) {
                System.out.println("the winner is " + Player1);
            } else {
                System.out.println("the winner is " + Player2);
            }
        }
        else{
            System.out.println("it seems like no one has won :(");
        }
        //also if the whole board is played i will have to say that no one has won.

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
    public boolean DidWin(int col, int row){
        String plrSign = fourBoard[row][col];
        String key = plrSign + plrSign+ plrSign+ plrSign;
        //horizontal check
        String rower ="";
        String coller ="";
        String negDiagonal = "";
        String posDiagonal = "";
        for(int i =0;i<fourBoard[row].length; i++) {
            if (fourBoard[row][i] == null){
                rower += "Z";
            }
            else {
                rower += fourBoard[row][i];
            }
        }
        System.out.println(rower);

        if(rower.contains(key)){
            return true;
        }
        //vertical test
        for(int i = 0;i< fourBoard.length; i++) {
            if (fourBoard[i][col] == null) {
                coller += "Z";
            }
            else {
                coller += fourBoard[i][col];
            }
        }
        if(coller.contains(key)){
            return true;
        }

        return false;
    }

}
