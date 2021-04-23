/**Leetcode Question 78 - Subsets */
/**Algorithm - Backtracking
 * Two cases: Choose and don't choose
 * In the don't choose case, increment the index and call the function again
 * In the choose case, add the element to the path, increment the index and call the function again
 * In the base case check if the index == length of the nums array andd append the path to the result list
 */
/**TC - 2^N
 * SC - 2^N
 */
public class Subsets {
    class Solution {
        List<List<Integer>> result;
        public List<List<Integer>> subsets(int[] nums) {
            result = new ArrayList<>();
            if(nums == null || nums.length == 0){
                return result;
            }
            List<Integer> path = new ArrayList<>();
            backtrack(nums,0, path);
            return result;
        }
        private void backtrack(int[] nums, int index, List<Integer> path){
            //base
            if(index == nums.length){
                result.add(new ArrayList(path));
                return;
            }
            
            //logic
            //don't choose
            backtrack(nums, index+1, path);
            
            //choose
            path.add(nums[index]);
            backtrack(nums, index+1, path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}
/**Iterative solution */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        List<Integer> path = new ArrayList<>();
        backtrack(nums,0, path);
        return result;
    }
    private void backtrack(int[] nums, int index, List<Integer> path){
        //base
        result.add(new ArrayList(path));
          
        for(int i =index; i<nums.length; i++){
            path.add(nums[i]);
            backtrack(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}
