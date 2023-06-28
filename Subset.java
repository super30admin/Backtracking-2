// Time complexity o(2^n) space complexity o(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;
    }
    public void helper(int[] nums,int idx,ArrayList<Integer> path){
       if(idx > nums.length){
           return;
       }

       result.add(new ArrayList<>(path));

       for(int i=idx;i<nums.length;i++){
           path.add(nums[i]);

           helper(nums,i+1,path);

           path.remove(path.size()-1);
       }
    }
}