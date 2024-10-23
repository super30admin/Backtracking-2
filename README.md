# Backtracking-2

## Problem1 
Subsets (https://leetcode.com/problems/subsets/)


Approached Solution: In this solution we will generate all possible subsets of a given integer array using an iterative approach and a recursive backtracking method. In the case of iterative method, we will build subsets by iterating over the array and extending the existing subsets in the result list. In the case of recursive method we will explore each number in the array and will add it to a current path, then we will recurse again and then backtrack to try out other combinations. The for loop in the recursive function will systematically include and exclude elements to generate subsets.

Time Complexity: The time complexity is O(n * 2^n) where n is the length of the input array. This is because there are possible 2^n subsets and for each subset we are copying the elements to the result and iterating over that array again.

Space Complexity: The space complexity is O(n * 2^n) to store all the possible subsets and the temporary paths during recursion.

Approached Code: - 
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        for(int i = 0; i < nums.length; i++) {
            int len = result.size();
            for(int j = 0; j < len; j++) {
                List<Integer> curr = new ArrayList<>(result.get(j));
                curr.add(nums[i]);
                result.add(curr);
            }
        }

        // helper(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void helper(int[] nums, int idx, 
    List<Integer> path, List<List<Integer>> result) {

        // base
        // if(idx == nums.length) {
        //     result.add(new ArrayList<>(path));
        //     return;
        // }

        result.add(new ArrayList<>(path));
        if(idx == nums.length) return;

        // logic
        // don't choose
        // helper(nums, idx+1, path, result);


        // // choose
        // // action
        // path.add(nums[idx]);

        // // recurse
        // helper(nums, idx+1, path, result);

        // // backtrack
        // path.remove(path.size() - 1);


        // for-loop based recursion
        for(int i = idx; i < nums.length; i++) {
            //action
            path.add(nums[i]);

            //recurse
            helper(nums, i+1, path, result);

            //backtrack
            path.remove(path.size() - 1);
        }
    }
}



## Problem2

Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)


Approached Solution: In this solution first we will partition string into all possible palindromic substrings using backtracking. In the recursive helper function we will explore every possible partition by checking if the current substring is a palindrome or not. If it is a palindrome, the substring will be added to the path and the function will recurse further to explore the next partitions. Upon reaching the end of the string, a valid partition will be added to the result. The function will then backtrack to explore other partition possibilities.

Time Complexity: In this approach the time complexity will be O(n * 2^n) where n is the length of the string as we are accounting for generating all possible partitions and checking each substring for palindrome properties.

Space Complexity: In this approach space complexity will be O(n) for the recursive stack and O(n * 2^n) to store all partition results.

Approached Code: 
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        helper(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void helper(String s, int pivot, 
    List<String> path, List<List<String>> result) {

        // base
        if(pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic

        for(int i = pivot; i < s.length(); i++) {
            String currSubstr = s.substring(pivot, i+1);

            if(checkPalindrome(currSubstr)) {
                //action
                path.add(currSubstr);
                //recurse
                helper(s, i+1, path, result);
                //backtrack
                path.remove(path.size() - 1);
            }
        }

    }

    private boolean checkPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}


