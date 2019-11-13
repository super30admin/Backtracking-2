package demo;

import java.util.ArrayList;
import java.util.List;

class Solution1 { 
    List<List<String>> result ;
    List<String> temp = new ArrayList<>();;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        backtrack(s,0);        
        return result;
    }
    
    private void backtrack(String s , int start){   
        //base case
        if(temp.size() > 0 && start >= s.length()){
            List<String> cloneList = new ArrayList<>(temp);
            result.add(cloneList);
        }        
        //logic
        for(int i=start ; i < s.length(); i++){
            if(IsPalindrome(s, start,i)){
                if(start ==i){
                temp.add(Character.toString(s.charAt(i)));
                }else{
                temp.add(s.substring(start, i+1));
            }
            backtrack(s,i+1);
                //backtracking happens
            temp.remove(temp.size()-1);
        }
        }
    }
    
    private boolean IsPalindrome(String s,int l ,int r ){
        if(l == r) return true;
        while(l < r){
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}