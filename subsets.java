// Time Complexity :O(n * 2^n) n-length of the array
// Space Complexity :O(n)  
// Did this code successfully run on Leetcode :yes
//Backtracking Solution
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        backtrack(nums,0,new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums,int start,List<Integer> list)
    {
    
        result.add(new ArrayList<>(list)); //n
        for(int i=start;i<nums.length;i++)
        {
            list.add(nums[i]);
            backtrack(nums,i+1,list); //2^n
            list.remove(list.size()-1);
        }
    }
}

// Recursive Solutions

// 1. dont choose first and then choose
/*
TC:2^n
SC:(2^n / 2) still 2^n
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        recursive(nums,0,new ArrayList<>());
        return result;
    }
    private void recursive(int[] nums,int start,List<Integer> list)
    {
        //base
        if(start==nums.length)
        {
            result.add(list);
            return;
        }
        
        //logic
        //dont choose
        recursive(nums,start+1,new ArrayList<>(list));
        
        
        //choose
        list.add(nums[start]);
        recursive(nums,start+1,list);
    }
}
*/

// 2. choose first and then dont choose
/*
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        recursive(nums,0,new ArrayList<>());
        return result;
    }
    private void recursive(int[] nums,int start,List<Integer> list)
    {
        //base
        if(start==nums.length)
        {
            result.add(list);
            return;
        }
        //logic
        
        //choose
        List<Integer> temp=new ArrayList<>(list);
        temp.add(nums[start]);
        recursive(nums,start+1,temp);
        
        //dont choose
        recursive(nums,start+1,list);
        
        

    }
}
*/