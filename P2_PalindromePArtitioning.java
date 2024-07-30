// TC: O(2^n)
// SC: O(2^n)
class Solution {
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() -1;
        while(i<j) {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    private void helper(String s, int pivot, List<String> path, List<List<String>> result) {
        if(pivot == s.length()) {
            result.add(new ArrayList<>(path));
        }

        for(int i=pivot ; i<s.length() ; i++) { 
            String str = s.substring(pivot, i+1); 
            System.out.println(str); 
            if(isPalindrome(str)) { 
                path.add(str);
                helper(s, i+1, path, result); 
                path.remove(path.size() - 1); 
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result); 
        return result;
    }
}