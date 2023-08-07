//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        return solve(grid);
    }
     static boolean solve(int [][]board){
        for(int row=0;row<board.length;row++)
        {
            for(int col=0;col<board.length;col++)
            {
                if(board[row][col]==0)
                {
                    for(int val=1;val<=9;val++)
                    {
                        if(isSafe(board,row,col,val))
                        {
                            board[row][col]=val;
                            boolean next=solve(board);
                            if(next)
                            {
                                return true;
                            }
                            else 
                            board[row][col]=0;
                        }
                    }
                     return false;
                     
                }
                 
                 
            }
        }
        return true;
    }
    static boolean isSafe(int[][] board,int row,int col,int num)
    {
        //check for row 
        for(int i=0;i<board.length;i++)
        {
            if(board[row][i]==num)
            return false;
        }
        //check for column
        for(int [] x:board)
        {
            if(x[col]==num)
            return false;
        }
        int sqrt=(int)(Math.sqrt(board.length));
        int rowstart=row-row%sqrt;
        int colstart=col-col%sqrt;

        for(int r=rowstart;r<rowstart+sqrt;r++)
        {
           for(int c=colstart;c<colstart+sqrt;c++)
           {
               if(board[r][c]==num)
               return false;
           }
        }
        return true;


    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
                System.out.print(grid[i][j]+" ");
            }
        }
        
    }
}