# Backtracking-2

## Problem1

Subsets (https://leetcode.com/problems/subsets/)

//Time Complexity = Exponential
//space complexity = O(N)

// class Solution {
// List<List<Integer>> result;
// public List<List<Integer>> subsets(int[] nums) {
// result = new ArrayList();
// if(nums== null || nums.length == 0) {
// return result;
// }
// helper(nums, 0, new ArrayList());
// return result;
// }
// private void helper(int[] nums,int pivot, List<Integer> path) {
// //base

// result.add(new ArrayList(path));
// //logic
// for(int i = pivot; i < nums.length; i++) {
// path.add(nums[i]);
// helper(nums, i+1, path);
// path.remove(path.size() - 1);
// }
// }
// }

class Solution {
List<List<Integer>> result;
public List<List<Integer>> subsets(int[] nums) {
result = new ArrayList();
if(nums == null || nums.length == 0) {
return result;
}
helper(nums, 0, new ArrayList());
return result;
}
private void helper(int[] nums,int index, List<Integer> path) {
//base
if(index == nums.length) {
result.add(new ArrayList(path));
return;
}

        //logic
        //choose
        path.add(nums[index]);
        helper(nums,index+1,path);
        path.remove(path.size() - 1);

        //dont choose
        helper(nums,index+1,path);
    }

}

## Problem2

Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)

//Time Complexity = Exponential
//space complexity = O(N)

class Solution {
List<List<String>> result;
public List<List<String>> partition(String s) {
result = new ArrayList<>();
if(s.length() == 0 || s == null) {
return result;
}
helper(s, 0, new ArrayList());
return result;
}
private void helper(String s, int index, List path) {
//base
if(index == s.length()) {
result.add(new ArrayList(path));
}
//logic

        for(int i = index; i < s.length(); i++) {
            s.substring(index, i+1);
            if(isPalindrome(s,index,i)) {
                path.add(s.substring(index, i+1));
                helper(s, i + 1,path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end) {
        if(start == end) {
            return true;
        }
        char[] chars = s.toCharArray();
        while(start < end) {
            if(chars[start] != chars[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

}
