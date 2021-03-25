// Time Complexity :O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//In this approach we are implementing backtracking.
    class Solution {
    public List<List<Integer>> result = new ArrayList<List<Integer>>();

		public List<List<Integer>> subsets(int[] nums) 
		{
		  if(nums.length==0 || nums==null)
			  return result;
		  
      backtrack(nums,0,new ArrayList<Integer>());
		  return result;
		}
		
	    //backtracking function in which we are passing the current data we are working on , the progression to drive the recursion and the path that we have taken at any point
	
    public void backtrack(int[] nums,int index,ArrayList<Integer> path)

		{
			//base case
      if(index>nums.length)
      {
        return;
      }
      		//adding each of the node to the output list
			  result.add(new ArrayList<Integer>(path));
			  for(int i=index;i<nums.length;i++)
			  {
				  	path.add(nums[i]);
				  	//pass the input data , increment the index as the current is already done and the path
          			backtrack(nums,i+1,path);
          			//undo the change
				  	path.remove(path.size()-1);
			  }
		}
        
    
}