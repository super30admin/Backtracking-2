//Time Complexity: O(N * 2 ^N)
//Space Complexity: O(N)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        backtrack(nums, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer>temp, int index){
        //base
        
        //logic
        result.add(new ArrayList<>(temp));
        for(int i = index; i<nums.length; i++){
            //action 
            temp.add(nums[i]);
            //recurse
            backtrack(nums, temp, i + 1);
            //backtrack
            temp.remove(temp.size() - 1);
        }
    }
}