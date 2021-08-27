/* Time Complexity :  O(n * 2^n)
   Space Complexity :   O(n)
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res= new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return res;
    }
    private void helper(int[] nums,int index,List<Integer> path){
        //base
        if(nums.length==index)
        {
            res.add(new ArrayList<>(path));
            return;
        }
        //logic
        helper(nums,index+1,path);
        path.add(nums[index]);
        helper(nums,index+1,path);
        path.remove(path.size()-1);
    }
}
