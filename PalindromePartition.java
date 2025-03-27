import java.util.ArrayList;
import java.util.List;


//Time Complexity : O(n* 2^n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


/*
//find all substrings and check if they are palindrome
class Solution {
  List<List<String>> res;
  public List<List<String>> partition(String s) {
      res=new ArrayList<>();
      helper(s,0,new ArrayList<>());
      return res;
  }

  private void helper(String s, int pivot, List<String> path){
      if(pivot==s.length()){
          res.add(new ArrayList<>(path));
          return;
      }
      for(int i=pivot;i<s.length();i++){
          String currpart=s.substring(pivot, i+1);
          if(isPalindrome(currpart,0,currpart.length()-1)){
              path.add(currpart);
              helper(s,i+1,path);
              path.remove(path.size()-1);
          }
      }

  }

  private boolean isPalindrome(String s, int l, int r){
      while(l<r){
          if(s.charAt(l)!=s.charAt(r)){
              return false;
          }
          l++;
          r--;
      }
      return true;
  }
}
*/
//0-1 recursion
class PalindromePartition {
  List<List<String>> res;
  public List<List<String>> partition(String s) {
      res=new ArrayList<>();
      helper(s,0,0,new ArrayList<>(),0);
      return res;
  }

  private void helper(String s, int pivot, int idx, List<String> path,int count){
      //base
      if(idx==s.length()){
          if(count==s.length()){
              res.add(new ArrayList<>(path));
          }
          return;
      }
      //choose
      String currpart=s.substring(pivot,idx+1);
      if(isPalindrome(currpart,0,currpart.length()-1)){
          path.add(currpart);
          helper(s,idx+1,idx+1,path,count+currpart.length());
          path.remove(path.size()-1);
      }
      //not choose
      helper(s,pivot,idx+1,path,count);
  }

  private boolean isPalindrome(String s, int l, int r){
      while(l<r){
          if(s.charAt(l)!=s.charAt(r)){
              return false;
          }
          l++;
          r--;
      }
      return true;
  }
}
