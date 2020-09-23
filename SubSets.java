//Time Complexity: O(n^2n) n^n is of the recursive call and n is for iterating n times
//Space Complexity: O(1) 

import java.util.*;

public class SubSets {
    public List<List<Integer>> subsets(int[] candidates) {

        List<List<Integer>> c = new ArrayList<>();
        c.add(new ArrayList<>());
        if(candidates.length == 0 || candidates == null)
            return c;
        for(int i=0; i<candidates.length; i++){
            int j=1;
            // j is the length of the sub array
            while(j<=candidates.length){
                recur(candidates, "", i, candidates.length, j, c);
                j++;
            }
        }
        return c;
    }
    
    public void recur(int[] A, String out, int i, int n, int k, List<List<Integer>> c)
	{        
		// invalid input
		if (k > n) {
			return;
		}
		// base case: combination size is k
		if (k == 0) {
			System.out.println(out);
            List<Integer> temp = new ArrayList<>();
            String[] sarr = out.split(" ");
            for(String str : sarr){
                if(!str.equals(""))
                temp.add(Integer.parseInt(str));
            }
            if(!c.contains(temp))
                c.add(temp);
			return;
		}
		// start from next index till last index
		for (int j = i; j < n; j++)
		{
			// add current element A[j] to solution & recur for next index
			// (j+1) with one less element (k-1)
			recur(A, out + " " + (A[j]) , j + 1, n, k - 1, c);
		}
	}

}