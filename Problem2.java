// Time Complexity : O(Lx2^L)
// Space Complexity : O(l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//131. Palindrome Partitioning
//https://leetcode.com/problems/palindrome-partitioning/



class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {

        if (s.length() == 0)
            return result;
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<String>());

        return result;
    }

    private void helper(String s, int index, List<String> list) {
        // base
        if (index == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        // logic
        for (int i = index; i < s.length(); i++) {
            // System.out.println("index " + index);
            // System.out.println("i " + i);
            String temp = s.substring(index, i + 1);
            if (isPalindrome(temp)) {
                list.add(temp);
                helper(s, i + 1, new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        boolean flag = true;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                flag = false;
                break;
            } else {
                i++;
                j--;
            }
        }
        return flag;
    }
}