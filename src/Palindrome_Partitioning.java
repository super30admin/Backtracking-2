import java.util.*;
/********************************************Using Backtracking*******************************************/
//Time Complexity : O(n2^n), n is the length of the string
//Space Complexity : O(n), single list used
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/*  Using Backtracking, we check whether the substring considered is palindrome or not
2.  If its palindrome, we check the remaining possible substrings
3.  If its not palindrome, we backtrack to the previous state and check for other possible substrings from that state*/

public class Palindrome_Partitioning {
	static List<List<String>> result;
	public static List<List<String>> partition(String s) {
		result = new ArrayList<>();
		//base case
		if(s == null || s.length() == 0)
			return result;

		backtrack(s, new ArrayList<>(), 0);
		return result;
	}

	private static void backtrack(String s, List<String> temp, int start){
		//base case
		if(start >= s.length()) // if start reaches end of string, when no characters left to process
			result.add(new ArrayList<>(temp));

		//logic
		for(int i = start; i < s.length(); i++){
			if(isPalindrome(s, start, i)){  //check if substring is palindrome
				//action
				temp.add(s.substring(start, i+1));
				//recurse
				backtrack(s, temp, i+1);	// backtrack(s.substring(i), temp, 0+1);
				//backtrack
				temp.remove(temp.size()-1);
			}
		}
	}
	private static boolean isPalindrome(String s, int start, int end){
		if(start == end)
			return true;

		while(start < end){
			if(s.charAt(start) != s.charAt(end))
				return false;

			start++;
			end--;
		}
		return true;
	}
	public static void main(String[] args) {
		String s = "aab";
		System.out.print(partition(s));
	}
}

/********************************************Using Recursion*******************************************/
//Time Complexity :O(n* 2^n), n is the length of the string
//Space Complexity :O(n * 2^n) as a new list created at each recursion point
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Palindrome_Partitioning_Recurse {
	List<List<String>> result;
	public List<List<String>> partition(String s) {
		result = new ArrayList<>();
		//base case
		if(s == null || s.length() == 0)
			return result;

		helper(s, new ArrayList<>(), 0);
		return result;
	}

	private void helper(String s, List<String> temp, int start){
		//base case
		if(start >= s.length()) // if start reaches end of string, when no characters left to process
			result.add(temp);

		//logic
		for(int i = start; i < s.length(); i++){
			if(isPalindrome(s, start, i)){  //check if substring is palindrome
				List<String> newList = new ArrayList<>(temp);
				newList.add(s.substring(start, i+1));

				helper(s, new ArrayList<>(newList), i+1);
			}
		}
	}
	private boolean isPalindrome(String s, int start, int end){
		if(start == end)
			return true;

		while(start < end){
			if(s.charAt(start) != s.charAt(end))
				return false;

			start++;
			end--;
		}
		return true;
	}
}