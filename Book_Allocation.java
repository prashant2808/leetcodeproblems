import java.util.ArrayList;
public class Solution {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if(n<m)return -1;
        int sum=0;
        for(int i=0;i<arr.size();i++)sum+=arr.get(i);
        int ans=-1;
        int lo=1;
        int hi=sum;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(arr,mid,m)){
                ans=mid;
                hi=mid-1;
            }
            else {
                lo=mid+1;
            }
        }
         return ans;
    }
   static  boolean isPossible(ArrayList<Integer> pages,int mid,int m){
       int students=1;
       int currsum=0;
       for(int i=0;i<pages.size();i++){
           if(pages.get(i)>mid)return false;
           if(currsum+pages.get(i)>mid){
               students++;
               currsum=pages.get(i);

           }
           else {
               currsum+=pages.get(i);
           }
           if(students>m)return false;

       }
       return students<=m;
   }
}
