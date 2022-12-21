//TC: O(2^n)
//SC: O(n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> list = new ArrayList<>();
      backtrack(list, new ArrayList<Integer>(), nums, 0);
      return list;  
    }
    void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int start)  {
        if(nums.length == start) {
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[start]);
        backtrack(list, temp, nums, start + 1);
        temp.remove(temp.size() - 1);
        backtrack(list, temp, nums, start + 1);
    }
}