//****SUBSETS - 0 1 RECURSION TECHNIQUE****
//Time complexity: 2 res to n
//Space complexity:n;
//Leetcode runnable: Y;
//Any doubts:N;

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
        
    }
    private void helper(int[] nums, int i, List<Integer> path)
    {
        //Base case
        if(i==nums.length)
        {
            result.add(new ArrayList<>(path));
            retu
        }
        
        //Logic
        //No choose case
        helper(nums, i+1, path);
        //Choose case
            //Action
            path.add(nums[i]);
            //Recurse
            helper(nums,i+1, path);
            //Backtrack
            path.remove(path.size()-1);
        
    }
}

////****SUBSETS - FOR LOOP RECURSION TECHNIQUE****
//Time complexity:2 res to n
//space complexity:0(n)
//Leetcode runnable : Y;
//Any doubts:N;
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
        
    }
    private void helper(int[] nums, int index, List<Integer> path)
    {
        //Base case
        
        
        //Logic
        result.add(new ArrayList<>(path));
        for(int i=index;i<nums.length;i++)
        {
            //Action
            path.add(nums[i]);
            //Recurse;
            helper(nums, i+1, path);
            //BackTrack
            path.remove(path.size()-1);
        }
        
    }
}

//****SUBSETS - ITERATIVE TECHNIQUE****
//Time complexity: 2 res to n
//Space complexity:n;
//Leetcode runnable: Y;
//Any doubts:N;
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++)
        {
            int size=result.size();
            for(int j=0;j<size;j++)
            {
                List<Integer> temp=new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
        
    }
    
}
//****PALINDROME PARTITION-- FOR LOOP BASED RECURSION****
//Time complexity:n*2 res to n
//Space complexity: o(n);

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) 
    {
        result=new ArrayList<>();
        //Null case 
        if(s.length()==0 || s==null)
        {
            return result;
        }
        
        helper(s, 0, new ArrayList<>());
        return result;
        
    }
    
    private void helper(String s, int index, List<String> path)
    {
        //Base 
        if(index==s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }
        
        //Logic
        for(int i =index;i<s.length();i++)
        {
            String sub=s.substring(index,i+1);
            if(isPalindrome(sub))
            {
                //Action
                path.add(sub);
                //Recurse
                helper(s, i+1, path);
                //BackTrack
                path.remove(path.size()-1);
                
            }
        }
        
        
    }
    
    private boolean isPalindrome(String s)
    {
        int start =0;
        int end=s.length()-1;
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
