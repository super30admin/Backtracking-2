# Backtracking-2

## Problem1 
Subsets (https://leetcode.com/problems/subsets/)

## Time Complexity:n2(^n) Space:O(n)
class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;  
    }

    public void helper(int[] nums, int i, List<Integer> path) {
      
        if (i == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[i]);
        helper(nums, i + 1, path);

       
        path.remove(path.size() - 1);
        helper(nums, i + 1, path);
    }
}

## Time:2^n  Space:o(1)
class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++)
        {   int size=result.size();
            for(int j=0;j<size;j++)
            {
              List<Integer> list=new ArrayList<>(result.get(j));
              list.add(nums[i]);
              result.add(list);
            
            }
        }
        return result;  
    }

    
}


## Problem2

Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)

## Solution 2
## Time Complexity:O(n*2^n) Space: O(n)
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result=new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return result;
    }

    private void helper(String s,int pivot,List<String> path)
    {
        //base condition
        if(pivot==s.length()){
        result.add(new ArrayList<>(path));
        return;}

        for(int i=pivot;i<s.length();i++)
        {
            String st=s.substring(pivot,i+1);
         
            if(pallin(st)){
            path.add(st);
            
            helper(s,i+1,path);
            path.remove(path.size()-1);}
            
        }
    }
    private boolean pallin(String s)
    {
        int low=0;
        int high=s.length()-1;

        while(low<high)
        {
            
            if(s.charAt(low)!=s.charAt(high))
            return false;
            low++;
            high--;

        }
        return true;
    }
}
