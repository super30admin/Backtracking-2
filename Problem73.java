// Time Complexity : O(2^n * n) 
// Space Complexity : O(n^2) 

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(String s, int pivot, List<String> path, List<List<String>> result) {
        //base
        if(pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        for(int i = pivot; i < s.length(); i++) {
            String subStr = s.substring(pivot, i+1);
            if(isPalindrome(subStr)){
                path.add(subStr);
                helper(s, i+1, path, result);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0; int right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++; right--;
        }

        return true;
    }
}