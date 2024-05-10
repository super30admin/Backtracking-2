import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    // TC: O(2^n)
    // SC: O(n)
     List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] nums, int pivot, List<Integer> path){
        //base
        result.add(new ArrayList<>(path));

        //logic
        for(int i=pivot;i<nums.length;i++){
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}
