//Time Complexity: O(2^N)
//Space Complexity: O(2^N)

//<-----Backtrack----->

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        backtrack(nums, new ArrayList<>(), 0);
        return result;
        
    }
    private void backtrack(int[] nums, List<Integer> temp, int start)
    {
            result.add(new ArrayList<>(temp));
        for(int i  = start; i< nums.length; i++)
        {
            temp.add(nums[i]); //action
            backtrack(nums,temp,i+1); //recurse
            temp.remove(temp.size() - 1); //backtrack
        }
    }
}

// <-----Recursive----->

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        helper(nums, new ArrayList<>(), 0);
        return result;
        
    }
    private void helper(int[] nums, List<Integer> temp, int i)
    {
        if(i == nums.length)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        //choose
        helper(nums, new ArrayList<>(temp), i+1);
        temp.add(nums[i]);
        //don't choose
        helper(nums, temp, i+1);
    }
    }
