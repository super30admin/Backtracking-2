/* 

Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)

Time Complexity : O(2^n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(s, 0, new ArrayList<>());
        return result;
    }

    private void recurse(String s, int index, List<String> path){

        if(index == s.length()){
            result.add(new ArrayList<>(path));
        }

        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index, i+1));
                recurse(s, i+1, path);
                path.remove(path.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}