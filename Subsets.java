// Time Complexity : O(2^n), n = no if elements in i/p array, each has 2 choices
// Space Complexity : O(1), as result list of size (2^n) not counted in space complexity
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use an iterative approach to build the power set.
//   - Start with an empty subset in the result.
//   - For each number, duplicate all existing subsets and add the number to each duplicated subset.
//   - This way, we form new subsets including the current number at every step.

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        //for python we dont need to get snapshot of size explicitly because it handles internally but java will give Memory limit exceeded
        for(int i=0; i<nums.length; i++) {
            //size of result keeps changing so we need take snapshot of size
            int size = result.size();
            for(int j =0; j < size; j++) {

                //create deep copy of temp since it has same referecnce from result and it will override same list if deep copy not taken
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Subsets solver = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> allSubsets = solver.subsets(nums);

        System.out.println("All subsets:");
        for (List<Integer> subset : allSubsets) {
            System.out.println(subset);
        }
    }
}
