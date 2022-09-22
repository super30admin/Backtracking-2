// Time Complexity : O(exp)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
For loop based recursion and backtracking, but at each point, check if the substring is palindrome
only then expand under that path
*/
public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result= new ArrayList<>();
        if(s.length()==0 || s==null) return result;
        helper(s,0,new ArrayList<>());
        return result;
    }

    private void helper(String s, int index, ArrayList<String> path){
        if(index==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            String subString=s.substring(index,i+1);
            path.add(subString);
            if(isPalindrome(subString)){
                helper(s,i+1,path);
            }
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s){
        if(s.length()==0) return false;
        int left=0, right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
