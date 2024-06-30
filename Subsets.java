
// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  Yes, had to learn

/*
 * 78. Subsets:
 * return all possible subsets
 * 
 * things to note: 
 * can be done using choose/dont choose or for loop based recurssion. 
 * 
 * In for loop based recurrsion:
 * for loop will take care of choosing the i and as i move we get to all dont choose scenario
 * i will start from pivot and next recursion will start from i+1 (in this case)
 * 
 * keep in mind the reference we pass and reference we add to result.
 * 
 * for a non-recursive approach -
 * cocurrent exception- if we modify the list while we loop over it. get snapshot of size and then loop over the size 
 * when we get a existing item, make a deep copy so we have a new reference .
 * time complexity is O(N* (2^n))
 * 
 * 
 */

import java.util.*;

public class Subsets {

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {

        this.result = new ArrayList<>();
        helper_0_1(nums, 0, new ArrayList<>());
        return result;
    }

    // Approach - choose / don't choose
    public void helper_0_1(int[] nums, int i, List<Integer> path) {
        // base case

        if (i == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        // don't choose
        helper_0_1(nums, i + 1, path);

        // choose
        // add
        path.add(nums[i]);
        // recurse
        helper_0_1(nums, i, path);
        // backtrack
        path.remove(path.size() - 1);

    }

    // for loop based
    private void helper_for_loop_based(int[] nums, int pivot, List<Integer> path) {
        // base case
        // have to add add everytime i come here.. recurssion wont be called if not
        // needed.
        // if (pivot == nums.length)
        // return;

        // we add result everytime we recurse
        result.add(new ArrayList<>(path));

        // for loop based recurrsion; each time i moves we choose, and dont choose
        // others
        for (int i = pivot; i < nums.length; i++) {
            // List<Integer> li = new ArrayList<>(path);
            // li.add(nums[i]);
            path.add(nums[i]);
            helper_for_loop_based(nums, i + 1, path);
            path.remove(path.size() - 1);// backtrack
        }

    }

    // without recurssion
    private List<List<Integer>> helper_without_Recurrsion(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // seed value
        for (int i = 0; i < nums.length; i++) {
            int currentSize = result.size(); // helps avoid cocurrent exception
            for (int j = 0; j < currentSize; j++) {
                List<Integer> temp = new ArrayList<>(result.get(i)); // deep copy each element to copy it to a new
                                                                     // memory address
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }

}
