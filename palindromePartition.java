//Time Complexity:O(N*2^N) where N is the length of the input string.
//Space Complexity:O(N)
//In this problem, I'll be creating a backtrack function and a isPalindrome function. I'll also be creating a temp list to hold the string at that instant. In the backtrack function, I'll be adding the temp list to the result list whenever I reach the end of the array. Every time I enter the for loop, I'll be checking if the string at that instant is a palindrome or can lead to a palindrome. Based on the outcome of that function, I'll decide whether to proceed by adding the substring at that instant to the temp list and call backtrack recursively or not. 
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        if(s.length()==0){
            return res;
        }
        List<String> temp=new ArrayList<>();
        backtrack(res,temp,s,0);
        return res;
    }
    public void backtrack(List<List<String>> res,List<String> temp, String s,int i){
        if(i==s.length()){
            res.add(new ArrayList<>(temp));
        }
        for(int j=i;j<s.length();j++){
            if(isPalindrome(s,i,j)){
                temp.add(s.substring(i,j+1));
                backtrack(res,temp,s,j+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int low, int high){
        while(low<high){
            if(s.charAt(low++)!=s.charAt(high--)){
                return false;
            }
          
        }
        return true;
    }
}