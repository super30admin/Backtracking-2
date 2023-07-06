import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromePartitioning01Recursion {

    // 01 recursive backtrack

    List<List<String>> result;

    public List<List<String>> partition(String s) {

        result = new ArrayList<>();

        helper(s, 0, 0, new ArrayList<>(), 0);

        return result;
    }

    private void helper(String s, int idx, int i, List<String> path, int l) {

        //base
        if(i == s.length()) {

            if(l == s.length()) {

                result.add(new ArrayList<>(path));
            }

            return;
        }

        // logic
        // no choose
        helper(s, idx, i+1, path, l);

        //choose
        String subStr = s.substring(idx, i+1);

        if(isPalindrome(subStr))  {

            //action
            path.add(subStr);

            //recurse
            helper(s, i+1, i+1, path, l + subStr.length());

            //backtrack
            path.remove(path.size() - 1);
        }

    }

    private boolean isPalindrome(String s) {

        int start = 0;

        int end = s.length() - 1;

        while(start < end) {

            if(s.charAt(start) != s.charAt(end)) return false;

            start++;

            end--;
        }
        return true;
    }

    public static void main(String[] args){

        PalindromePartitioning01Recursion object = new PalindromePartitioning01Recursion();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        List<List<String>> result = object.partition(input);

        for (List<String> innerList : result) {
            for (String element : innerList) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

/* Time Complexity = O(N*2^N)

N = Length of string,
O(N) = generate substring and check if palindrome
2^N = substrings - worst case

Space Complexity = O(N) - recursive stack in backtracking */