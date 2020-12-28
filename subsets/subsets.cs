public class Solution {
    List<IList<int>> result;
    public IList<IList<int>> Subsets(int[] nums) {
        result = new List<IList<int>>();
        if(nums==null || nums.Length ==0)
        {
            return result;
        }
        
        backtrack(nums,new List<int>(),0);
        return result;
    }
    
    private void backtrack(int[] nums,List<int> temp, int index)
    {
        
    
            result.Add(temp);
           
        
        for(int i=index;i<nums.Length;i++)
        {
            temp.Add(nums[i]);
            backtrack(nums,new List<int>(temp),i+1);
            temp.RemoveAt(temp.Count-1);
        }
    }
}
