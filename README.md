# Backtracking-2

## Problem1 
Subsets (https://leetcode.com/problems/subsets/)

TC still N * 2^N

class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {

        result = new ArrayList<>();

        if(nums == null || nums.length == 0) return result;

        helper(nums, 0,  new ArrayList<>());

        return result;

    }

    private void helper(int [] nums, int i, List<Integer> path){

        // base

        if(i == nums.length){

            result.add(new ArrayList<>(path));

            return;

        }

        // logic

         // dont choose

        helper(nums, i+1, path);

         //choose

        path.add(nums[i]);

        helper(nums, i+1, new ArrayList<>(path));

        // backtrack

        path.remove(path.size() - 1);

    }

}

## Problem2

Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)


class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> ans;
        
        // Loop through all possible subsets
        // using bit manipulation
        for (int i = 0; i < (1 << n); i++) {

            // Loop through all elements
            // of the input array
            vector<int> arr;
            for (int j = 0; j < n; j++) {

                // Check if the jth bit is set
                // in the current subset
                if ((i & (1 << j)) != 0) {

                    // If the jth bit is set,
                    // add the jth
                    // element to the subset
                    arr.push_back(nums[j]);
                }
            }

            ans.push_back(arr);
        }
        return ans;
    }
};



public class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] isP = new boolean[s.length()][s.length()];
        List<List<String>> result = new LinkedList<List<String>>();
        List<String> curr = new LinkedList<String>();
        calIsP(isP, s);
        process(result, isP, s, curr, 0);
        return result;
    }
    private void process(List<List<String>> result, boolean[][] isP, String s, List<String> curr, int start) {
        if (start == s.length()) {
            result.add(new LinkedList<String>(curr));
        }
        for (int i = start; i < s.length(); i ++) {
            if (isP[start][i] == true) {
                curr.add(s.substring(start, i + 1));
                process(result, isP, s, curr, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
    private void calIsP(boolean[][] isP, String s) {
        for (int i = 0; i < s.length(); i ++) {
            isP[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i ++) {
            isP[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int k = 2; k < s.length(); k ++) {
            for (int i = 0; i + k < s.length(); i ++) {
                isP[i][i + k] = s.charAt(i) == s.charAt(i + k) && isP[i + 1][i + k - 1] == true;
            }
        }
    }
}