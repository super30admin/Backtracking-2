class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> solution = new ArrayList<>();
        List<String> state = new ArrayList<>();
        
        backtrack(solution, state, s, 0);
        
        return solution;
    }
    private void backtrack(List<List<String>> solution, List<String> state, String s, int start)
    {
        //calls are made if and only if current token is palindrome
        //isGoal
        if(start == s.length())
        {
            solution.add(new ArrayList<>(state));
            return;
        }
        
        //fan out for loop
        for(int i=start;i<s.length();i++)
        {
            if(isPalindrome(s, start, i)){
                state.add(s.substring(start, i+1));
                backtrack(solution, state, s, i+1);
                state.remove(state.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String str, int start, int end)
    {
        while(start <= end)
        {
            if(str.charAt(start) != str.charAt(end))
                return false;
            
            start++;
            end--;
        }
        return true;
    }
}