class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, 0, new ArrayList<>(), 0);
        return result;
    }

    private void helper(String s, int pivot, int i, List<String> path, int count)
    {
        //base
        if(i == s.length())
        {
            if(count == s.length())
            {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        //logic
        //dont choose
        helper(s, pivot, i+1, path, count);

        //choose
        String substr = s.substring(pivot, i+1);

        if(isPalindrome(substr))
        {
             //action
            path.add(substr);

            //recurse
            helper(s, i+1, i+1, path, count+ substr.length());

            //backtrack
            path.remove(path.size()-1);
        }     
    }

    private boolean isPalindrome(String s)
    {
        int start =0;
        int end = s.length()-1;

        while(start < end)
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