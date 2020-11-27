//Time complexity: O(n*2^n)
//Space complexity: O(N)
//Attempted on leetcode and accepted
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //resultant list
        List<List<Integer>> list = new ArrayList<>();
        //sort the nums array
        Arrays.sort(nums);
        //Backtrack function with inputs res list, new temp array list, the nums array and start index which is initially 0
        backtrack(list, new ArrayList<>(), nums,0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int startIndex)
    {
        //A temp list to store the temp values
        list.add(new ArrayList<>(tempList));
        //Iterate over nums from the start index 
        for(int i= startIndex; i< nums.length; i++)
        {
            //add the values to the temp list
            tempList.add(nums[i]);
            //backtracking for for next i
            backtrack(list, tempList, nums,i+1);
            //remove the last value from list
            tempList.remove(tempList.size()-1);
        }
    }
}