import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Subsets (Power set)
 *
 * TIME COMPLEXITY:
 * - There are 2^n subsets.
 * SPACE COMPLEXITY:
 * - Recursion depth: O(n)
 */
public class Subsets {

    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();

        // Pick ONE approach:
        //helperChooseSkip(nums, 0, new ArrayList<>());  // choose/skip
        forLoopHelper(nums, 0, new ArrayList<>());  // for-loop style

        return result;
    }
    // Choose / Skip recursion
    private void helperChooseSkip(int[] nums, int start, ArrayList<Integer> path) {
        if (start == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // no choose
        helperChooseSkip(nums, start + 1, path);

        // choose
        path.add(nums[start]);
        helperChooseSkip(nums, start + 1, path);

        // backtrack
        path.remove(path.size() - 1);
    }
    //  For-loop backtracking (standard)
    // Add path at EVERY call so all subset sizes are included
    private void forLoopHelper(int[] nums, int start, List<Integer> path) {
        // Add current subset (including empty subset when path is empty)
        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            List<Integer> newPath = new ArrayList<>(path); // copy (no backtracking needed)
            newPath.add(nums[i]);// choose
            forLoopHelper(nums, i + 1, newPath);  // move forward
        }
    }

    // Tests
    public static void main(String[] args) {
        Subsets sol = new Subsets();

        int[] nums1 = {1, 2, 3};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + sol.subsets(nums1));

        int[] nums2 = {};
        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Output: " + sol.subsets(nums2));

        int[] nums3 = {0};
        System.out.println("\nInput: " + Arrays.toString(nums3));
        System.out.println("Output: " + sol.subsets(nums3));
    }
}
