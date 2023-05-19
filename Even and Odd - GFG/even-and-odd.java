//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            ob.reArrange(arr,N);
            
            System.out.println(check(arr,N));
        }
    }
    static int check(int arr[], int n)
    {
        int flag = 1;
        int c=0, d=0;
        for(int i=0; i<n; i++)
        {
            if(i%2==0)
            {
                if(arr[i]%2==1)
                {
                    flag = 0;
                    break;
                }
                else
                    c++;
            }
            else
            {
                if(arr[i]%2==0)
                {
                    flag = 0;
                    break;
                }
                else
                    d++;
            }
        }
        if(c!=d)
            flag = 0;
                
        return flag;
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static void reArrange(int[] arr, int N) {
         int i=0;
         int j=1;
         while(i<arr.length&&j<arr.length)
         {
             if(i<arr.length&&j<arr.length&&arr[i]%2==0&&arr[j]%2==1)
             {
                 i+=2;
                 j+=2;
             }
             if(i<arr.length&&j<arr.length&&arr[i]%2==1&&arr[j]%2==0)
             {
                 swap(arr,i,j);
                 i+=2;
                 j+=2;
             }
             if(i<arr.length&&j<arr.length&&arr[i]%2==1&&arr[j]%2==1)
             {
                 j+=2;
             }
             if(i<arr.length&&j<arr.length&&arr[i]%2==0&&arr[j]%2==0)
             {
                 i+=2;
             }
            
             
         }
    }
   static void swap(int [] arr ,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}