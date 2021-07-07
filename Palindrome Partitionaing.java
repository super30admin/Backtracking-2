//Time Complexity : O(2^N * N). O(N) time is required for checking for palindrome. o(N) time for extracting substring. And both of these are done exponential times. i.e, 2^N(O(N)+O(N)) =2[2^N * O(N)] ~~  O(2^N * N)
//Space Cmplexity : O(N). the recursive stack takes O(N) time (length of string), the path list will take O(N) and add the substring to path wiyll take O(N).


// Using the iterative approach of backtracking, visit each character and inturn call recursive function. 
// During this the , before the action check if this substring is a palindrome and when the end of string is reached, backtrack.


class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s==null||s.length()==0){
            return result;
        }
        //helper function to backtrack
        helper(s,0,new ArrayList<>());
        return result;
    }
    private void helper(String s, int index, List<String> path){
        if(index == s.length()){
            //when the end of the string is reached we would have a valid substring
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            //before choosing check if the substring is a palindrome
            if(isPalindrome(s,index,i)){
                //ACTION: choose the substring
                path.add(s.substring(index,i+1));
                //RECURSE
                helper(s,i+1,path);
                //BACKTRACK
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s,int start,int end){
        //check if the characters at both ends are matching
        
        while(start<=end){
              if(s.charAt(start)!=s.charAt(end)){
                  return false;
              }
            start++;
            end--;
        }
        return true;
    }
}