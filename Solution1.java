//Time Complexity: O(2^n)
//Space Complexity: O(n)

class Solution1 {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> list) {
        //base case
        result.add(new ArrayList<>(list));

        //logic
        for(int i = pivot; i < nums.length; i++) {
            //action
            list.add(nums[i]);
            helper(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }
}