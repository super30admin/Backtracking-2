//Iterative approach
//Time Complexity : O(2^n).
//Space Complexity : O(n). This is because of recursive stack.


// In the iterative solution, used a helper function to perform backtracking.
// ACTION: the current element is added to the path list
// RECURSE : Each time the backtrack recurive function is called, the current element is added to the list and the index is increemented and passed in the subsequent 
// recurssive calls .
// BACKTRACK: the last element is removed and the same is continued with the next element

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null||nums.length==0){
            return result;
        }
        //use helper function for backtracking
        backtrack(nums,0,new ArrayList<>());
        return result;
    }
     private void backtrack(int nums[],int index,List<Integer> path){
         //add the intermediate lsit to result list at each step 
         result.add(new ArrayList<>(path));
         //iterate through the nums array
         for(int i=index;i<nums.length;i++){
             //ACTION : choose the element
             path.add(nums[i]);
             //RECURSE
             backtrack(nums,i+1,path);//go to next element to find the next sub array
             //BACKTRACK
             path.remove(path.size()-1);
         }
     }
}

//Choose abd notchoose method
//Time Complexity : o(2^n).
//Space Complexity : O(n). This is because of recursive stack.
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null||nums.length==0){
            return result;
        }
        //use helper function for backtracking
        backtrack(nums,0,new ArrayList<>());
        return result;
    }
    private void backtrack(int nums[],int index,List<Integer> path){
        //base case : when the end of the i/p array is reached, add the intermediate list to result list.
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //not choose case 
        backtrack(nums,index+1,path);
        //ACTION
        //choose case: add the current element to intermedaite list
        path.add(nums[index]);
        //RECURSE
        backtrack(nums,index+1,path);
        //BACKTRACK
        path.remove(path.size()-1);
    }
}