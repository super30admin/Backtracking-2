package sol;


import java.util.*;

public class subset {
	 public void helper(List<Integer>l, int p, int[]nums,List<List<Integer>>l1){
	        
	        if(p>nums.length){return;}
	        if(p==nums.length){
	            l1.add(new ArrayList(l));
	            return;
	        }
	        l.add(nums[p]);
	        helper(l,p+1,nums,l1);
	        l.remove(l.size()-1);
	        
	        helper(l,p+1,nums,l1);
	    
	    }
	    
	    
	    public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> l1= new ArrayList<>();
	        List<Integer> l= new ArrayList<>();
	        helper(l,0,nums,l1);
	        return l1;
	        
	    }
}
