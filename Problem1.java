//TC - O(2^n) 
//SC - O(N)

/*
The subsets method initializes the result list and starts backtracking from index 0 with an empty subset.
The backtrack method adds the current subset to the result and recursively explores all choices by including each element from the current index onward.
After each recursive call, the last added element is removed to backtrack and generate the remaining subsets.
*/


import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> temp, int pivot) {
        res.add(new ArrayList<>(temp));

        //logic
        for(int i = pivot;i<nums.length;i++) {
            //action
            temp.add(nums[i]);
            //recurse
            backtrack(nums,res, temp, i+1);
            //backtrack
            temp.remove(temp.size()-1);
        }
    }
}
