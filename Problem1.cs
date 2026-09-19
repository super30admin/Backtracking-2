// Time Complexity : O((2^n) * n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I pass index = 0 initially and call the recursive Helper function

Base Condition - If index = nums.Length, create deep copy of list and add it to result

Choose Condition - Add nums[index] to temp list. Call Helper method on next index

Not Choose Condition - Remove element added in choose condition from the temp list. Call Helper method on next index
*/

public class Solution {
    List<IList<int>> result;
    public IList<IList<int>> Subsets(int[] nums) {
        result = new();
        Helper(nums, 0, new List<int>());
        return result;
    }

    public void Helper(int[] nums, int index, List<int> tempList)
    {
        // Base Condition
        if(index == nums.Length)
        {
            result.Add(new List<int>(tempList)); // Create a deep copy of tempList and add it to result
            return;
        }

        // Core Logic

        // Choose
        tempList.Add(nums[index]);

        Helper(nums, index + 1, tempList);

        // Backtrack
        tempList.RemoveAt(tempList.Count - 1);

        // Not Choose
        Helper(nums, index + 1, tempList);

    }
}