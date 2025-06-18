// Time Complexity - 2^n
// Space Complexity - O(1)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            int size = result.size();
            for(int j = 0; j < size; j++){
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
        }
        return result;
    }
}
