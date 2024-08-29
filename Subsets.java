//Time Complexity: 2 raise to the power n
//Space Complexity: O(h)
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    public void helper(int[] nums, int idx, List<Integer> path){
        //base case
        if(idx == nums.length){
            result.add(path);
            return;
        }

        //dont choose
        helper(nums,idx+1,new ArrayList<>(path));
        path.add(nums[idx]);

        //choose
        helper(nums, idx+1, new ArrayList<>(path));
    }
}
