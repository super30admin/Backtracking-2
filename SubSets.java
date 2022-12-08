//Time complexity is O(n*2^N)
//Space complexity is O(N)
class Solution {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new LinkedList<Integer>());
        return result;
    }
    public void helper(int[] nums, int curr, LinkedList<Integer> li){
        result.add(new ArrayList<Integer>(li));
        for(int i=curr;i<nums.length;i++){
            li.add(nums[i]);
            helper(nums, i+1, li);
            li.removeLast();
        }
    }
}