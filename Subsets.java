/*The time complexity of this implementation is O(2^n)*/
import java.util.ArrayList;
import java.util.List;

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), 0, subsets);
        return subsets;
    }

    private void backtrack(int[] nums, List<Integer> currentSubset, int start, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(currentSubset));
        for (int i = start; i < nums.length; i++) {
            currentSubset.add(nums[i]);
            backtrack(nums, currentSubset, i + 1, subsets);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets solution = new Subsets();
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println("All subsets of [1, 2, 3] are:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

}
