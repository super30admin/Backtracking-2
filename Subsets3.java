import java.util.ArrayList;
import java.util.List;

/**
 * Subsets (Iterative)
 * LeetCode: https://leetcode.com/problems/subsets/
 *
 * Approach:
 * - Uses an iterative approach to generate all possible subsets.
 * - Starts with an empty subset and iteratively adds each number to existing subsets to form new ones.
 * - Efficiently builds the power set without recursion or backtracking.
 *
 * Time Complexity: O(N * 2^N)
 *   - There are 2^N possible subsets for an array of length N.
 *   - Each subset can take up to O(N) time to copy.
 *
 * Space Complexity: O(N * 2^N)
 *   - The result list contains 2^N subsets, each with up to N elements.
 */
public class Subsets3 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i=0; i<nums.length ;i++){
            int size = result.size();
            for(int j=0; j<size ;j++){
                List<Integer> list  = new ArrayList<>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
        }
        return result;
    }
}
