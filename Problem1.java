import java.util.ArrayList;
import java.util.List;
/*
Subsets
approach: pivot onwards or (chose, not chose)
time: O(nx2^n)
space: backtracking: O(n) chose, not chose: 2^n
 */
public class Problem1 {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, int pivot) {
        res.add(new ArrayList<>(path));
        //logic
        for(int i=pivot;i<nums.length;i++) {

            path.add(nums[i]);
            dfs(nums, path, i+1);
            path.remove(path.size()-1);
        }
    }
}
