/** Given an integer array nums, return all possible subsets (the power set).
* TC O(N× (2 pow N)) SC O(N *(2 pow N))
*/
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        helper(nums, 0, new ArrayList<>()); 
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> temp){
        result.add(new ArrayList<>(temp));
        for (int i = index; i< nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}
