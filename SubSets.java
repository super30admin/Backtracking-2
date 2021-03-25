//Time complexity: O(2^n)
//Space complexity: O(n) 
//Executed on leetcode.
class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0 ,new ArrayList<Integer>());
        
        return output;
    }
    
    private void backtracking(int[] nums, int index, List<Integer> list)
    {
        output.add(new ArrayList<>(list)); 
        for(int i=index;i<nums.length;i++)      //at every index, adding all the possible subsets to the list.
        {
            list.add(nums[i]);
            backtracking(nums, i+1, list);  //Up on completing that index, adding the list to output list.
            list.remove(list.size()-1);
        }
    }
}