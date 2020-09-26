// Time Complexity :O(2^N * N)
//O(2^N) for either choosing or not choosing the integer in the set
//O(N) for chechking whether the integer is present in the set
// Space Complexity :O(2^N * N) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//Traversing the given list and checking for the list of integers "path" whether they are present or not.
//Storing a set of integers in a result List.
import java.util.*;

class SubSets {
    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        backtracking(nums, 0, new ArrayList<>());

        return output;
    }

    public void backtracking(int nums[], int index, List<Integer> path) {

        output.add(new ArrayList<>(path));
        // System.out.println(output);

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);

            backtracking(nums, i + 1, path);

            path.remove(path.size() - 1);

        }
    }

    public static void main(String args[]) {
        SubSets obj = new SubSets();
        int[] nums = { 1, 2, 3 };
        System.out.println(obj.subsets(nums));
    }
}