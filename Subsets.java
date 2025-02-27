// Time Complexity: O(2^n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/* Approach:
 * Use backtracking to generate all possible combinations of elements from the input array.
 * For each element starting from the pivot index, we have two choices: either include it in the current subset or skip it.
 * After processing each element, we backtrack by removing it from the path to explore other combinations.
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        helper(nums,0,new ArrayList<>(),result);
        return result;    
    }
    private void helper(int[]nums,int pivot,List<Integer> path, List<List<Integer>> result){
        result.add(new ArrayList<>(path));
        for(int i = pivot;i<nums.length;i++){
            path.add(nums[i]);
            helper(nums,i+1,path,result);
            path.remove(path.size()-1);            
        }
    }
        
    }
