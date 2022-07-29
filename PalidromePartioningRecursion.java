//Time Complexity= 2^length of the string
//Space complexity = O(length of the string)
//Intuit Interview
//Recursion approach
//If current given string is a palindrome then check for a baby child of the string which is separated by a valid partion .If current string is not a palindrome no need of checking the baby child of string.ex.aba = aba or madam =madam and partitiontin palindrome  aba = [a,a,b],[aa,b] here starting with ex ba then b = index and a =i and b is a local variable which hold the position .
class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return result;
        helper(s,0,new ArrayList<>());
        return result;
    }
    private void helper(String s,int index, List<String> path){
        //base
        if(index == s.length()){
            result.add(path);
            return;
        }
        //logic
        for(int i= index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                //action
                List<String> newlist = new ArrayList<>(path);
                newlist.add(s.substring(index,i+1));
                //recurse
                helper(s,i+1,newlist);
                
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