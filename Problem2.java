//Accepted on LT
// Just go over all paths and keep adding for each subset
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        helper(nums,l,0);
        return result;
    }
    public void helper(int[] nums,List<Integer> l,int idx){
        if(idx==nums.length){
            result.add(new ArrayList<>(l));
            return;

        }
        
        if(idx>nums.length) return;

        //not choose
        helper(nums,l,idx+1);

        //choose
        l.add(nums[idx]);
        helper(nums,l,idx+1);
        l.remove(l.size()-1);


    }
}