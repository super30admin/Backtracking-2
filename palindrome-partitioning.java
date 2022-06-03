//Time Complexity: O(n)
//Space Complexity:o(1)
//Did this code successfully run on Leetcode :Yes
class Solution {
    boolean isPalindrome(String s, int start, int end)
    {
        while (start < end)
        {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    void findAllPalindromes (String s, int start, List<String> currentPalindrome, List<List<String>> allPalindromes) {
        if(start >= s.length()) {
            allPalindromes.add(new ArrayList<> (currentPalindrome));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                currentPalindrome.add(s.substring(start, i + 1));
                findAllPalindromes (s, i + 1, currentPalindrome, allPalindromes);
                currentPalindrome.remove(currentPalindrome.size() - 1);
            }
        }
    }
    List<List<String>> getPartitions(String s) {
        List<List<String>> allCombinations = new ArrayList<List<String>> ();
        List<String> currentCombination = new ArrayList<String> ();
        findAllPalindromes (s, 0, currentCombination, allCombinations);
        return allCombinations;
    }
}