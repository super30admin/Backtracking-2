// There are two approaches
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

import java.util.ArrayList;
import java.util.List;

// Your code here along with comments explaining your approach
// Approach 1: Brute force (DFS)
// Time Complexity : O(n*(2^n))
//      n: number of elements
//   Requires n->copy of temp list
// Space Complexity : O(n^2)
//      n: number of elements
//     Creating n copies for n nodes
class Problem1S1 {

    // global 
    int[] nums;
    List<List<Integer>> result;

    /** find subsets */
    public List<List<Integer>> subsets(int[] nums) {
        // initialize
        result = new ArrayList<>();
        if(nums== null || nums.length == 0)
            return result;
        // global
        this.nums = nums;
        // start from 1st index
        dfsHelper(0, new ArrayList<Integer>());

        // return result
        return result;
    }
    
    /**  DFS Helper*/
    private void dfsHelper(int index, List<Integer> temp){

        // base case
        if(index == nums.length){
            result.add(temp);
            return;
        }
        // not chose
        dfsHelper(index+1, new ArrayList<Integer>(temp));
        
        // choose
        temp.add(nums[index]);
        dfsHelper(index+1, new ArrayList<Integer>(temp));
        
    }
}

// Your code here along with comments explaining your approach
// Approach 2: DFS with Back tracking
// Time Complexity : O(n*(2^n))
//      n: number of elements
//   Here n for copying n elemenst into resultant
// Space Complexity : O(n)
//      n: number of elements
//   As we reusing the same List
class Problem1S2 {

    // global
    int[] nums;
    List<List<Integer>> result;

    /** find subsets */
    public List<List<Integer>> subsets(int[] nums) {

        // initialize
        result = new ArrayList<>();
        if(nums== null || nums.length == 0)
            return result;
        // backtracking
        this.nums = nums;
        backTracking(0, new ArrayList<Integer>());

        // return result
        return result;
    }
    
    /** DFS with backtracking */
    private void backTracking(int index, List<Integer> temp){
        
        //no base case as i< nums.length handles base case

        // add temp to result
        result.add(new ArrayList<Integer>(temp));

        // iterate all the numbers
        for(int i= index; i<nums.length; i++){
       
            // ACTION: add to set
            temp.add(nums[i]);
            
            // RECURSE
            backTracking(i+1, temp);

            // BACKTRACK: remove from set
            temp.remove(temp.size()-1);
        }
        
        
    }
}