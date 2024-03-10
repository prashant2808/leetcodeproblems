 //TABULATION
class Solution {
    public int minCut(String s) {
        int n=s.length();
        int [] dp= new int [n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int minCuts=Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            if(isPalindrome(i,j,s)){
                int cuts=1+dp[j+1];
                minCuts=Math.min(minCuts,cuts);
            }
        }
        dp[i]=minCuts;

        }
       return dp[0]-1;   
    }
    /*   RECURSION -> MEMOIZATION 
    int partition(int i,String s,int []dp){
        if(i==s.length())return 0;
        if(dp[i]!=-1)return dp[i];
        int minCuts=Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            if(isPalindrome(i,j,s)){
                int cuts=1+partition(j+1,s,dp);
                minCuts=Math.min(minCuts,cuts);
            }
        }
        return dp[i]=minCuts;
    }
    */
    boolean isPalindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    
}
