// Time complexity - O(2^n)
// Space complexity - O(n*2^n)

// backtracking

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        backtrack(nums,new ArrayList<>(), 0);
        return result;
    }
    private void backtrack(int[] nums, List<Integer> tmp, int index){
        // base
        
        result.add(new ArrayList<>(tmp));
        
        // logic
        for(int i = index; i< nums.length; i++){
            // action
            tmp.add(nums[i]);
            // recurse
            backtrack(nums,tmp,i+1);
            // backtrack
            tmp.remove(tmp.size()-1);
        }
        
    }
}
