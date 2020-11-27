// Time complexity: 2^n
// space complexity: 2^n
// Idea: 
// As we know, backtracking is a dumb approach that reaches out for all possible combinations, which we are going to take leaverage of.

//     a) have a backtracking function.
//     b) while iterating through the elements in the array, backtrack it for every i recursively, such that all posible combinations are reached.

// did it run on leetcode: yes

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> mainList = new ArrayList();
        backtracking(mainList, new ArrayList<Integer>(), nums, 0);
        return mainList;
    }
        
    public void backtracking(List<List<Integer>> mainList, ArrayList<Integer> tempList, int[] nums, int start) {
        mainList.add(new ArrayList<>(tempList));
        for(int i=start;i<nums.length;i++) {
            tempList.add(nums[i]);
            backtracking(mainList, tempList, nums, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
        
}
