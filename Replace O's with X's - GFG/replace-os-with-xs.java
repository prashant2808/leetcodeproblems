//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
         boolean [][]vis= new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            int j=0;
            if(!vis[i][j]&&a[i][j]=='O')
            bfs(a,vis,i,j);
            j=m-1;
            if(!vis[i][j]&&a[i][j]=='O')
            bfs(a,vis,i,j);
        }
        for(int j=0;j<m;j++)
        {
            int i=0;
            if(!vis[i][j]&&a[i][j]=='O')
            bfs(a,vis,i,j);
            i=n-1;
            if(!vis[i][j]&&a[i][j]=='O')
            bfs(a,vis,i,j);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a[i][j]=='O'&&!vis[i][j])
                a[i][j]='X';
            }
        }  
        return a;
         
    }
    static  void bfs(char[][]grid,boolean[][]vis,int i,int j)
    {
        if(i==grid.length||j==grid[0].length||i<0||j<0||vis[i][j]||grid[i][j]=='X')
        return;
        vis[i][j]=true;
        bfs(grid,vis,i+1,j);
        bfs(grid,vis,i-1,j);
        bfs(grid,vis,i,j+1);
        bfs(grid,vis,i,j-1);
    }
}