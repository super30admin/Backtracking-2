//Subset problem
//Time Complexity  : O(2^n)
import java.util.*;

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums.length == 0 || nums == null){
            return result;
        }
        backTracking(nums, new ArrayList<>() , 0);
        return result;
    }
    
    private void backTracking(int[] nums, List<Integer>temp, int index){
        result.add(temp);    
        for(int i = index; i < nums.length; i++){
            temp.add(nums[i]);
            backTracking(nums, new ArrayList<>(temp), i+1);
            temp.remove(temp.size() - 1);
            
        }
    }
}