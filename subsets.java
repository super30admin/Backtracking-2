class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        //edge case
        if(nums ==null) 
            return result;
        result.add(new ArrayList<>());
        subsetsUtil(nums, 0, new ArrayList<>());
        return result;
    }
    private void subsetsUtil(int []nums, int index, List<Integer> temp){
        //base case, when to stop recursion
        if(index > nums.length) return;
        //logic
        for(int i=index; i< nums.length; i++){
            //action
            temp.add(nums[i]);
            result.add(new ArrayList<>(temp));
            //recursion
            subsetsUtil(nums, i+1, temp);
            //backtrack
            temp.remove(temp.size()-1);
        }
    }
}
