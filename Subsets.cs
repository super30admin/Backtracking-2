// Time Complexity : O(2^n), making two choices at every element
// Space Complexity : O(n), recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

List<IList<int>> result;
    
public IList<IList<int>> Subsets(int[] nums) {
    result = new List<IList<int>>();
    if(nums == null || nums.Count() == 0)
        return result;

    helperLoop(nums, 0, new List<int>());

    return result;
}

//for loop based recursion
private void helperLoop(int[] nums, int index, List<int> path)
{
    //base conditon
    //nobase case needed, as we already checking nums length in below for loop
    
    //logic
    result.Add(new List<int>(path));
    for(int i = index; i < nums.Count(); i++)
    {
        //action
        path.Add(nums[i]);
        //it should be i+1 in helper methid call, because we cannot use the same element again
        //we need to move forward to find unique combinations
        //recurse
        helperLoop(nums, i+1, path);
        //backtrack
        path.RemoveAt(path.Count() - 1);
    }
}