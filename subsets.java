import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> subsetsResult;

    public List<List<Integer>> subsets(int[] elements) {
        subsetsResult = new ArrayList<>();
        if (elements == null || elements.length == 0) return subsetsResult;
        generateSubsets(elements, 0, new ArrayList<>());
        return subsetsResult;
    }

    private void generateSubsets(int[] elements, int index, List<Integer> currentSubset) {
        if (index == elements.length) {
            subsetsResult.add(new ArrayList<>(currentSubset));
            return;
        }
        generateSubsets(elements, index + 1, currentSubset);
        currentSubset.add(elements[index]);
        generateSubsets(elements, index + 1, new ArrayList<>(currentSubset));
        currentSubset.remove(currentSubset.size() - 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> output = sol.subsets(nums);
        System.out.println(output);  // ans: [[],[3],[2],[2,3],[1],[1,3],[1,2],[1,2,3]]
    }
}
