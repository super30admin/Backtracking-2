/*
Time Complexity : O(2^N), nums array size
Space Complexity : O(N), in the recursion stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Approach :
We need to find all combinations of the numbers in the input array. To find combination, we can either do choose and not choose
recursion, 0/1 recursion or for loop based recursion. In either of the recursion, we need to maintain a path, that would store the current
combination, once we are done visiting a number we can remove it. As in, we need to back track the last value added to the path.
This is because we are using same path object to create all paths, if we want to avoid backtracking, we need to create a new array
for each path. As this is not space efficient, we rather choose to back track.
*/
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getSubsets(nums, 0,new ArrayList<>(), result);
       // getSubsets01Recursion(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void getSubsets01Recursion(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[index]);
        getSubsets01Recursion(nums, index+1, path, result);
        path.remove(path.size()-1);

        getSubsets01Recursion(nums, index+1, path, result);
    }

    // Time Complexity : O(N * 2^N),  Extra O(N) as we are creating deep copy of path and in worst case, path can have N values
    // Space Complexity : O(N)
    private void getSubsets(int[] nums, int pivot, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for (int i = pivot; i < nums.length; i++){
            path.add(nums[i]);
            getSubsets(nums, i+1, path, result);
            path.remove(path.size()-1);
        }
    }
}
