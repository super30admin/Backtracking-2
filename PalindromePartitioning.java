import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> result;
    List<String> path;
    public List<List<String>> partition(String s) { //O(l*(2^l)) T.C, O(l) S.C
        result = new ArrayList<>();
        path = new ArrayList<>();

        recursion(s, 0);

        return result;
    }

    void recursion(String s, int pivot) {
        //base
        if(pivot == s.length()) { //if pivot reaches end of string
            result.add(new ArrayList<>(path)); //deep-copy current path to result
            return;
        }

        //logic
        for(int i=pivot; i<s.length(); i++) {
            //create sub-strings from pivot to end of string length
            String substring = s.substring(pivot, i+1); //O(l) T.C, O(2l) S.C
            if(isPalindrome(substring)) { //if this substring is a valid palindrome
                //action
                path.add(substring);

                //recurse
                recursion(s, i+1); //perform recursion on the rest of string

                //backtrack
                path.removeLast();
            }
        }
    }

    //to check if a string is palindrome
    boolean isPalindrome(String s) { //O(l) T.C where l is length of string, O(1) S.C
        int start = 0; //start pointer at index 0, first element
        int end = s.length()-1; //end pointer at last element

        while(start<end) { //until start is less than the end
            //if at any point, characters at each end are different, return false
            if(s.charAt(start) != s.charAt(end)) return false;
            start++; //increment
            end--; //decrement
        }
        return true; //if out of while loop and all are equal, then it is a palindrome
    }

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        String s = "nitin";

        System.out.println("The palindrome partitioned substrings of given string " + s + " is "
                + palindromePartitioning.partition(s));
    }
}