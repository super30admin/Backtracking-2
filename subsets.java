class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        result= new ArrayList<>();
        
        result.add(new ArrayList<>());
        
        for(int i=0;i<nums.length;i++)
        {
            int size=result.size();
            for(int j=0;j<size;j++)
            {
                List<Integer> list=new ArrayList<>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
            System.out.println(result.size());
        }
        
        //helper(nums,0,new ArrayList<>());
        
        return result;
        
    }
    
    private void helper(int[] nums, int idx, List<Integer> path)
    {
        //base
        if(idx==nums.length)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        
        
        //logic
        helper(nums,idx+1,path);
        path.add(nums[idx]);
        helper(nums,idx+1,path);
        path.remove(path.size()-1);
    }
}

// Time Complexity : O(2^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no