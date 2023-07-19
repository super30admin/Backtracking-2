// Time Complexity :  O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// We use a for loop based recursion to iterate throught the String and split the string into different combinations
// if the substring is a palindrome we continue otherwise we move on to the next combination. 
// if the substring is a palindorme we add it the path are recuse with pivot as i+1 and back track the action of adding it to the path.
// when pivot is equal to the size of the string then we can add a new instance of the path to result.

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return result;
    }
    private void helper(String s, int pivot, List<String> path)
    {
        //base
        if(pivot==s.length())
        {
            result.add(new ArrayList<>(path));
        }
        //logic
        for(int i=pivot;i<s.length();i++)
        {
            String sub = s.substring(pivot,i+1);
            if(isPalindrome(sub))
            {
                //action
                path.add(sub);
                
                //recurse
                helper(s,i+1,path);

                //backtrack
                path.remove(path.size()-1);
            }
        }

    }

    private boolean isPalindrome(String s)
    {
        int start=0;
        int end = s.length()-1;
        while(start<end)
        {
            if(s.charAt(start) != s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}