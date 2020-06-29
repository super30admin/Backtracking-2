// Time complexity- O(n * 2^n) where n is the length of string
// Space complexity- O(n * 2^n)
import java.util.*;
public class PalindromePartitioning {
    static List<List<String>> result = new ArrayList<>();
    static  List<List<String>> partition(String s) {
        listPalidromes(s, 0, new ArrayList<>());
        return result;
    }
    static void listPalidromes(String s, int i, List<String>temp)  {
        if(i >= s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int j = i; j < s.length(); j++) {
            if(isPalindrome(s, i, j)) {
                temp.add(s.substring(i, j+1));
                listPalidromes(s, j+1, temp);
                temp.remove(temp.size()-1);
            }
        }

    }
    static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aab";
        System.out.println(partition(str));
    }
}
