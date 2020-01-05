// Time Complexity: Exponential (2^n) in this case
// Space complexity: O(n), to store the resultant arrayList
// Solved on leetcode susccessfully: Yes

class Subsets {
    
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        //Edge case
        if (nums.length ==0 || nums == null) return result;
        
        helper(nums,0,new ArrayList<Integer>());
        
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> temp) {
        //Base
        if (index > nums.length) return;
        
        //Logic
        result.add(new ArrayList<>(temp));
        for (int i=index; i<nums.length;i++) {
            temp.add(nums[i]);
            helper(nums,i+1,temp);
            temp.remove(temp.size()-1);
         }
    }
}