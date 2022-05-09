
//0, 1 based recursion

class Solution {

    //Time Complexity: 0(2^n)
    //Space complexity: 0(n) where n is the recursive stack
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while doint this problem: No

    //In short, explain your code

    List <List<Integer>> result;    //declared a list of list of integer to store the result.
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){   //checking if the nums has data or not
            return new ArrayList<>();
        }
        result = new ArrayList<>(); //declaring result
        helper(nums, 0, new ArrayList<>());     //passing the nums, index, and path to the recursive function
        return result;

    }
    public void helper(int [] nums, int index, List<Integer> path){
        //base
        if(index == nums.length){       //I need to capture the path when the index runs out of bounds
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //0 case or no choose case
        helper(nums, index + 1, path);
        //1 case or choose case
        //action
        path.add(nums[index]);
        //recurse
        helper(nums, index + 1, path);
        //backtrack
        path.remove(path.size()-1);

    }
}

//For Loop based recursion

class Solution {
    List <List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;

    }
    public void helper(int [] nums, int index, List<Integer> path){
        //base

        //logic
        result.add(path);
        for(int i = index; i < nums.length; i++){
            List <Integer> newList = new ArrayList<>(path);
            newList.add(nums[i]);
            helper(nums, i + 1, newList);
        }

    }
}

//For loop recursion with backtracking

class Solution {
    List <List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;

    }
    public void helper(int [] nums, int index, List<Integer> path){
        //base

        //logic
        result.add(new ArrayList<>(path));
        for(int i = index; i < nums.length; i++){
            //action
            path.add(nums[i]);
            //recurse
            helper(nums, i + 1, path);
            //backtrack
            path.remove(path.size()-1);
        }

    }
}