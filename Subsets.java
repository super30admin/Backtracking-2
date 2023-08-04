// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// Without recursion : We will first start by keeping the result List empty, which is like this [[]].  Then we will iterate through the elements in the nums array. 
//Then add the current element to each of the lists in the result array and then finally add it to the result array

class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {  
        List<List<Integer>> result=new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        result.add(new ArrayList<>()); //The result array will start from [[]]
        
        for(int i=0;i<nums.length;i++)
        {
            int size=result.size(); // We will iterate through all the numbers in the nums array. 
            for(int j=0;j<size;j++) // We will have to iterate though all the lists in the result list.
            {
                List<Integer>li=new ArrayList<>(result.get(j)); // We will create a deep copy of every list in result and store it in another list
                li.add(nums[i]); // Add the current number from the nums array to the new list
                result.add(li); //Add the updated new list to the result list
            }
        }
    return result;
        
    }
}

// For loop based recursion : We will keep the pivot and i both at index 0 in the beginning. Then we would keep moving the pointers until we reach the end of the array. We first move the pivot and take the remaining elements from the pivot onwards.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {  
        this.result=new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
        
    }
    private void helper(int[] nums, int pivot, List<Integer> path)
    {
        //base
        if(pivot>nums.length) return;

        result.add(new ArrayList<>(path));

        //logic
        for(int i=pivot;i<nums.length;i++)
        {
            //action
            path.add(nums[i]);
            //recurse
            helper(nums,i+1,path);
            //backtrack
            path.remove(path.size()-1);
        }

        
    }
}

// We have found all the combinations for the given element in the array by choosing them and not choosing them. When we choose we add it to a list and when we reach the end of the array, we backtrack and remove the last element

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {  
        this.result=new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
        
    }
    private void helper(int[] nums, int i, List<Integer> path)
    {
        //base
        if(i==nums.length)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //choose
        path.add(nums[i]);
        helper(nums,i+1,path);
        //remove
        path.remove(path.size()-1);

        //not choose
        helper(nums,i+1,path);

        
    }
}