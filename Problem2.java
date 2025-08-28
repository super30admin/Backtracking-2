//Time Complexity: O(n * 2^n) where n is the length of the input string
//Space Complexity: O(n) for the recursion stack

//We use recursion with backtracking.Start with a pivot index at 0.
//At each step, expand the substring from pivot to i:
//If the substring is a palindrome, add it to the current path.Recurse for the remaining string starting from i+1.
//Backtrack to explore other possibilities.
// If pivot reaches the end of the string, add the current path to the result.


class Solution {
    //for loop recursion with backtracking
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result=new ArrayList<>();
        List<String> path=new ArrayList<>();
        helper(s,0,path);
        return result;
    }
    private void helper(String s,int pivot,List<String> path){
        if(pivot==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=pivot;i<s.length();i++){
            String sb=s.substring(pivot,i+1);
            if(isPalindrome(sb)){
                path.add(sb);
                helper(s,i+1,path);
                path.remove(path.size()-1);  //backtracking
            }
        }
    }
    private boolean isPalindrome(String s){
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j))
                return false;
        }
        return true;
    }
}