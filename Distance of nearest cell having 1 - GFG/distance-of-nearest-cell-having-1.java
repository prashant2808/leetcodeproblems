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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Pair{
    int row;
    int col;
    int height;
    public Pair(int row,int col,int height){
        this.row=row;
        this.col=col;
        this.height=height;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int [][]res= new int [grid.length][grid[0].length];
        boolean [][]vis =new boolean[grid.length][grid[0].length];
        Queue<Pair> q= new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1){
                vis[i][j]=true;
                q.offer(new Pair(i,j,0));
                
                }
            }
        }
         int [] nrow={1,0,-1,0};
         int [] ncol={0,1,0,-1};
         while(!q.isEmpty())
        {
             Pair p= q.poll();
             int row=p.row;
             int col=p.col;
             int height=p.height;
             res[row][col]=height;
             for(int i=0;i<4;i++)
             {
                 int newrow=row+nrow[i];
                 int newcol=col+ncol[i];
                 if(newrow>=0&&newcol>=0&&newrow<grid.length&&newcol<grid[0].length&&!vis[newrow][newcol])
                 {
                     vis[newrow][newcol]=true;
                     q.offer(new Pair(newrow,newcol,height+1));
                 }
             }
         }
         return res;
    }
    
}