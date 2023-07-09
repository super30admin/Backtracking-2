// Time Complexity : O(2 ^ n) where n is the number of elements in the nums array
// Space Complexity :O(2 ^ n) where n is the number of nodes
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(nums, 0, path);
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path){

        result.add(new ArrayList<>(path));

        for(int i = pivot; i < nums.length; i++){

            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size() -1);
        }
    }

    private void iterative(int[] nums){
        result.add(new ArrayList<Integer>());

        for(int i =0; i< nums.length; i++){
            int l = result.size();

            for(int j=0; j<l; j++){
                List<Integer> current = new ArrayList<>(result.get(j));
                current.add(nums[i]);
                result.add(current);
            }
        }

    }
}
