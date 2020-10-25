class Solution {
    List<List<Integer>> output;
    public List<List<Integer>> subsets(int[] nums) {
        
        output = new ArrayList<>();
        if(nums==null || nums.length ==0)
            return output;
        
        helper(nums, 0, new ArrayList<>());
        return output;
        
    }
    private void helper(int[] nums, int index, ArrayList temp)
    {
        // Add every choice to output list
        output.add(new ArrayList<>(temp));
        
        for(int i=index; i<nums.length; i++)
        {
            // Make a choice- choose the element added
            temp.add(nums[i]);
            // Recurse through the list
            helper(nums, i+1, temp);
            // Remove and go to next element
            temp.remove(temp.size()-1);
        }
    }
}

//TC= O(N*2^N)
//SC= O(N*2^N) if output space is also considered in space complexity, otherwise O(N)

