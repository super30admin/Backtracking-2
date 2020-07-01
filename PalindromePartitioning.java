// 131.

//time - O(n * 2^n)
//space - O(n)

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        //edge
        if(s == null || s.length() == 0)
        {
            return result;
        }
        
        List<String> path = new ArrayList<>();
        helper(s, 0, result, path);
        return result;
    }
    
    private void helper(String s, int index, List<List<String>> result, List<String> path) {
        //base
        if(index == s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = index; i < s.length(); i++)
        {
            String current = s.substring(index, i + 1); // all possible snippets
            //i/p - abc
            //snippets - a, ab, abc, b, bc, c
            //if a snippet is valid (i.e is a palindrome) add it to current pah and recurse on remaining s
            //then bactrack to explore all possiblities
            if(isPalindrome(current))
            {
                path.add(current);
                helper(s, i + 1, result, path);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while(low < high)
        {
            if(s.charAt(low) != s.charAt(high))
            {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
