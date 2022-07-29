//Time Complexity= 2^length of the string
//Space complexity = O(length of the string)
//Intuit Interview
//Recursion approach
//If current given string is a palindrome then check for a baby child of the string which is separated by a valid partion .If current string is not a palindrome no need of checking the baby child of string.ex.aba = aba or madam =madam and partitiontin palindrome  aba = [a,a,b],[aa,b] here starting with ex ba then b = index and a =i and b is a local variable which hold the position .
class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return result;
        helper(s,new ArrayList<>());
        return result;
    }
    private void helper(String s,List<String> path){
        //base
        if(s.length()==0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s,0,i)){
                //action
                path.add(s.substring(0,i+1));
                //recurse
                helper(s.substring(i+1),path); 
                //backtrack
                path.remove(path.size()-1);
                
            }
        }
    }
    private boolean isPalindrome(String s,int left,int right){
        while(left<=right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}