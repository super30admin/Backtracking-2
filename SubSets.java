// Time Complexity : n*  3^n (exponential) where n is the number of nodes
// Space Complexity :n*  3^n (exponential)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Method 5 - without recursion
//tc: 2^n (exponential)
class Solution{
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums){

        result = new ArrayList<>();

        //adding an empty ArrayList in the result
        result.add(new ArrayList<>());

        for(int i = 0 ; i < nums.length ; i++){
            int size = result.size();
            for(int j = 0 ; j < size ; j++){
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}

public class SubSets {
}
//Method 4 - For-loop based recursion using Backtracking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int pivot , List<Integer> path){


        //base

        //logic
        result.add(new ArrayList<>(path));

        for(int i = pivot ; i < nums.length ; i++){

            //action
            path.add(nums[i]);
            //recurse
            helper(nums,i+1,path);
            //backtracking
            path.remove(path.size()-1);
        }
    }
}

//Method 3 - For-loop based recursion using Brute force
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int pivot , List<Integer> path){


        //base

        //logic
        result.add(path);

        for(int i = pivot ; i < nums.length ; i++){

            List<Integer> temp = new ArrayList<>(path);
            temp.add(nums[i]);
            helper(nums,i+1,temp);
        }
    }
}


//MEthod 2 - Backtracking 0-1 recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int i , List<Integer> path){

        //base case
        if(i == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }


        //logic
        //dont choose
        helper(nums,i+1,path);

        //choose
        //action
        path.add(nums[i]);
        //recursion
        helper(nums,i+1,path);
        //backtracking
        path.remove(path.size()-1);

    }
}

//Method 1 -BruteForce 0-1 recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int i , List<Integer> path){

        //base case
        if(i == nums.length){
            result.add(path);
            return;
        }

        //logic
        //dont choose
        helper(nums,i+1,new ArrayList<>(path));

        //choose
        path.add(nums[i]);
        helper(nums,i+1,new ArrayList<>(path));
    }
}