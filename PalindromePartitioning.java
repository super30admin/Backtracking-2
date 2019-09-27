/*
The time complexity is O(2^N) where we need to make choice of whether we need to cut or not cut. For string of length n we need to take
N-1 choices like that.

The space complexity is O(len) where len = length of the given string.

The intuition here is to make a choice of cut and look whether the string of the left of cut is palindrome. If yes, move foreward with
the right part of cut.

Yes, the solution passed all the test cases in leet code.
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> retList = new ArrayList<>();
        palindromePartition(s,retList,new ArrayList<>());
        return retList;

    }

    public void palindromePartition(String str,List<List<String>> result,List<String> check){
        if(str.length()==0){
            result.add(new ArrayList<>(check));
            return;
        }

        for(int i=0;i<str.length();i++){
            String left = str.substring(0,i+1);
            if(checkPalindrome(left)){
                check.add(left);
                palindromePartition(str.substring(i+1),result,check);
                check.remove(check.size()-1);
            }

        }
    }

    public boolean checkPalindrome(String str){

        int i = 0; int j = str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++; j--;
        }

        return true;
    }
}