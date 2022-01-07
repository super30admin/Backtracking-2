// Time Complexity : O(n*2^n) = for cases such as "aaaa", where each subset is a palindrome
// Space Complexity : O(n) = call stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// This is recursive iterative approach.
class Solution {
    List<List<String>> decompositions;
    public List<List<String>> partition(String s) {
        decompositions = new ArrayList();

        decomposeString(s, 0, new ArrayList<>());

        return decompositions;
    }

    private void decomposeString(String s, int workingIndex, List<String> partialDecomposition) {
    /*
      If we have decomposed the whole string then add the
      'partialDecomposition' to decompositions, it is now complete.
    */
        // base
        if (workingIndex == s.length()) {
            decompositions.add(new ArrayList<>(partialDecomposition));
            return;
        }

        // logic
    /*
      Take every snippet take from the 'workingIndex' to the end of the
      string. This is our 'possibility space' that we can recurse into.
    */
        for (int i = workingIndex; i < s.length(); i++) {
      /*
        Only recurse if the snippet from 'workingIndex' (inclusive) to
        s.length() (inclusive) is a palindrome
      */
            if (isPalindrome(workingIndex, i, s)) {

                // 1.) Action/Choose - Take the snippet & add it to our decomposition 'path'
                String palindromicSnippet = s.substring(workingIndex, i + 1);
                partialDecomposition.add(palindromicSnippet);

        /*
          2.) Recurse/Explore - Recurse and advance progress 1 past right bound of
          the 'palindromicSnippet' which is 'i + 1'
        */
                decomposeString(s, i + 1, partialDecomposition);

        /*
          3.) Backtrack/Unchoose - We are done searching, remove the snippet from our
          'path'. Next loop iteration will try another snippet in this stack
          frame.
        */
                partialDecomposition.remove(partialDecomposition.size() - 1);
            }
        }
    }

    /*
      Checks if the region from left (inclusive) to right (inclusive) is a palindromic.
    */
    private boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}