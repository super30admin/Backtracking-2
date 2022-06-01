
//Time: O(N*2^N)*O(Length of the string - isPalindrome) | Space: O(N)

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }
    private void helper(String s, int pivot, List<String> path) {
        if(pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=pivot;i<s.length();i++) {
            String subStr = s.substring(pivot, i+1);
            if(isPalindrome(subStr)) {
                path.add(subStr);
                helper(s, i+1,path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}