//Time complexity: O(2^N)
//Space complexity: O(N)
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s.length() == 0 || s == null) {
            return result;
        } 
        helperMethod(s, new ArrayList<>());
        return result;
    }
    
    public void helperMethod(String s, List<String> path) {
       //base
        if(s.length() == 0) {
            result.add(new ArrayList<>(path));
        }
        //logic
        for(int i = 0; i < s.length(); i++) {
            if(isPalindrome(s, 0, i)) {
                //action
                path.add(s.substring(0,i+1));
                //recursion
                helperMethod(s.substring(i+1), path);
                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }
    
    
    public boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}