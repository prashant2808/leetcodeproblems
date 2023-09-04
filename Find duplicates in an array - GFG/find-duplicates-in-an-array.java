//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
         HashMap<Integer,Integer> map= new HashMap<>();
         ArrayList<Integer> res= new ArrayList<>();
         for(int num:arr)map.put(num,map.getOrDefault(num,0)+1);
         for(Map.Entry<Integer,Integer> en:map.entrySet())
         {
             if(en.getValue()>1)res.add(en.getKey());
         }
         if(res.size()==0)
         {
             res.add(-1);
             return res;
         }
         Collections.sort(res);
         return res;
    }
}