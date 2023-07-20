//{ Driver Code Starts
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
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean [][] vis = new boolean [m][n];
        HashSet<ArrayList<ArrayList<Integer>>>set = new HashSet<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!vis[i][j]&&grid[i][j]==1)
                { 
                ArrayList<ArrayList<Integer>> dist= new ArrayList<>();
                  dfs(grid,i,j,vis,dist,i,j);
                  set.add(dist);
                }
            }
        }
        return set.size();
    }
    void dfs(int [][]grid,int i,int j,boolean [][]vis,ArrayList<ArrayList<Integer>> dist,int row0,int col0)
    {
        vis[i][j]=true;
         ArrayList<Integer> li= new ArrayList<>();
         li.add(i-row0);
         li.add(j-col0);
         dist.add(li);
        int m=grid.length;
        int n= grid[0].length;
        int [] delrow={1,0,-1,0};
        int [] delcol={0,1,0,-1};
        for(int k=0;k<4;k++)
        {
            int nrow=i+delrow[k];
            int ncol=j+delcol[k];
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&!vis[nrow][ncol]&&grid[nrow][ncol]==1)
            dfs(grid,nrow,ncol,vis,dist,row0,col0);
        }
    }
}
