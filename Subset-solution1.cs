//Leetcode: https://leetcode.com/submissions/detail/637527740/

public class Solution {
    List<IList<int>> result;
    public IList<IList<int>> Subsets(int[] nums) {
        result = new List<IList<int>>();
        Helper(nums, 0, new List<int>());
        return result;
    }
    
private void Helper(int[] nums, int index, List<int> list) {
        
        if(index == nums.Length) {
            result.Add(list);
            return;
        }
        
        Helper(nums, index + 1, list);
        List<int> right = new List<int>(list);
        right.Add(nums[index]);
        Helper(nums, index + 1, right);        
    }
}