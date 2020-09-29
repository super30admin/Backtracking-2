package s30;
import java.util.ArrayList;
import java.util.List;

/*
* Time Complexity - O(N*2^N)
* Space Complexity - O(N)
*/
class PalindromePartition {
	
	public static void main(String[] args) {
		PalindromePartition obj = new PalindromePartition();
		List<List<String>> output = obj.partition("aab");
		System.out.println(output);	
	}
    
    //output stores the list of all possible partitions of the given string
    List<List<String>> output = new ArrayList<List<String>>();
    
    public List<List<String>> partition(String s) {
        //Return an empty list if the string is null or its length is zero
        if(s == null || s.length() == 0){
            return output;
        }
        
        helper(s, 0, new ArrayList<String>());
        
        return output;
    }
    
    /* params: 
    *  s  -  given input string
    *  index - starting index of the string from where partitioning is done
    *  path - one of the possible palindromic partitions of the substring from 0 to index
    */
    private void helper(String s, int index, List<String> path){
        //base condition to stop recursion
        //when there is no substring to process, add the path to output
        if(index == s.length()){
            output.add(new ArrayList<String>(path));
            return;
        }
        
        //logic
        for(int i=index+1; i <= s.length(); i++){
            /* Generate all possible substrings that start from the current index
            *  For each substring, check if it is a palindrome. 
            *  For each palindromic substring, call the helper function recursively to generate substrings for rest of the string
            */
            String substr = s.substring(index, i);
            if(isPalindrome(substr)){
                path.add(substr);
                helper(s, i, path);
                path.remove(path.size()-1);
            }
        }
    }
    
    //checks whether the string passed as argument is a palindrome
    private boolean isPalindrome(String str){
        for(int i=0, j=str.length()-1; i<j; i++,j--){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }
}