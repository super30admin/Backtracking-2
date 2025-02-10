// In this problem, we using backtracking, we are carrying a data structure with us i.e list, adding the strings that are palindrome
// to the list, and making further recursive calls. So we are checking every length substring starting from every character.

// Time Complexity :Exponential
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Using for based recursion:
class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        // Base case
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        // Declare result list
        result = new ArrayList<>();
        // Recursive call
        recurse(s, 0, new ArrayList<>());
        return result;
    }

    private void recurse(String s, int index, List<String> path) {
        // Base case - // If we are out of characters, add the partition list to the
        // outer list and return
        if (index == s.length()) {
            result.add(path);
            return;
        }
        // Logic
        for (int i = index; i < s.length(); i++) {
            // Checking each substring starting from index till i is palindrome or not
            if (isPalindrome(s, index, i)) {
                // If it is, add that substring to the list
                List<String> newList = new ArrayList<>(path);
                newList.add(s.substring(index, i + 1));
                // And move index to i+1 and recurse
                recurse(s, i + 1, newList);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

// Backtracking solution using for loop based recursion:
class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int index, List<String> path) {
        // Base case
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        // Logic
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                // Action
                path.add(s.substring(index, i + 1));
                // recurse
                backtrack(s, i + 1, path);
                // Backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

// Without using index, instead of passing the whole string in each recursive
// call, passing the substring
class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        backtrack(s, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, List<String> path) {
        // Base case
        if (s.length() == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        // Logic
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                path.add(s.substring(0, i + 1));
                backtrack(s.substring(i + 1), path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
