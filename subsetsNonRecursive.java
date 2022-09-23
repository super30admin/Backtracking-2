import java.util.ArrayList;
import java.util.List;

/*
## Problem1:    Subsets (https://leetcode.com/problems/subsets/)

Time Complexity :   O (2 ^ N) 
Space Complexity :  O (N) 
Did this code successfully run on Leetcode :    Yes (78. Subsets)
Any problem you faced while coding this :       No

 */
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

class subsetsNonRecursive {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        result.add(new ArrayList<>());
     
        for(int i= 0; i< nums.length; i++){
            int size = result.size();
            for(int j= 0; j< size; j++){
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}