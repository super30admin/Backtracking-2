import java.util.ArrayList;
import java.util.List;

// Time Complexity :O(2^n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach

public class Subsets {

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> subsets = new ArrayList<>();
            if(nums.length == 0) return subsets;

            generateSubSets(0, nums, new ArrayList<Integer>(), subsets);

            return subsets;
        }

        //helper method to generate subsets
        public void generateSubSets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets ){

            //add copy of current to subsets
            subsets.add(new ArrayList<>(current));

            //taking or not taking
            for (int i = index; i < nums.length; i++) {
                current.add(nums[i]);//taking value @ i
                generateSubSets(i+1, nums, current, subsets);//make next call
                current.remove(current.size()-1);//remove last value added
            }
        }
    }


}
