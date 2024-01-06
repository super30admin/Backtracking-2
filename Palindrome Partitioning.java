// Time Complexity : O(n * 2^n)
// Space Complexity : O(n)
// Method used : Backtracking

class Solution {

    List<List<String>> result = new ArrayList();

    public List<List<String>> partition(String s) {
        
        helper(s, 0, s.length(), new ArrayList());
        return result;
    }

    private boolean isPallindrome(String s, int index, int i)
    {
        while(index < i)
        {
            if(s.charAt(index++) != s.charAt(i--)) return false;
        }

        return true;
    }

    private void helper(String s, int index, int length, List<String> temp)
    {

        if(index == length)
        {
            result.add(new ArrayList(temp));
            return;
        }

        for(int i = index; i < length; i++)
        {
            if(isPallindrome(s, index, i))
            {
                temp.add(s.substring(index, i + 1));
                helper(s, i + 1, length, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}