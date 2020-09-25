//Palindrome partitioning
// Time Complexity :0(n^n *n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> output= new ArrayList<>();
        List<String> path= new ArrayList<>();
        backtracking(output,s,0,path);
        return output;
    }
     
    
    private void backtracking(List<List<String>> output, String s, int index, List<String> path )
    {
        //base case
        
            if(index>=s.length())
                output.add(new ArrayList<>(path));
        
    //recursive case
    for(int i=index;i<s.length();i++)
    {
        String temp= s.substring(index,i+1);
        if(isPalindrome(temp))
        {
            path.add(temp);
            backtracking(output,s,i+1,path);
            path.remove(path.size()-1);
        }
    }
    }
    private boolean isPalindrome(String curr)
    {
        int left=0;
        int right=curr.length()-1;
        while(left<right)
        {
            if(curr.charAt(left)!=curr.charAt(right))
            {
                return false;
            }
            left+=1;       
            right-=1;
        }
        return true;
    }
    
}
//subset
// Time Complexity :0(2^n)
// Space Complexity :O(2^n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0)
      {
          return new ArrayList<>();
          
      }
        List<List<Integer>> output= new ArrayList<>();
        List<Integer> path= new ArrayList<>();
        backtracking(nums,0,path,output);
        return output;
    }
    private void backtracking(int[] nums, int index, List<Integer> path,List<List<Integer>> output)
    {
        if(index>=nums.length){
            output.add(new ArrayList<>(path));
            return;
        }
        
        // recusive case
        output.add(new ArrayList<>(path));
        for(int i=index;i<nums.length;i++)
        {
            path.add(nums[i]);
            backtracking(nums,i+1,path,output);
            path.remove(path.size()-1);
        }
    }
    }



