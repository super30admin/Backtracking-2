/*

TC: O(N * 2^N) There are 2^N possibilities of substrings. N - length of the string.
SC: O(N) - The recursion tree could be of max height N.

1. Generate substrings starting from index 0. Check if it is a palindrome. 
2. If yes, add to the path list and continue with  generating substrings with different partitions. 
3. On traversing complete string, add path to result list.

*/

import java.util.*;

public class PalindromePartition {
    static List<List<String>> result = new ArrayList<>();

    public static List<List<String>> palindromePartition(String s){

        bt(s, 0, new ArrayList<String>());
        return result;
    }

    private static void bt(String s, int index, List<String> path){

        //base case
        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        //recursion
        for(int i = index + 1; i <= s.length(); i++){

            if(isPalindrome(s.substring(index, i))){
                path.add(s.substring(index, i));
                bt(s, i, path);
                path.remove(path.size() - 1);
            }
        }
    }



    private static boolean isPalindrome(String str){

        int l = 0, r = str.length() - 1;

        while(l < r){
            if(str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "abba";
        System.out.println(palindromePartition(s));
    }
}
