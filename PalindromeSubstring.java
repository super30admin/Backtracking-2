//Palindrome Substring Program

import java.util.*;

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s.length() == 0 || s == null){
            return result;
        }
        BackTracking(s, new ArrayList<>(), 0);
        return result;
    }
    
    private void BackTracking(String s, List<String> temp,int index){
        if(index == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }   
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                temp.add(s.substring(index, i+1));
                BackTracking(s, temp, i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    

    public Boolean isPalindrome(String s, int l, int r){
        if(l == r){
            return true;
        }
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
     }
    
}

