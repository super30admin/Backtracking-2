/* Time complexity: O(2^n)
space complexity: O(n)
*/

class Solution{
    List<List<Integer>> result;
    public List<List<Integer>> subSets(int[] nums){
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        backtrack(nums, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> temp, int start){
        result.add(new ArrayList<>(temp));
        for(int i=start; i<nums.length; i++){
            temp.add(nums[i]);
            backtrack(nums, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
}