import java.util.ArrayList;
import java.util.List;
class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        subsetHelper(nums, new ArrayList<>(), 0);
        return result;
    }

    // private void subsetHelper(int[] nums, List<Integer> subset, int idx)
    private void subsetHelper(int[] nums, List<Integer> subset, int pivot)
    {
        // // a. using recursion + backtracking
        // // base
        // if(idx == nums.length)
        // {
        //     result.add(new ArrayList<>(subset));
        //     return;
        // }

        // // logic
        // // action - choose and not choose
        // // recurse
        // // not choose
        // subsetHelper(nums, subset, idx+1);
        // // choose
        // subset.add(nums[idx]);
        // subsetHelper(nums, subset, idx+1);
        // // backtrack
        // subset.remove(subset.size() - 1);

        // b. using recursion + for loop + backtracking
        // base
        result.add(new ArrayList<>(subset));

        // action
        for(int i = pivot; i < nums.length; i++)
        {
            subset.add(nums[i]);
            // recurse
            subsetHelper(nums, subset, i+1);
            // backtrack
            subset.remove(subset.size() - 1);
        }
    }
}