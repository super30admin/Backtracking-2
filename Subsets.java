// Time Complexity :O(n* 2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
         List<Integer> path = new ArrayList<>();
        helper(nums,0,path,answer);
        return answer;
    }
    private void helper(int nums[],int index,List<Integer> path, List<List<Integer>> answer){
        //base
        if(index == nums.length){
            answer.add(new ArrayList<>(path));
            return;
        }
        //logic
        //no choose
        helper(nums,index+1,path,answer);
        //choose
        //action
        path.add(nums[index]);
        //recurse
        helper(nums,index+1,path,answer);
        //backtrack
        path.remove(path.size()-1);
    }
}


// Time Complexity :O(n* 2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
         List<Integer> path = new ArrayList<>();
        helper(nums,0,path,answer);
        return answer;
    }
    private void helper(int nums[],int pivot,List<Integer> path, List<List<Integer>> answer){
        answer.add(new ArrayList<>(path));
        for (int i = pivot; i < nums.length; i++) {
            // action
            path.add(nums[i]);
            // recurse
            helper(nums, i + 1, path,answer);
            // backtrack
            path.remove(path.size() - 1);
        }
    }
}
