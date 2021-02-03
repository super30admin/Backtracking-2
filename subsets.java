class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums.length==0 || nums==null) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums,int index,List<Integer> path){
        //base
        if(index==nums.length){
            result.add(new ArrayList(path));
            return;
        }
        
        //dont choose
        helper(nums,index+1,path);
        //choose
        path.add(nums[index]);
        helper(nums,index+1,path);
        path.remove(path.size()-1);
    }
}