//Time Complexity: O(2^n)
//Space Complexity: O(2^n) - system stack
//Leetcode: Yes


class Solution {
    public List<List<String>> partition(String s) {
     List<List<String>> result = new ArrayList<>();
        List<String> stack = new ArrayList<>();
        dfs(result, stack, s, 0);
        return result;
    }
    public void dfs(List<List<String>> result, List<String> stack, String s, int start){
        if(start == s.length()){
            result.add(new ArrayList<String>(stack));
            return;
        }
        for(int end = start;end<s.length();end++){
        if(isPalindrome(s, start, end)){
            stack.add(s.substring(start, end+1));
            dfs(result, stack, s, end+1);
            stack.remove(stack.size()-1);
        }
      }
    }
    
    public boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start) != s.charAt(end))return false;
            else{
                start++;
                end --;
            }
        }
        return true;
    }
}
