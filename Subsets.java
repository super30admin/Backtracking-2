//https://leetcode.com/problems/subsets/
/*
Time: O(N.2^N) where N is the length of nums
Space: O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                result.add(new ArrayList<>(result.get(j)));
                result.get(result.size() - 1).add(nums[i]);
            }
        }

        return result;
    }

}
