/**
 * Time Complexity : O(2^n)
 * Space Complexity: O(1) - stack space 
 * Leetcode - Yes
 */
import java.util.*;

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int position = 0;
        helper(result, nums, new ArrayList<>(), position);
        return result;
    }

    public void helper(List<List<Integer>> result, int[] nums, List<Integer> tempList, int position){
        result.add(new ArrayList<>(tempList));
        for(int i=position; i<nums.length;i++){
            tempList.add(nums[i]);
            helper(result, nums, tempList, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }


    public List<List<Integer>> subsetsIter(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            List<List<Integer>> currResult = new ArrayList<>(result);
            for(List<Integer> list : currResult){
                List<Integer> tempList = new ArrayList<>(list);
                tempList.add(nums[i]);
                result.add(tempList);
            }
        }

        return result;
    
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("Subsets");
        Subsets obj = new Subsets();
        int[] nums = {1,2,3};
        System.out.println(obj.subsetsIter(nums));
    }
}