package patterns.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
https://leetcode.com/problems/n-queens-ii/description/
logic is same as nqueen I
 */
public class NQueensII {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalNQueens(n));//2
    }
    public static int totalNQueens(int n) {
        int[][] chess = new int[n][n];
        List < List < String >> res = new ArrayList<List< String >>();
        printNQueen(chess,0, res);
        //System.out.println("At the end res is : "+ res);

        return res.size();
    }
    private static void printNQueen(int[][] b,int r,List<List<String>> res){
        if(r == b.length){
            //prinArray(b);
            res.add(construct(b));
            return;
        }

        for(int c = 0; c < b[0].length; c++){
            if(isSafe(b,r,c)){
                b[r][c] = 1;
                printNQueen(b,r+1,res);
                b[r][c] = 0;
            }
        }

    }

    private static boolean isSafe(int[][] b,int r, int c){

        //for column
        for(int i = r-1; i>=0 ; i--){
            if(b[i][c] == 1)
                return false;
        }

        //for left diagonal
        for(int i = r-1,j = c-1; i>=0 && j >=0; i--,j--){
            if(b[i][j] == 1)
                return false;
        }

        //for left diagonal
        for(int i = r-1, j = c+1; i>=0 && j < b[0].length; i--,j++){
            if(b[i][j] == 1)
                return false;
        }
        return true;

    }
    static List< String > construct(int[][] board) {
        List < String > res = new LinkedList< String >();
        for (int i = 0; i < board.length; i++) {
            String s = new String("");
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1){
                    s +='Q';
                }else {
                    s+='.';
                }
            }
            res.add(s);
        }
        return res;
    }
}
