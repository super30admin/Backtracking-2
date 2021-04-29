// Time Complexity : O(n*2^n) the 'backtracking tree' would be 2^n and copying them into output
// Space Complexity : O(n) depth of the recursion/bracktracking tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class Subsets {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        result.add(new ArrayList<>());
        helper(result, nums, 0, new ArrayList());
        return  result;
        
    }
    
    public void helper(List<List<Integer>> result,int[] nums, int start, List<Integer> tempList){
        
        if(start == nums.length) return;
        //System.out.println(tempList);
        tempList.add(nums[start]);
        result.add(new ArrayList<>(tempList));
        helper(result, nums, start+1, tempList);
        tempList.remove(tempList.size() -1);
        helper(result, nums, start+1, tempList);
        
    }
    
}