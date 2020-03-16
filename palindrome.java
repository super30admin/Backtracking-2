# Time complexity:O(n)
# Space complexity: 0(n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No




class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> solution = new ArrayList<>();
       List<String> state = new ArrayList<>();
        backtrack(solution, state, s, 0);
        return solution;
    }



    private void backtrack(List<List<String>> solution, List<String> state, String s, int start){

        if(start == s.length()){
            solution.add(new ArrayList<>(state));
            return;
        }

        for(int end = start; end < s.length(); end++){
            if(isPalindrome(s,start,end)){

                state.add(s.substring(start,end + 1));
                backtrack(solution,state,s,end + 1);
                state.remove(state.size() - 1);
            }
        }
    }



    private boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }
}