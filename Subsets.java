/*
algotirthm: 
to recurse and search for each possible combination of numbers.
but, after every recursion, undo the previously done action. That is nothing but backtrack.

Start the recursion from index 0 for nums array.
At every step we add the current element to path and the recurse for next elements by going to index+1 postion.
continue this until we reach end of nums array. Once reached, add the current path to result list by creating new copy. Then return to the recusion. 
Here remove the previously added element, and go to next

Time complexit: exponential, as we check every possible combiantion
space:  O(n)

*/
class Subsets {
    
     List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        this.result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        
        helper(nums, 0 , new ArrayList<>());
        
        return result;
        
    }
    
    private void helper(int[]nums, int index, List<Integer> path){
        
        //base case
        if(index > nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        
        
        if(index <= nums.length){
            result.add(new ArrayList<>(path));
        }
       
        
        //logic
        for(int i = index; i < nums.length;i++){
            //action
            path.add(nums[i]);
            //recurse
            helper(nums,i+1,path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}