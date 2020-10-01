package s30;

import java.util.ArrayList;
import java.util.List;

/* Time complexity - O(2^N)*N
 * Space Complexity - O(2^N)*N
 */
public class Subsets {
	
	public static void main(String[] args) {
		Subsets s = new Subsets();
		int[] nums = new int[] {1,2,3};
		List<List<Integer>> output = s.subsets(nums);
		System.out.println(output);
	}
	 //output list that stores list of valid combinations
    List<List<Integer>> output = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return output;
        }
        List<Integer> list = new ArrayList<Integer>();
        helper(nums, list, 0);
        return output;
    }
    
    public void helper(int[] nums, List<Integer> path, int index){
        
        //add the current path to the output list
        output.add(new ArrayList<>(path));
        
        //recursive call
        for(int i=index; i<nums.length; i++){
            //add current element to the path
            path.add(nums[i]);
            //recursively call the child element
            helper(nums, path, i+1);
            //remove current element from the path once all the combinations under it are done
            path.remove(path.size()-1);
        }
    }
}