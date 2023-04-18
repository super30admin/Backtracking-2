import java.util.ArrayList;
import java.util.List;

//Leetcode -
//Time Complexity - O(2^n)
//Space Complexity - O(H) for recursion, O(1) using 2 for loops
public class Subsets {

    //0-1 Recursion
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int idx, List<Integer> path) {
        //base
        if(idx == nums.length) {
            result.add(path);
            return;
        }

        //logic
        //dont choose
        helper(nums, idx+1, new ArrayList<>(path));

        //choose
        path.add(nums[idx]);
        helper(nums, idx+1, new ArrayList<>(path));
    }
// Using 2 for loops
   /* public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0; i<nums.length; i++){
            int size = result.size();
            for(int j=0;j<size;j++){
                List<Integer> li = new ArrayList<>(result.get(j));
                li.add(nums[i]);
                result.add(li);
            }
        }
        return result;
    }*/

    //backtracking
    /*List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int idx, List<Integer> path) {
        //base
        if(idx == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        //dont choose
        helper(nums, idx+1, new ArrayList<>(path));
        //action
        path.add(nums[idx]);
        //recurse
        helper(nums, idx+1, new ArrayList<>(path));
        //backtrack
        path.remove(path.size()-1);
    }*/

    //For loop based recursion using backtracking
    /*List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int idx, List<Integer> path) {
        result.add(new ArrayList<>(path));
        for(int i = idx; i<nums.length;i++) {
            //action
            path.add(nums[i]);
            //recurse
            helper(nums, i+1, path);
            //backtrack
            path.remove(path.size()-1);
        }
    }*/

}
