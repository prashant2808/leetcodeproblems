//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
          int m=grid.length;
        int n=grid[0].length;
       boolean [][] vis=new boolean[m][n];
       int count =0;
       for(int i=0;i<m;i++)
       {
           for(int j=0;j<n;j++)
           {
               if(!vis[i][j]&&grid[i][j]=='1')
               {
                   dfs(i,j,grid,vis);
                   count++;
               }

           }
       }
       return count ;
         
    }
     private static void dfs(int i,int j,char[][]grid,boolean[][]vis)
    {
        if(i==grid.length||j==grid[0].length||i<0||j<0||grid[i][j]!='1'||vis[i][j])
        return;
        vis[i][j]=true;
        for(int x=-1;x<=1;x++)
        {
            for(int y=-1;y<=1;y++)
            {
                dfs(i+x,j+y,grid,vis);
            }
        }
        
    }
}