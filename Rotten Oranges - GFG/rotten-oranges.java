//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int time;
    int row;
    int col;
    public Pair(int time,int row,int col){
        this.time=time;
        this.row=row;
        this.col=col;
    }
    
}
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
          Queue<Pair> q= new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new Pair(0,i,j));
                }
            }
        }
        int ans=0;
        while(!q.isEmpty())
        {
            Pair p= q.poll();
            int time =p.time;
            int row=p.row;
            int col=p.col;
            ans=time;
            for(int i=-1;i<=1;i++)
            {
                for(int j=-1;j<=1;j++)
                {
                    if(i+j==-2||i+j==2||i+j==0)continue;
                    int nrow=row+i;
                    int ncol=col+j;
                    if(nrow>=0&&ncol>=0&&nrow<grid.length&&ncol<grid[0].length&&grid[nrow][ncol]==1)
                    {
                       grid[nrow][ncol]=2;
                        q.offer(new Pair(time+1,nrow,ncol));
                    }

                }
            }
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            if(grid[i][j]==1)return -1;
        }
        return ans;
        
    }
}