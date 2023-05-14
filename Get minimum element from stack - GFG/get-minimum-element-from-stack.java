//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    int minEle;
    Stack<Integer> s = new Stack<>();
     ArrayList<Integer> list = new ArrayList<>();

    /*returns min element from stack*/
    int getMin()
    {
         if(list.size()==0)
         return -1;
         return list.get(list.size()-1);
        
	 
    }
    
    /*returns poped element from stack*/
    int pop()
    {
        
        if(s.isEmpty())
        return -1;
        list.remove(list.size()-1);
        return s.pop();
        
	// Your code here	
    }

    /*push element x into the stack*/
    void push(int x)
    {
        s.push(x);
         if(list.size()==0)
         list.add(x);
         else 
         {
             if(list.get(list.size()-1)<x)
             list.add(list.get(list.size()-1));
             else 
             list.add(x);
         }
        
	// Your code here	
    }	
}

