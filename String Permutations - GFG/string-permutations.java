//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String S)
    {
          List<List<Character>> res= new ArrayList();
          char [] nums =S.toCharArray();
         boolean  [] visited = new boolean[nums.length];
   backtrack(nums,new ArrayList(),res,visited);
    ArrayList<String> ans = new ArrayList<>();
    for(int i=0;i<res.size();i++)
    {
        String st="";
        List<Character> temp=res.get(i);
        for(int j=0;j<temp.size();j++)st+=temp.get(j);
        ans.add(st);
        
    }
    Collections.sort(ans);
    return ans;
   
         

        
    }
    void backtrack(char [] nums,List<Character> curr,List<List<Character>> res,boolean[] visited)
    {
         
            if(curr.size()==nums.length){
            res.add(new ArrayList(curr));
            return;
        }
        for(int j=0;j<nums.length;j++){ 
            if(visited[j])continue;
        curr.add(nums[j]);
        visited[j]=true;
        backtrack(nums,curr,res,visited);
        curr.remove(curr.size()-1);
        visited[j]=false;
         
    }
    }
	   
}
