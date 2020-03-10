//Problem1 
// Subsets (https://leetcode.com/problems/subsets/)
// Backtrack 
// Time - O(2^n) Space - O(n 2 ^ n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList();
        subsets(nums, 0, new ArrayList<Integer>(), powerSet);
        return powerSet;
    }
    
    public void subsets(int[] nums, int idx, List<Integer> selectedList,List<List<Integer>> powerSet) {
        
        powerSet.add(new ArrayList<>(selectedList));

        for(int i = idx; i < nums.length; i++){
            selectedList.add(nums[i]);
            subsets(nums, i + 1, selectedList, powerSet);
            selectedList.remove(selectedList.size() - 1);
        }
        
        
        
    
    
        
    }
}

// Recursion 
// Time - O(n2^n) Space - O(n2 ^ n)
class Solution {
    List<List<Integer>> powerSet;
    public List<List<Integer>> subsets(int[] nums) {
        powerSet = new ArrayList();
        recurse(nums, 0, new ArrayList<Integer>());
        return powerSet;
    }
    
    public void recurse(int[] nums, int idx, List<Integer> temp) {
        //base case
        if(idx == nums.length){
            powerSet.add(temp);
            return;
        }
        //don't choose
        recurse(nums, idx + 1, new ArrayList<>(temp));
        //choose
        temp.add(nums[idx]);
        recurse(nums, idx + 1, new ArrayList<>(temp));    
    }
}

