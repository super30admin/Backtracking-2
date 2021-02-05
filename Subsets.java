/**

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Time Complexity : O(N)
Space Complexity : O(N) considering the recursion stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Collabedit: http://collabedit.com/f7fhp
**/
class Solution 
{
    private List<List<Integer>> output;
    
    
    public List<List<Integer>> subsets(int[] nums) 
    {
        this.output = new ArrayList<>();
        
        createSubsetsLoopPattern( nums, 0, new ArrayList<>());
        
        return this.output;
        
        
    }
    
    private void createSubsets( int nums[], int index, List<Integer> currentPath)
    {
        if( index == nums.length)
        {
            this.output.add( new ArrayList<>(currentPath));
            return;
        }
        
        // don't choose the current index
        createSubsets( nums, index + 1, currentPath);
        
        // add the element top the currentPath for choose scenario
        currentPath.add( nums[index]);
        
        createSubsets( nums, index + 1, currentPath);
        
        // remove the last element or backtrack scenario
        currentPath.remove( currentPath.size() -1);
    
    }
    
    private void createSubsetsLoopPattern( int nums[], int index, List<Integer> currentPath)
    {
        
        output.add( new ArrayList<>(currentPath) );
    
        for( int i= index; i < nums.length; i++)
        {
            currentPath.add( nums[i]);
            
            createSubsetsLoopPattern( nums, i + 1, /**

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Time Complexity : O(N)
Space Complexity : O(N) considering the recursion stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Collabedit: http://collabedit.com/f7fhp
**/
class Solution 
{
    private List<List<Integer>> output;
    
    
    public List<List<Integer>> subsets(int[] nums) 
    {
        this.output = new ArrayList<>();
        
        createSubsetsLoopPattern( nums, 0, new ArrayList<>());
        
        return this.output;
        
        
    }
    
    private void createSubsets( int nums[], int index, List<Integer> currentPath)
    {
        if( index == nums.length)
        {
            this.output.add( new ArrayList<>(currentPath));
            return;
        }
        
        // don't choose the current index
        createSubsets( nums, index + 1, currentPath);
        
        // add the element top the currentPath for choose scenario
        currentPath.add( nums[index]);
        
        createSubsets( nums, index + 1, currentPath);
        
        // remove the last element or backtrack scenario
        currentPath.remove( currentPath.size() -1);
    
    }
    
    private void createSubsetsLoopPattern( int nums[], int index, List<Integer> currentPath)
    {
        
        output.add( new ArrayList<>(currentPath) );
    
        for( int i= index; i < nums.length; i++)
        {
            currentPath.add( nums[i]);
            
            createSubsetsLoopPattern( nums, i + 1, currentPath);
            
            currentPath.remove( currentPath.size() -1);
        }
    
    }
}
