// Time Complexity : O(n*n^n) n for the palindrome iteration and n^n for recursion
// Space Complexity : O(m) m is max number of elements added to a path at once.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//similar to the all backtracking process.
// as we need to check for the palindrome, write a method to check for the palindrom of string and return boolean.
// we send substrings of each combination to check for palindrome and if valid then add to path and go for recursion.
//we need to add the list with all the elements given, hence add to output onle if the index is == or > String s length as it will have all given elements if the index equals/crosses the size of string
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtracking(s, output, 0, path);
        return output;
    }
    private void backtracking(String s, List<List<String>> output, int index, List<String> path){
        if(index>=s.length()){
            output.add(new ArrayList<>(path));
            return;
        }
        for(int i=index; i<s.length();i++){
            if(isPalindrome(s.substring(index,i+1))){
                path.add(s.substring(index,i+1));
                backtracking(s,output,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String str){
        int p1=0;
        int p2=str.length()-1;
        while(p1<=p2){
            if(str.charAt(p1++)!=str.charAt(p2--)){
                return false;
            }
        }
        return true;
    }
}