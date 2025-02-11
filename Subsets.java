import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach 1:
 * 1. Add the current path to the result list.
 * 2. Iterate through the elements starting from the current index.
 * 3. Action: Add the current element to the path.
 * 4. Recurse: Explore the next index (i + 1) to avoid duplicate elements.
 * 5. Backtrack: Remove the last element from the path to explore other combinations.
 * 
 * Approach 2:
 * 1. Start with an empty subset result.
 * 2. Iterate Through Elements:
 * For each element n in nums, capture the current size of the result list.
 * For each existing subset in result, create a new subset by adding n and append it back to result.
 */

public class Subsets {

    // ---------------------------------------- Approach 1 -------------------------------------------
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums, int index, List<Integer> path) {
        //logic        
        result.add(new ArrayList<>(path));
        for(int i = index; i < nums.length; i++) {
            //action
            path.add(nums[i]);
            //recurse
            backtrack(nums, i + 1, path);
            //backtrack
            path.remove(path.size() - 1);            
        }        
    }

    // ---------------------------------------- Approach 2 -------------------------------------------
    public List<List<Integer>> subsets2(int[] nums) {        
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int n: nums) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newlist = new ArrayList<>(
                    result.get(j));
                    newlist.add(n);
                    result.add(newlist);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Your code here
        Subsets obj = new Subsets();
        List<List<Integer>> subsets = obj.subsets(new int[]{1,2,3});
        System.out.println(subsets);

        List<List<Integer>> subsets2 = obj.subsets2(new int[]{11,2,6});
        System.out.println(subsets2);
    }
}