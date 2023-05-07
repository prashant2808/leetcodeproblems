//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
        if(S.length()<=1)
        return 1;
        
        char ch1=S.charAt(0);
        char ch2=S.charAt(S.length()-1);
        if(ch1==ch2)
         return isPalindrome(S.substring(1,S.length()-1));
        
        return 0;
        
        
        // code here
    }
    
};