// 78.

//time - O(2^n)
//space - O(n) for the call stack

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        //edge
        if(nums == null || nums.length == 0)
        {
            return result;
        }
        
        List<Integer> path = new ArrayList<>();
        helper(nums, 0, path, result);
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        
        //path is [] when helper if first called, [] is part of output, so add to result
        //every [] at the root of a subtree is part of result
        result.add(new ArrayList<>(path));
        
        //base
        if(index == nums.length)
        {
            return;
        }
        
        for(int i = index; i < nums.length; i++)
        {
            //add current to path
            path.add(nums[i]);
            //recurse
            helper(nums, i + 1, path, result);
            //bactrack
            path.remove(path.size() - 1);
        }
    }
}
