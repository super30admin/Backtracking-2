//Time Complexity: O(2 ^ N)
//Space Complexity: O(N)
import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> output = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), output);

        return output;
    }

    private void backtrack(int[] nums, int pivot, List<Integer> combo, List<List<Integer>> output) {
        output.add(new ArrayList<>(combo));

        for (int i = pivot; i < nums.length; i++) {
            //action
            combo.add(nums[i]);
            //recurse
            backtrack(nums, i + 1, combo, output);
            //backtrack
            combo.removeLast();
        }
    }

    public static void main(String[] args) {
        final Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[] {1, 2, 3}));
    }
}
