//TC: O(2^n)
//SC: O(n)
public class Solution {
    List<IList<int>> result;
    List<int> path;
    public IList<IList<int>> Subsets(int[] nums) {
        this.result = new List<IList<int>>();
        this.path = new List<int>();
        helper(nums, 0);
        return result;
        
    }

    private void helper(int[] nums, int pivot){
        //base case
        result.Add(new List<int>(path));
        //logic
        for(int i = pivot; i< nums.Length; i++){
            //action
            path.Add(nums[i]);
            //recurse
            helper(nums, i+1);
            //backtrack
            path.RemoveAt(path.Count()-1);
        }
    }
}