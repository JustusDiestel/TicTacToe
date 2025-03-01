
import java.util.*;
import java.util.Set;
import java.util.HashSet;

public class main{
    static char[][] board;
    static int count = 0;
    static Set<Integer> unique;
    static char playerIcon;
    
    
    public static void main(String[] args){
        main t = new main();
        unique = new HashSet<Integer>();
        board = t.createBoard();
        t.printBoard();
        t.play();
    }


    public char[][] createBoard(){
        char[][] board = {
        { ' ', 'I' , ' ', 'I', ' '}, 
        { '-', '+' , '-', '+', '-'},
        { ' ', 'I' , ' ', 'I', ' '},
        { '-', '+' , '-', '+', '-'},
        { ' ', 'I' , ' ', 'I', ' '} };

        return board;
    }

    public void printBoard(){
        System.out.println("------------");
        for(char[] c: board){
            for(char cc: c){
                System.out.print(cc);
            }
            System.out.println();
        }

        System.out.println("------------");
    }

    public void action(Scanner scan){
        int i = scan.nextInt();
        if(unique.contains(i)) {
            System.out.println("Üngultig, neue Zahl bitte!");
            return;
        } 


        unique.add(i);
        playerIcon = 'X';

        if (count%2 == 1) {
            playerIcon = 'O';
        } 

        

        switch (i){
            case 1: board[0][0] = playerIcon; break;
            case 2: board[0][2] = playerIcon; break;
            case 3: board[0][4] = playerIcon; break;
            case 4: board[2][0] = playerIcon; break;
            case 5: board[2][2] = playerIcon; break;
            case 6: board[2][4] = playerIcon; break;
            case 7: board[4][0] = playerIcon; break;
            case 8: board[4][2] = playerIcon; break;
            case 9: board[4][4] = playerIcon; break;
            default: assert(false): "Ungültig";
        }

        if( i > 0 && i <= 9){
            count++;
        } else {System.out.println("Neue, gültige Eingabe bitte!");}
        
        printBoard();
    }


    public void play(){
        Scanner scan = new Scanner(System.in);
        
        do{ action(scan);
        }while (count <= 9 && checkThree() == true);
        

    }

    public Boolean checkThree(){
        if (board[0][0] == playerIcon && board[0][0] == board[0][2] && board[0][0] == board[0][4] || 
        board[0][0] == playerIcon && board[0][0] == board[2][0] && board[0][0] == board[4][0] || 
        board[0][0] == playerIcon && board[0][0] == board[2][2] && board[0][0] == board[4][4] ||
        board[2][0] == playerIcon && board[2][0] == board[2][2] && board[2][0] == board[2][4] ||
        board[4][0] == playerIcon && board[4][0] == board[4][2] && board[4][0] == board[4][4] ||
        board[0][2] == playerIcon && board[0][2] == board[2][2] && board[0][2] == board[2][4] ||
        board[0][4] == playerIcon && board[0][4] == board[2][4] && board[0][4] == board[4][4]){
            System.out.println("Drei in einer Reihe, Spiel vorbei:)");
            return false;
        } 
        return true;
    }
}