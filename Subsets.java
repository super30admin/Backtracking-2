import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Puri
 * // Time Complexity : O(2^n)
 * // Space Complexity : O(2^n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class Subsets {
    List<List<Integer>> output = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0)
            return output;
        backtrack(0, new ArrayList<Integer>(), nums);
        return output;
    }
    public void backtrack(int first, ArrayList<Integer> curr, int[] nums){
        output.add(new ArrayList<Integer>(curr));
        for(int i=first; i<nums.length;i++){
            curr.add(nums[i]);
            backtrack(i+1, curr, nums);
            curr.remove(curr.size()-1);
        }
    }
}