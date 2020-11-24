package S30.BackTracking_2;

import java.util.ArrayList;
import java.util.List;

/* Backtracking Solution
Time Complexity : O(2^N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> templist = new ArrayList<>();
        backtrack(result,templist,nums,0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> templist, int[] nums, int index){

        result.add(new ArrayList<>(templist)); // ---- N amount of work
        for(int i = index; i < nums.length; i++){
            templist.add(nums[i]);
            backtrack(result,templist,nums,i + 1);
            templist.remove(templist.size()-1);
        }
    }
}
