import java.util.ArrayList;
import java.util.List;
//Time Complexity : O(2^N) where N is the length of array
//Space Complexity :O(N) where N is the length length of array
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :

public class Subsets {
	 List<List<Integer>> result = new ArrayList<>();
	    
	    public List<List<Integer>> subsets(int[] nums) {
	        if(nums==null || nums.length==0)
	            return result;
	        
	        helperChooseNotChoose(nums,0,new ArrayList<Integer>());
	        
	        return result;
	    }
	    
	    public void helperChooseNotChoose(int[] nums, int idx,List<Integer> path){
	        // base 
	        if(idx==nums.length){
	            result.add(new ArrayList<>(path));
	            return;
	        }
	        //logic 
	        // choose
	        path.add(nums[idx]);
	        helperChooseNotChoose(nums,idx+1,path);
	        path.remove(path.size()-1);
	        //not choose
	        helperChooseNotChoose(nums,idx+1,path); 
	    }
	    
	    
	    public void helperForLooPBacktracking(int[] nums, int idx,List<Integer> path){
	        
	        // base 
	        if(idx==nums.length){
	        result.add(new ArrayList<>(path));
	        return;
	        }
	     
	      result.add(new ArrayList<>(path));
	        
	       for(int i =idx;i<nums.length;i++){
	           path.add(nums[i]);
	           helperForLooPBacktracking(nums,i+1,path);
	           path.remove(path.size()-1);    
	       }
	    }
	    
}
