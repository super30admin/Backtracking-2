// Backtrack 
// Time - O(exp)
// Space - O(N)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> sub) {
        
        result.add(new ArrayList(sub));
        
        for(int i=index;i<nums.length;i++) {
            sub.add(nums[i]);            
            helper(nums, i + 1, sub);   
            sub.remove(sub.size() - 1);
        }
    }
}

// Iterative 

// Time - O(exp)
// Space - O(exp)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> sub) {
        
        result.add(sub);
        
        for(int i=index;i<nums.length;i++) {
            List<Integer> temp2 = new ArrayList<>(sub);
            temp2.add(nums[i]);            
            helper(nums, i + 1, temp2);   
        }
    }
}

// Recursive

// Time - O(exp)
// Space - O(exp)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        helper(nums, 0, new ArrayList<>());
        
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> sub) {
        if(index == nums.length) {
            result.add(sub);
            return;
        }
        
        // not choosing
        helper(nums, index + 1, new ArrayList<Integer>(sub));
        
        //choosing
        sub.add(nums[index]);
        helper(nums, index + 1, new ArrayList<Integer>(sub));
    }
    
    
}
