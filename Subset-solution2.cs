https://leetcode.com/submissions/detail/637971468/
Time: O(2^n) * n : At everynode, we are copying the n node to result list.
Space: n(recursive) + n(creating new temp list) 

public class Solution {
    
    List<IList<int>> result;
    
    public IList<IList<int>> Subsets(int[] nums) {
        result = new List<IList<int>>();
        Helper(new List<int>(), 0, nums);
        return result;
    }
    
    private void Helper(List<int> path, int index, int[] nums) {
        
        //This is added here 
        result.Add(new List<int>(path));
        if(index == nums.Length){
            return;
        }
        
        for(int i = index; i < nums.Length; i++) {
            
            path.Add(nums[i]);
            
            //result.Add(new List<int>(path));
            Helper(path, i + 1, nums);
            path.RemoveAt(path.Count - 1);
        }
        
    }
}