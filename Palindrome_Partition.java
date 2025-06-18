// time complexity - O(n * 2^n)
// Space complexity - O(n)
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(new ArrayList<>(), s, 0);
        return result;
    }
    private void helper(List<String> path, String s, int pivot){
        // base case
        if(pivot >= s.length()){
            result.add(new ArrayList<>(path));
        }

        // logic
        for(int i = pivot; i < s.length(); i++){
            //action
            path.add(s.substring(pivot, i+1));
            // recurse
            if(isPalindrome(path.get(path.size()-1))){
                helper(path, s, i + 1);
            }
            // backtrack
            path.remove(path.size()-1);
        }
    }
    // function to check if a string is palindrome or not
    private boolean isPalindrome(String s){
        if(s.length() < 0) return false;

        for(int k = 0; k < s.length() / 2; k++){
            if(s.charAt(k) != s.charAt(s.length() - k - 1)) return false;
        }
        return true;
    }
}
