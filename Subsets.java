/*

Thought Process: Had to see professor's video to remember the approach again. Need to solve it in 4 steps. Don't choose, Action, Choose and Bactracking along with Base Condition.

We don't allow duplicates, so in Don't Choose we go index+1

Time Complexity - O(2 * pow(N)) -> In normal recursion solution (we copy the arraylist always) it was O(N * 2 * pow(N))
Space Complexity - O(N) -> Recursive height + 1 arraylist 

*/

class Subsets {
    
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        
        if(nums == null || nums.length == 0) return result;
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void backtrack(int[] nums, int index, ArrayList<Integer> path){
        
        //Base
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        
        // Don't Choose
        backtrack(nums, index+1, path);
        
        //Action
        path.add(nums[index]);
        
        // Choose
        backtrack(nums, index+1, path);
        
        // Bactracking
        path.remove(path.size()-1);
    }
}