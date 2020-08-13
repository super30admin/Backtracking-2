/**
Problem : Subsets
Did it run on LeetCode: Yes

Time Complexity: O(2 ^ n), where n  is the length of the nums array
Space Complexity: O(n * (2^n)), for recursion. 

Approach 1 : Recursion
1. At every point, we have only 2 choices. Either choose the element, or don't choose.
2. If the element is chosen, and add it to the temp list.
3. If the element is not chosen, we proceed with other elements
4. Whene we reach the end of nums array, we append that list to the result list.

Approach 2: Backtracking
1. In backtracking, we follow the same methodology like recursion, but the appoach is slightly different.
2. We use  a 3-pronged approach. First, we perform an action, then we recurse, and if the condition is not met, we then backtrack(i.e, removing the previously performed action)
3. Backtracking is basically optimizing the space.
*/

*/
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        traverse(nums, new ArrayList<>(), 0);
        return result;
    }
    public void traverse(int[] nums, List<Integer> temp,  int i) {
        if(i == nums.length) {
            result.add(temp);
            return;
        }
        //don't choose
        traverse(nums, new ArrayList<>(temp), i+1);
        //choose
        temp.add(nums[i]);
        traverse(nums, new ArrayList<>(temp), i+1);
    }
}

//Backtracking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        backTrackTraverse(nums, new ArrayList<>(), 0);
        return result;
    }
    public void backTrackTraverse(int[] nums, List<Integer> temp,  int start) {
        if(start > nums.length) {
            return;
        }
        result.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i++) {
            //action
            temp.add(nums[i]);
            //recurse
            backTrackTraverse(nums, temp, i + 1); //no duplicates
            //backTrack
            temp.remove(temp.size() -1 );
        }
    }
}