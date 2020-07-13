Executed in Leet Code-Yes
Time Complexity-2 pow n

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums , 0, new ArrayList<Integer>(),result);
        return result;
    }
    
    private void backtrack(int[] nums , int index, List<Integer> tmpResult,List<List<Integer>> result){
        
        result.add(new ArrayList<Integer>(tmpResult));
        for(int i=index;i<nums.length;i++){
            tmpResult.add(nums[i]);
            backtrack(nums,i+1,tmpResult,result);
            tmpResult.remove(tmpResult.size()-1);
        }
        
    }
}
