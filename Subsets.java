/* Approach: Using 0-1 recursion
Time: O(2^n)
Space: O(n), size of recursion stack
*/
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {

        this.result=new ArrayList<>();

        helper(nums,0,new ArrayList<>());

        return result;
    }

    private void helper(int nums[], int i, List<Integer> path){

        if(i==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //no choose
        helper(nums,i+1,path);

        //choose
        path.add(nums[i]);

        helper(nums,i+1,path);

        //backtrack
        path.remove(path.size()-1);
    }
}