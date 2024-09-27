//Time Complexity: O(n*2^n)
//Space Complexity: O(n*2^n)
//Leetcode: yes


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultSet = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();
        dfs(resultSet, stack, nums, 0);
        return resultSet;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> stack, int[] nums, int index){
        
        result.add(new ArrayList<>(stack));
        
        for(int i = index;i< nums.length;i++){
            stack.add(nums[i]);
            dfs(result, stack, nums, i+1);
            stack.remove(stack.size() - 1);
        }
    }
}
