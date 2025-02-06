import java.util.ArrayList;
import java.util.List;
/*
Recursion based by passing index
*/
class Solution1{
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(s, 0, new ArrayList<>());
        return result;
    }

    private void recurse(String s, int index, List<String> path) {
        // base
        if (index == s.length()) {
            result.add(path);
        }
        // logic
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                // action
                List<String> newList = new ArrayList<>(path);
                newList.add(s.substring(index, i + 1));

                // recurse
                recurse(s, i + 1, newList);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
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

/*
BackTrack based by passing index
 */
class Solution2 {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(s, 0, new ArrayList<>());
        return result;
    }

    private void recurse(String s, int index, List<String> path) {
        // base
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
        }
        // logic
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                // action
                path.add(s.substring(index, i + 1));

                // recurse
                recurse(s, i + 1, path);
                // bactrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
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
/*
BackTrack without passing index
 */

class Solution3 {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(s, new ArrayList<>());
        return result;
    }

    private void recurse(String s, List<String> path) {
        // base
        if (s.length() == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                // action
                path.add(s.substring(0, i + 1));

                // recurse
                recurse(s.substring(i + 1), path);
                // bactrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
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