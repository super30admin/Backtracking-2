import java.util.ArrayList;
import java.util.List;
/*
Time complexity: O(N*2^N) where N is the length of the given string and there will be 2^N combinations for
each character of the String
Space Complexity: O(N), I am using DFS which would require stack here N is the size of stack

Run on leetcode: yes

Approach:
I am using backtrack tree to make all the possible combination for the palindrome, I would be staring from the
0 the character and make it's possible combination with other characters, I am gonna check is the given string is palindrome
then only I am gonna add that into my resultant and soon
 */
public class PalindromePartitioning {
    public static List<List<String>> palindromePartition(String s){
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();

        backtrackingPalindrome(s, 0, result, list);
        return result;
    }
    public static void backtrackingPalindrome(String s, int start,List<List<String>> result,List<String> list ){
        if(start>=s.length()){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int end = start; end<s.length(); end++){
            if(isPalindrome(s, start, end)){
                list.add(s.substring(start,end+1));
                backtrackingPalindrome(s, end+1, result, list);
                list.remove(list.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String str, int start, int end){
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("Palindrome Partitions: "+palindromePartition("aab"));
    }
}
