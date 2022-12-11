import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromePartioning {
    //https://leetcode.com/problems/palindrome-partitioning/

    /* Generate a Recursive tree with palindrome partitions
    *If the for loop recursion find any combination that is not a valid palindrome do not process it further
    * and go back to the parent
    * once you have reach the end capture the output
    *Time Complexity = O(2^l*l) l = length of string (l for finding the isPalindrome )
    *Space Complexity = O(n) - number of elements getting stored in the path, and for recursive stack height of
    * tree
    * */
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
    static  List<List<String>> result;
    public static List<List<String>> partition(String s) {
        if(s==null ||s.length()==0) return Collections.emptyList();
        result=new ArrayList<>();
        recurse(s, 0, new ArrayList<>());
        return result;

    }

    private static void recurse(String s, int index, List<String> path ) {
    //base
        if(index==s.length()){
            result.add((new ArrayList<>(path)));
            return;
        }
        //logic
        for (int i = index; i <s.length() ; i++) {
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
                recurse(s,i+1,path);
                path.remove(path.size()-1);

            }
        }

    }

    private static boolean isPalindrome(String s,int left, int right) {
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;

    }


}
