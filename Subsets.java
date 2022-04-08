import java.util.ArrayList;
import java.util.List;


//Time Complexity: Exponential. O(2^n)
//Space Complexity: O(n) 
public class Subsets {	
	/**Approach 1: ITERATIVE**/
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();        
        if(nums==null || nums.length==0) return res;    
        res.add(new ArrayList<>());        
        for(int i=0; i<nums.length; i++){
            int size= res.size();
            for(int j=0; j<size; j++){
                List<Integer> list= new ArrayList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;        
    }
	
	/**Approach 2: RECURSIVE**/
	/*List<List<Integer>> res;
	public List<List<Integer>> subsets(int[] nums) {
        res= new ArrayList<>();        
        if(nums==null || nums.length==0) return res; 
        helper(nums,0,new ArrayList<>());
        return res;        
    }*/	
	/**0/1 Recursion + backtracking**/
	/*private void helper(int[] nums, int pivot, List<Integer>path) {
		//base
        if(pivot == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        //no choose
        helper(nums, pivot+1, path);
            
        //choose        
        path.add(nums[pivot]);//action
        helper(nums, pivot+1, path); //recurse
        path.remove(path.size()-1); //backtrack
	}*/
	/**For Loop Recursion + backtracking**/
	/*private void helper(int[] nums, int pivot, List<Integer>path) {
		//base        
        res.add(new ArrayList<>(path));   
        
        //logic
        for(int i=pivot; i<nums.length; i++){                   
            path.add(nums[i]); //action            
            helper(nums, i+1, path); //recurse            
            path.remove(path.size()-1); //backtrack
        }       
	}*/
	
	
	// Driver code to test above 
	public static void main (String[] args) {
		Subsets ob = new Subsets();
    	int[] nums= {1,2,3};    
    	
		System.out.println("All unique subsets are: "+ob.subsets(nums));
	}
}
