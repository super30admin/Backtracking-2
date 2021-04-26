//Time complexity: O(2^n)
//Space Complexity: O(n)
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0 ) return res;
        helper(nums,0, new ArrayList<>());
        return res;    
    }
    private void helper(int[] nums, int index,ArrayList<Integer> path){
        if(index==nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        helper(nums,index+1,path);
        path.add(nums[index]);
        helper(nums,index+1,path);
        path.remove(path.size()-1);
    }
}