# Backtracking-2

## Problem1 
Subsets (https://leetcode.com/problems/subsets/)
TC:O(2^N * N)
SC: O(2^N × N)

//Approach:-
1. We will form the subsets by picking or not picking the current element
2. if we reach the end of the array then we will add the subset to our list

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        allSubsets(nums, 0, temp, ans);

        return ans;
    }

    public static void allSubsets(int[] nums, int i, List<Integer>temp, List<List<Integer>> ans){

        //base case
        if(i == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        //pick
        temp.add(nums[i]);
        allSubsets(nums, i+1, temp, ans);

        //not-pick
        temp.remove(temp.size()-1);
        allSubsets(nums, i+1, temp, ans);

    }
}


## Problem2

Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)
TC: O(2^N × N)
SC: O(2^N × N)


//Approach:-
1. We will check the substrings of the string is palindrome or not 
2. We will add the palindrome substring in the result upon reaching the end of the string

class Solution {
    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        palindrome(s, temp, 0);
        return ans;
    }

    private void palindrome(String s, List<String> temp, int ind) {
        if (ind == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = ind; i < s.length(); i++) {

            if (isPalindrome(s, ind, i)) {

                temp.add(s.substring(ind, i + 1));

                palindrome(s, temp, i + 1);

                temp.remove(temp.size() - 1); // backtrack

            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {

        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        return true;
    }
}