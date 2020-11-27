package backtracking2;

//Idea: We choose from any element or substring recursively and check if it is palindrome or not. 
// 		Every time we add an character or subarray from string to our possible result list, 
// 		we increment the start pointer by 1.

//TC: O((n)(2^n)) where 2^n is the number of recursive calls and every result undergoes 
//				  check for palindrome validation
//SC: O(2^n) because 2^n is the space occupied by recursive combinations of possible substrings.


import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        backtracking(result, s, 0, new ArrayList<>());
        return result;
    }
    
    static void backtracking(List<List<String>> result, String s, int start, List<String> temp) {
        if(start == s.length()) {  // if pointer reaches end of the string
            result.add(new ArrayList<>(temp));
        }
        
        else {
         for(int i = start; i < s.length(); i++) {
            if(isPalindrome(s, i, start)) {
                temp.add(s.substring(start, i + 1)); // adds all the valid palindrome substrings in temp list
                backtracking(result, s, i + 1, temp); // incrementing the index by 1
                
                temp.remove(temp.size() - 1); // taking a step back
            }
        }   
        }   
    }
    
    // method to check whether a substring is palindrome or not
static boolean isPalindrome(String s, int high, int low) {
    while(low < high) {
        if(s.charAt(low++) != s.charAt(high--)) {
            //low++;
            //high--;
            return false;
        }
    }
    return true;
}

public static void main(String[] args) {
	System.out.println(partition("aab"));
}
	
}
