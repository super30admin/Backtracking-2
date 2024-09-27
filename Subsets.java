//expontial time and space
//passed all leetcode cases
//used backtracking approach discussed in class

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length==0) return result;
        backtrack(nums,new ArrayList<>(),0);
        return result;
    }
    private void backtrack(int[] nums, List<Integer> temp, int index){
        if(index > nums.length) return;
        result.add(new ArrayList<>(temp));
        for(int i = index;i<nums.length;i++){
            //action
            temp.add(nums[i]);
            backtrack(nums,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}