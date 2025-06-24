/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time complexity - O(2^N)
Space Complexity - O(N)
 */

import java.util.ArrayList;
import java.util.List;

//for loop based recursion backtracking
public class Subsets_LC_79 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(nums,output,new ArrayList<>(), 0);
        return output;
    }

    public void backtrack(int[] nums, List<List<Integer>> output, List<Integer> temp, int index){
        output.add(new ArrayList<>(temp)); //if I dont do new ArrayList I get all empty outputs chech why

        for(int i = index; i<nums.length; i++){
            temp.add(nums[i]);
            backtrack(nums,output, temp, i+1);   //once we are thrown out of for loop control will come back to last recursion stack and it will process  nexe line
            temp.remove(temp.size() -1);
        }
    }
}

/*

Brute Force(for loop based) Recursion without Backtracking
//Time Complexity : O(2^N)
//Space complexity : O(N)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(nums,output,new ArrayList<>(), 0);
        return output;
    }

    public void backtrack(int[] nums, List<List<Integer>> output, List<Integer> temp, int index){
        output.add(temp);

        for(int i = index; i<nums.length; i++){
            //temp.add(nums[i]);
            ArrayList<Integer> li = new ArrayList<>(temp);
            li.add(nums[i]);
            backtrack(nums,output, li, i+1);   //once we are thrown out of for loop control will come back to last recursion stack and it will process  nexe line
            //temp.remove(temp.size() -1);
        }
    }
}
*/