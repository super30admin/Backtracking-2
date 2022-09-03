import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(n * 2 power n) where n = length of string
// Space Complexity : O(h) where h = height of tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//131. Palindrome Partitioning (Medium) - https://leetcode.com/problems/palindrome-partitioning/
class Solution {
	// brute force rescurion
//	List<List<String>> result;
//    
//    public List<List<String>> partition(String s) {
//        result = new ArrayList<>();
//        helper(s, 0, new ArrayList<>());
//        return result;
//    }
//    
//    private void helper(String s, int pivot, List<String> path) {
//        // base
//        if (pivot == s.length()) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//        
//        // logic
//        for (int i = pivot; i < s.length(); i++) {
//            String partition = s.substring(pivot, i+1);
//            if (isPalindrome(partition)) {
//                // action
//                List<String> temp = new ArrayList<>(path);
//                temp.add(partition);
//                
//                // recurse
//                helper(s, i+1, temp);
//                
//                // backtrack
//                //path.remove(path.size()-1);
//            }
//        }
//    }
//    
//    private boolean isPalindrome(String s) {
//        int start = 0, end = s.length()-1;
//        
//        while (start < end) {
//            if(s.charAt(start++) != s.charAt(end--)) return false;
//        }
//        
//        return true;
//    }
	
	// 0, 1 recursion
//	List<List<String>> result;
//    
//    public List<List<String>> partition(String s) {
//        result = new ArrayList<>();
//        helper(s, 0, 0, new ArrayList<>());
//        return result;
//    }
//    
//    private void helper(String s, int pivot, int i, List<String> path) {
//        // base
//        if (pivot == s.length()) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//        
//        if (i == s.length()) return;
//        
//        // logic
//        // not choose
//        helper(s, pivot, i+1, path);
//            
//        // choose
//        String partition = s.substring(pivot, i+1);
//        if (isPalindrome(partition)) {
//            // action
//            path.add(partition);
//            
//            // recurse
//            helper(s, i+1, i+1, path);
//            
//            // backtrack
//            path.remove(path.size()-1);
//        }
//    }
//    
//    private boolean isPalindrome(String s) {
//        int start = 0, end = s.length()-1;
//        
//        while (start < end) {
//            if(s.charAt(start++) != s.charAt(end--)) return false;
//        }
//        
//        return true;
//    }
    
	// backtracking
    List<List<String>> result;
    
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(String s, int pivot, List<String> path) {
        // base
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        // logic
        for (int i = pivot; i < s.length(); i++) {
            String partition = s.substring(pivot, i+1); // O(n)
            if (isPalindrome(partition)) {
                // action
                path.add(partition);
                
                // recurse
                helper(s, i+1, path);
                
                // backtrack
                path.remove(path.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s) { // O(n)
        int start = 0, end = s.length()-1;
        
        while (start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        
        return true;
    }
}