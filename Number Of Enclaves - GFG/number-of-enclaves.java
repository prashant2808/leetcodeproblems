//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
     int numberOfEnclaves(int[][] grid) {
        boolean [][]vis= new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            int j=0;
            if(!vis[i][j]&&grid[i][j]==1)
            bfs(grid,vis,i,j);
            j=grid[0].length-1;
            if(!vis[i][j]&&grid[i][j]==1)
            bfs(grid,vis,i,j);
        }
        for(int j=0;j<grid[0].length;j++)
        {
            int i=0;
            if(!vis[i][j]&&grid[i][j]==1)
            bfs(grid,vis,i,j);
            i=grid.length-1;
            if(!vis[i][j]&&grid[i][j]==1)
            bfs(grid,vis,i,j);
        }
        int ans=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1&&!vis[i][j])
                 ans++;
            }
        } 
        return ans;  
        
    }
    void bfs(int [][]grid,boolean[][]vis,int i,int j)
    {
        if(i==grid.length||j==grid[0].length||i<0||j<0||vis[i][j]||grid[i][j]==0)
        return;
        vis[i][j]=true;
        bfs(grid,vis,i+1,j);
        bfs(grid,vis,i-1,j);
        bfs(grid,vis,i,j+1);
        bfs(grid,vis,i,j-1);
    }
}