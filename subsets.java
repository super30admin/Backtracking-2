// Time complexity - O(2^n)
// Space complexity - O(n)
// Works on leetcode

class Solution {
    private List<List<Integer>> output = new ArrayList();
    
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return output;
        }
        backtracking(nums, 0, new ArrayList<>());
        return output;
    }
    
    private void backtracking(int[] nums, int index, List<Integer> path){
        output.add(new ArrayList<>(path));
        
        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            backtracking(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}
