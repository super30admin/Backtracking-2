class Solution {// time and space of 2^N * N
    List<List<Integer>> output;
    public List<List<Integer>> subsets(int[] nums) {
        output = new ArrayList<>();
        //Base case 
        if(nums == null || nums.length == 0)
            return output;
        helper(nums,0 , new ArrayList<>());
        return output;
    }
    private void helper(int[] nums, int index , ArrayList temp){
        output.add(new ArrayList<>(temp));
        // Make a choice 
        for(int i= index ; i< nums.length ; i++){
            temp.add(nums[i]);
            helper(nums , i+1 , temp);
            temp.remove(temp.size()-1);
        }
    }
}