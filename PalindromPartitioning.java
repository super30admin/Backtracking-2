// Time Complexity : O(n * 2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Solution {

    //code 1 : for loop with backtracking

    List<List<String>> result;

    public List<List<String>> partition(String s) {

        result = new ArrayList();
        helper(s, 0, new ArrayList());
        return result;
    }

    private void helper(String s, int index, List<String> path)
    {
        //base
        if(index == s.length())
        {
            result.add(new ArrayList(path));
            return;
        }

        //logic
        for(int i=index; i<s.length(); i++)
        {
            String current = s.substring(index, i+1);

            if(isPalindrome(current))
            {
                path.add(current);
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s)
    {
        int l = 0;
        int h = s.length()-1;

        while(l<h)
        {
            if(s.charAt(l) != s.charAt(h))
                return false;
            l++;
            h--;
        }

        return true;
    }
}
