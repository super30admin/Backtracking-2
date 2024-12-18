// Time complexity = O(n*2^n) // n for substring, and 2^n for all combinations of n length array.
// Space complexity = O(n)// creation of arraylist.
class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(0, s, new ArrayList<>());
        return res;        
    }
    
    private void helper(int pivot, String s, List<String> path) {
        if(pivot == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=pivot;i<s.length();i++) {
            String sub = s.substring(pivot, i+1);
            if(isPalindrome(sub)) {
                path.add(sub);    
                helper(i+1, s, path);
                path.remove(path.size()-1);
            } 
            

        }
    }
    
    private boolean isPalindrome(String s) {
        int start =0;
        int end = s.length()-1;
        while(start<=end) {
            if(s.charAt(start) != s.charAt(end))  {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}