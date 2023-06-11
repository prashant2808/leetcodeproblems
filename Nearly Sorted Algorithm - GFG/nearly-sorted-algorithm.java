/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
 Scanner  sc= new Scanner(System.in);
     int t=sc.nextInt();
     while(t-->0)
     {
         int n=sc.nextInt();
         int k=sc.nextInt();
         int arr[]= new int [n];
         for(int i=0;i<n;i++)
         {
             arr[i]=sc.nextInt();
         }
         PriorityQueue<Integer> pq= new PriorityQueue<>();
         int ans[]=new int [n];
         int j=0;
         for(int i=0;i<n;i++)
         {
             pq.add(arr[i]);
             if(pq.size()>k)
             {
                 ans[j]=pq.remove();
                 j++;
             }
             
             
         }
         while(pq.size()>0)
         {
             ans[j]=pq.remove();
             j++;
         }
         for(int num:ans)
         {
             System.out.print(num+" ");
         }
         System.out.println();
         
         
     }
 
	 
	}
}