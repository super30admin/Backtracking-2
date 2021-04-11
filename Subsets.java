import java.util.ArrayList;
import java.util.List;
//tc : O(n)
//sc : O(height of tree); recursion stack
public class Subsets {
    List<List<Integer>> result= new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return result;
        backtracking(nums, 0, new ArrayList<>());
        return result;
    }
    private void backtracking(int[] nums, int index, List<Integer> path) {

        result.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1, path) ;
            path.remove(path.size() - 1);
        }
    }
}
