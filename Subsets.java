/*
Desc : We use recursively iterate through the array and backtrack and produce output.
Time Complexity : 
Space Complexity : 
*/

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length==0) return result;
        helper(nums,new ArrayList<>(),0);
        return result;
    }
    private void helper(int[] nums,List<Integer> path,int index){
      result.add(path);
        for(int i=index;i<nums.length;i++){
          path.add(nums[i]);//action
          helper(nums,temp,i+1);//recurse
          path.remove(path.size()-1);//backtrack
    }
}
