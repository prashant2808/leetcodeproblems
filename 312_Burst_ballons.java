 // SIMPLE RECURSIVE SOLUTION
class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> ballons= new ArrayList<>();
        ballons.add(1);
        for(int i=0;i<n;i++)ballons.add(nums[i]);
        ballons.add(1);
        return coins(ballons,1,n);
    }
    int coins(ArrayList<Integer> nums,int i,int j){
        if(i>j)return 0;
        int max= Integer.MIN_VALUE;
        for(int id=i;id<=j;id++){
            int cost=nums.get(i-1)*nums.get(id)*nums.get(j+1)+coins(nums,i,id-1)+coins(nums,id+1,j);
            max=Math.max(max,cost);
        }
        return max;
    }
}

// MEMOIZATION  SOLUTION 
class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> ballons= new ArrayList<>();
        ballons.add(1);
        for(int i=0;i<n;i++)ballons.add(nums[i]);
        ballons.add(1);
        int [][] dp= new int [n+2][n+2];
        for(int i=0;i<n+2;i++)Arrays.fill(dp[i],-1);
        return coins(ballons,1,n,dp);
    }
    int coins(ArrayList<Integer> nums,int i,int j,int [][] dp){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int max= Integer.MIN_VALUE;
        for(int id=i;id<=j;id++){
            int cost=nums.get(i-1)*nums.get(id)*nums.get(j+1)+coins(nums,i,id-1,dp)+coins(nums,id+1,j,dp);
            max=Math.max(max,cost);
        }
        return dp[i][j]=max;
    }
}

// TABULATION SOLUTION
class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> ballons= new ArrayList<>();
        ballons.add(1);
        for(int i=0;i<n;i++)ballons.add(nums[i]);
        ballons.add(1);
        int [][] dp= new int [n+2][n+2];
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j)continue;
                int max=Integer.MIN_VALUE;
                for(int id=i;id<=j;id++){
                    int cost=ballons.get(i-1)*ballons.get(id)*ballons.get(j+1)+dp[i][id-1]+dp[id+1][j];
                    max=Math.max(max,cost);
                }
                dp[i][j]=max;
            }
        }
        return dp[1][n];
    }
}
