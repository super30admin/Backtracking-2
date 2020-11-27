import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode accepted: yes
 * Problems faced: NA
 */
public class PalindromePartitioning {
	static List<List<String>> result = new ArrayList<>();
	static List<String> temp = new ArrayList<>();
	
    public static List<List<String>> partition(String s) {
        helper(s, 0);
        return result;
    }
    
    public static void helper(String s, int pos) {
        if(pos >= s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        //Iterate the end position thru the rest of the string
        for(int i=pos; i<s.length(); i++){
            String subStr =  s.substring(pos, i+1); 
            if(isPalindrome(subStr)){
                temp.add(subStr);
                helper(s, i+1); //since substring from pos to i is already inserted into temp
                temp.remove(temp.size()-1);
            }
        }
    }
    
    //Function check whether the given string is palindrome or not
    public static boolean isPalindrome(String s){
        int start = 0, end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    public static void main(String[] args) {
		System.out.println(partition("aab"));
    }
}
