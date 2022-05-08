import java.util.ArrayList;
import java.util.List;

public class Subsets {

    // for loop with recursion + backtracking
    // TC: O(2 ^ n) - n - number of element. For n elements we have two choices. Either chose it or not
    // SC: O(n) n - number of elements (height of the tree because of the recursive stack)
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();

        if(nums == null || nums.length == 0) return result;

        helper(nums, 0, new ArrayList<Integer>());

        return result;
    }

    private void helper(int[] nums, int index, ArrayList<Integer> path) {
        //base
        // we don't need the base case here because for loop won't let us go beyond the higher bound of the array

        result.add(new ArrayList<>(path));

        //logic
        for(int i=index; i < nums.length; i++) {
            // action
            path.add(nums[i]);

            //recurse
            helper(nums, i + 1, path);

            //backtrack
            path.remove(path.size() - 1);
        }
    }


}
