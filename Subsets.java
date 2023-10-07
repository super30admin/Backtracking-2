// Time Complexity : O(2^n) -- exponential
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Exhaustive approach, for every element in the nums array we've 2 options, pick and no-pick
 * increment the index for both the cases, 
 * but incase of pick add the element to the result before the recursive call
 * 
 */
import java.util.*;
class Solution1 {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length ==0)
            return new ArrayList<>();
        result = new ArrayList<>();
        recurse(nums,0, new ArrayList<>());
        return result;
    }
    void recurse(int[] nums, int index, List<Integer> path){
        if(index == nums.length ){
            result.add(path);
            return;
        }
        //0 case
        recurse(nums, index+1, new ArrayList<>(path));
        //1 case
        path.add(nums[index]);
        recurse(nums, index+1, new ArrayList<>(path));
    }
}


class Solution2 {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length ==0)
            return new ArrayList<>();
        result = new ArrayList<>();
        backtrack(nums,0, new ArrayList<>());
        return result;
    }
    void backtrack(int[] nums, int index, List<Integer> path){
        if(index == nums.length ){
            result.add(new ArrayList<>(path));
            return;
        }
        //0 case
        backtrack(nums, index+1, path);
        //1 case
        path.add(nums[index]);  //action
        backtrack(nums, index+1, path);
        path.remove(path.size()-1); //backtrack
    }
}

class Solution3 {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length ==0)
            return new ArrayList<>();
        result = new ArrayList<>();
        recurse(nums,0, new ArrayList<>());
        return result;
    }
    void recurse(int[] nums, int index, List<Integer> path){
        //base
        result.add(path);
        for(int i= index; i<nums.length ; i++){
            List<Integer> newlist = new ArrayList<>(path);
            newlist.add(nums[i]); //action
            recurse(nums, i+1, newlist);
            
        }
    }
}

class Solution4 {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length ==0)
            return new ArrayList<>();
        result = new ArrayList<>();
        recurse(nums,0, new ArrayList<>());
        return result;
    }
    void recurse(int[] nums, int index, List<Integer> path){
        //base
        result.add(new ArrayList<>(path));
        for(int i= index; i<nums.length ; i++){
            //List<Integer> newlist = new ArrayList<>(path);
            path.add(nums[i]); //action
            recurse(nums, i+1, path); // recurse
            path.remove(path.size()-1); //backtrack
        }
    }
}