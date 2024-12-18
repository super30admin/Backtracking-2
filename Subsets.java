// for loop based recursion
// time complexity = O(2^n)
// space complexity = O(2^n)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<Integer>());
        for(int i=0;i< nums.length;i++) { // for each number
            int length = res.size();
            for(int j=0;j< length;j++) {
                List<Integer> li = new ArrayList<>(res.get(j));
                li.add(nums[i]);
                res.add(li);
            }
        }
        return res;
    }
}

// iterative solution
// time complexity = O(2^n)
// space complexity = O(2^n)

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    
    private void helper(int[] nums, int pivot, List<Integer> path ) {

            res.add(new ArrayList<>(path));
        for(int i=pivot;i< nums.length;i++) {
            path.add(nums[i]);
            helper(nums, i+1, path);
            
            path.remove(path.size()-1);
            
            System.out.println("pivot is " + pivot);
            System.out.println("i is " + i);
        }
    }
}

// time complexity = O(n*2^n)
// space complexity = O(2^n)

// without backtracking

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums,0, new ArrayList<>());        
        return res;
    }
    
    private void helper(int[] nums, int index, List<Integer> path) {
        // base
        if(index== nums.length) {
            res.add(path);
            return;
        }
        // logic 
        // case 1
        // created a new list.
        List<Integer> li = new ArrayList<>(path);
        li.add(nums[index]);
        helper(nums, index+1,li);
        // case 2
        helper(nums, index+1, path);
        return;
    }
    
}


// time complexity = O(n*2^n)
// space complexity = O(2^n)
// with backtracking.
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums,0, new ArrayList<>());        
        return res;
    }
    
    private void helper(int[] nums, int index, List<Integer> path) {
        // base
        if(index== nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // logic 
        // case 1
        path.add(nums[index]);
        helper(nums, index+1,path );
        // case 2
        // backtrack.
        path.remove(path.size()-1);
        helper(nums, index+1, path);
        return;
    }
    
}