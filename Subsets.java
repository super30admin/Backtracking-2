import java.util.ArrayList;
import java.util.List;

// Time complexity:O(N*2^N) to generate all subsets and then copy them into output list.
// Space complexity:O(N)
public class Subsets {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        helper(nums, new ArrayList<Integer>(), 0);
        return res;
    }

    private void helper(int[] nums, ArrayList<Integer> path, int index) {
        // if(index == nums.length){
        // res.add(new ArrayList<>(path));
        // }
        res.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
