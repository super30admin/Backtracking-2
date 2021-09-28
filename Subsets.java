// TIME: O(2^n)
// SPACE: O(N)
// SUCCESS on LeetCode

public class Subsets {
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return answer;
    }
    
    private void helper(int[] nums, int index, List<Integer> cur) {
        
        // base case
        if (index == nums.length) {
            answer.add(new ArrayList<>(cur));
            return;
        }
        
        // recursion logic and backtracking
        // choose cur index
        cur.add(nums[index]);
        helper(nums, index + 1, cur);
        cur.remove(cur.size() - 1);
        
        // not choose cur index
        helper(nums, index + 1, cur);
    }
}
