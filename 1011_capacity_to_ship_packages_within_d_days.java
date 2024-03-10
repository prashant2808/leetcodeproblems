class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        int min=weights[0];
        for(int i=0;i<weights.length;i++){
        min=Math.min(min,weights[i]);
        sum+=weights[i];
        }
        int ans=sum;
         int lo=min;
         int hi=sum;
         while(lo<=hi){
             int midcapacity=lo+(hi-lo)/2;
             if(isPossible(weights,midcapacity,days)){
                 ans=midcapacity;
                 hi=midcapacity-1;
             }
             else {
                 lo=midcapacity+1;
             }
         }
         return ans;
        
    }
    boolean isPossible(int [] weights,int capacity,int days){
        int currdays=1;
        int currwt=0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]>capacity)return false;
            if(currwt+weights[i]>capacity){
                currdays++;
                currwt=weights[i];
            }
            else {
                currwt+=weights[i];
            }

        }
        return currdays<=days;

    }
}
