//@Time Complexity - O(2^N) where N is the number of elements
/*Leetcode - 78 Given a set of distinct integers, nums, return all possible subsets (the power set).
 Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/

package LC_78_Subsets;

import java.util.ArrayList;
import java.util.List;

public class LC_78_Subsets {
	 List<List<Integer>> result = new ArrayList<>();
	
	  public List<List<Integer>> subsets(int[] nums) {
		backtrack(nums, new ArrayList<>(),0);
		  return result;
	  
	  
	  }
	  
	  private void backtrack(int[] nums, List<Integer> temp, int index)
	  {
		  //Base case
		  if(index>nums.length)
		  {
			  return;
		  }
		  
		  //Logic
		  result.add(new ArrayList<>(temp));
		  
		  for(int i = index; i<nums.length;i++)
		  {
			  temp.add(nums[i]);
			  backtrack(nums,temp,i+1);
			  temp.remove(temp.size()-1);
		  }
	  }
	  
	  
	public static void main(String[] args) {
		LC_78_Subsets obj = new LC_78_Subsets();
		int[] nums = {1,2,3};
		
		System.out.println("List are : " +obj.subsets(nums));
		// TODO Auto-generated method stub

	}

}
