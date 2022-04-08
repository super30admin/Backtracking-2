import java.util.ArrayList;
import java.util.List;

//Time Complexity: Exponential. O(n*2^n)
//Space Complexity: O(n) 
public class PalindromePartition {	
	
	List<List<String>> res;
    public List<List<String>> partition(String s) {
        res= new ArrayList<>();
        if(s==null || s.length()==0) return res;
        helper(s,0, new ArrayList<>());
        return res;
    }    
    private boolean isPalindrome(String str){
        int start=0;
        int end=str.length()-1;        
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return  true;
    }
    
    /** Approach: Recursion + Backtracking **/
    private void helper(String s, int index, List<String> path){
        //base
        if(index==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }        
        //logic
        for(int i=index; i<s.length(); i++){
            String split= s.substring(index, i+1); //O(n)            
            if(isPalindrome(split)){ //O(n)
                path.add(split); //action
                helper(s, i+1, path); //recurse
                path.remove(path.size()-1); //backtrack
            }            
        }
    }
	
	// Driver code to test above 
	public static void main (String[] args) {
		PalindromePartition ob = new PalindromePartition();
    	String s= "aab";     	
    	
		System.out.println("All palindrome partitions are: "+ob.partition(s));
	}
}
