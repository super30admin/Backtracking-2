# Backtracking-2

## Problem1 
Subsets (https://leetcode.com/problems/subsets/)
class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        for(int n : nums){

            int size = result.size();

            for(int i=0; i<size; i++){

                List<Integer> subset = new ArrayList<>(result.get(i));

                subset.add(n);

                result.add(subset);

            }

        }

        return result;

    }

}

## Problem2

Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)

class Solution { 

    public List<List<String>> partition(String s) { 

        List<List<String>> results = new ArrayList<>(); 

        int n = s.length(); 

        int numOfSubsets = 1 << (n - 1);          for (int subsetMask = 0; subsetMask < numOfSubsets; subsetMask++) { 

            List<String> currentPartition = new ArrayList<>(); 

            int start = 0; 

            boolean valid = true;             for (int i = 0; i < n - 1; i++) {  

                if ((subsetMask & (1 << i)) != 0) { 

                    String substring = s.substring(start, i + 1); 

                    if (isPalindrome(substring)) { 

                        currentPartition.add(substring); 

                        start = i + 1; 

                    } else { 

                        valid = false; 

                        break; 

                    } 

                } 

            }             if (valid) { 

                String substring = s.substring(start); 

                if (isPalindrome(substring)) { 
                        currentPartition.add(substring); 

                    results.add(currentPartition); 

                } 

            } 

        }         return results; 

    }     private static boolean isPalindrome(String s) { 

        int i = 0, j = s.length() - 1; 

        while (i < j) { 

            if (s.charAt(i++) != s.charAt(j--)) { 

                return false; 

            } 

        } 

        return true; 

    } 

} 

