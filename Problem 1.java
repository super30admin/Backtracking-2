// Time Complexity :O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
/*
We will use recursion to solve this problem, at each index, we will either choose or not choose 
*/

class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {

         result= new ArrayList<List<Integer>>();
         helperRecurse(nums,new LinkedList<Integer>(),0);
         //helperForLoopRecurse(nums,new ArrayList<Integer>(),0);
        //iterative(nums);
        return result;
    }

    private void helperRecurse(int[] nums, LinkedList<Integer> path, int idx){
        //base case
        if(idx>=nums.length){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        //logic
        // not choose 
        helperRecurse(nums,path,idx+1);
        //choose
        path.add(nums[idx]);
        //recurse
        helperRecurse(nums,path,idx+1);
        path.removeLast();        

    }

    private void helperForLoopRecurse(int[] nums, ArrayList<Integer> path, int pivot){
        // Each element in the path is a subsets
        // from empty elements to single elements, each of them is the subset
        result.add(new ArrayList<Integer>(path));
        //base case
        //logic
        for(int i=pivot;i<nums.length;i++){
            path.add(nums[i]);
            helperForLoopRecurse(nums,path,i+1); //recurse
            path.remove(path.size() -1);
        }
               

    }

    //Bottom Up DP - space optimized
    private void iterative(int[] nums){

        
        // Adding empty List
        result.add(new ArrayList<Integer>());
        for(int i=0;i<nums.length;i++){
            int size = result.size();
            for(int m=0;m<size;m++){
                List<Integer> list = new ArrayList<Integer>(result.get(m)); // getting the prev list 
                list.add(nums[i]); // adding the number to the prev  list
                result.add(list); //now adding the new list
            }
        }
    }
}