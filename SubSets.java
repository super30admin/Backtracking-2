class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        GenerateSubStrings(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    public void GenerateSubStrings(int nums[],int idx,List<Integer>currentSubset,   List<List<Integer>>result){
        if (idx == nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }
        //Choose 
        currentSubset.add(nums[idx]);
        GenerateSubStrings(nums, idx + 1, currentSubset, result);

        //Not choose(backtrack)
        currentSubset.remove(currentSubset.size() - 1);
        GenerateSubStrings(nums, idx + 1, currentSubset, result);
    }
}