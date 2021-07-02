import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
TC : exponential 2^ no of subsets
SC : similar to above
LC : not passing all cases
Problems : need to handle all cases
 */
public class PalindromePartition {


    public List<List<String>> list = new ArrayList();

    /**
     * In this approach we iterate over the string considering only a part of the string and at each stage we add the substring in the resultant path
     * if and only if it is a palindrome. If we reach the end, where the string is empty then tha means
     * all the substring added so far are palindromes.
     * Hence, we simply add this in the final list.
     * <p>
     * Also, we remove the last substring added after the recursion call to perform backtracking.
     *
     * @param s
     * @return
     */
    public List<List<String>> partition_with_backtracking(String s) {

        helper_with_backtracking(s, new ArrayList<>());
        return list;
    }

    public void helper_with_backtracking(String s, List<String> path) {

        if (s.length() == 0)
            list.add(new ArrayList<>(path));

        for (int i = 0; i < s.length(); i++) {


            if (isPalindrome(s, 0, i)) {
                path.add(s.substring(0, i + 1));
                helper_with_backtracking(s.substring(i + 1), path);
                path.remove(path.size() - 1);
            }
        }

    }

    public boolean isPalindrome(String str, int start, int end) {


        if (start == end)
            return true;

        while (start <= end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }


    /**
     * The approach taken here is the same as before. Just that instead of removing the last added substirng and backtracking,
     * we create a deep copy of the list everytime and use that.
     */

    public List<List<String>> list_with_recursion = new ArrayList();

    public List<List<String>> partition_with_recursion(String s) {

        helper_with_recursion(s, new ArrayList<>());
        return list_with_recursion;
    }

    public void helper_with_recursion(String s, List<String> path) {

        if (s.length() == 0)
            list_with_recursion.add(path);

        for (int i = 0; i < s.length(); i++) {


            if (isPalindrome(s, 0, i)) {
                List<String> copy = new ArrayList<>(path);
                copy.add(s.substring(0, i + 1));
                helper_with_recursion(s.substring(i + 1), copy);

            }
        }

    }


}
