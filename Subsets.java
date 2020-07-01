//Here we are doing backtarcking, where initially we are creating a temp list and are storing the numbers as we pass through them, and are storing a copy of temporary list into our result set. Here we don't need a base case in recursive function as we are using for loop for that and while we are backtracking we are removing the last element from the temporary list.

//Time complexity=O(n*2^n)
//Space complexity=O(N)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        
        backtrack(nums, new ArrayList<>(),0);
        return result;
    }
    private void backtrack(int[] nums, List<Integer> temp, int start)
    {
        
        result.add(new ArrayList<>(temp));
        int size=nums.length;
        for(int i=start;i<size;i++)
        {
            temp.add(nums[i]);
            backtrack(nums,temp,i+1);
            temp.remove(temp.size()-1);
        }
        
            
    }
}