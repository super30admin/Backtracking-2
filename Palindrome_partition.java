//Time Complexity : O(2^n)
class Solution {
    List<List<String>> result = new ArrayList<>();
    void helper(String s, int pivot, List<String> path) {
       if(pivot == s.length()) {
           result.add(new ArrayList<>(path));
           return;
       }
        for(int i= pivot; i<s.length();i++) {
            String currSubstring = s.substring(pivot,i+1);
            if(isPalindrome(currSubstring)) {
                path.add(currSubstring);
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }

    }
    boolean isPalindrome(String s) {
        int first=0;
        int last = s.length()-1;
        while(first < last) {
            if(s.charAt(first) != s.charAt(last)) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        //For loop based recursion
        List<String> path = new ArrayList<>();
        helper(s,0,path);
        return result;
    }
}