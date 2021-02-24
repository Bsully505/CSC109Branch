import java.util.Scanner;

public class BranchCSC109 {
    String[][] fourBoard;
    String Player1;
    String Player2;
    Scanner input ;
    public BranchCSC109(){
        fourBoard = new String[7][6];
        input =  new Scanner(System.in);
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


    }

}
