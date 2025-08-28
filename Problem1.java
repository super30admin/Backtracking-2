//Time Complexity: O(2^n) where n is the length of the input array
//Space Complexity: O(n) for the recursion stack

//We use recursion with backtracking to find all subsets
//We explore two possibilities for each element: include it in the current subset or exclude it.
//we add the current element to the path and explore further in include and just move further in case of exclude
//we recursion goes back we remove the current element from the path to restore the previous state

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        helper(nums,0,path);
        return result;
    }
    private void helper(int nums[],int i,List<Integer> path){
        if(i==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //no choose
        helper(nums,i+1,path);

        //choose
        path.add(nums[i]);
        helper(nums,i+1,path);
        path.remove(path.size()-1);  //backtrack

    }
}