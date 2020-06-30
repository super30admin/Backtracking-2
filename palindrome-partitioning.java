// Time Complexity : O(N * 2N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Backtrack Solution
import java.util.*;
class Main{
  public static void main(String []args){
    String s="aabc";
    System.out.println(palindromePartitioning(s));
  }
  static List<List<String>> result;
  public static List<List<String>> palindromePartitioning(String s){
    result=new ArrayList<>();
    if(s==null || s.length()==0){
      return result;
    }
    helper(s, new ArrayList<>(), 0);
    return result;
  }
  public static void helper(String s, List<String> temp, int start){
    //base
    if(start==s.length()){
      result.add(new ArrayList<>(temp));
      return;
    }
    //logic
    for(int i=start; i<s.length();i++){
      if(isPalindrome(s, start, i)){
        //action
        temp.add(s.substring(start, i+1));
        //recurse
        helper(s, temp, i+1);
        //backtrack
        temp.remove(temp.size()-1);
      }
    }
  }
  public static boolean isPalindrome(String s, int l, int r){
    if(l==r){
      return true;
    }
    while(l<r){
      if(s.charAt(l)!=s.charAt(r)){
        return false;
      }
      l++; r--;
    }
    return true;
  }
}



// Time Complexity : O(N^2 * 2N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Resursive Solution
import java.util.*;
class Main{
  public static void main(String []args){
    String s="aabc";
    System.out.println(palindromePartitioning(s));
  }
  static List<List<String>> result;
  public static List<List<String>> palindromePartitioning(String s){
    result=new ArrayList<>();
    if(s==null || s.length()==0){
      return result;
    }
    helper(s, new ArrayList<>(), 0);
    return result;
  }
  public static void helper(String s, List<String> temp, int start){
    //base
    if(start==s.length()){
      result.add(new ArrayList<>(temp));
      return;
    }
    //logic
    for(int i=start; i<s.length();i++){
      if(isPalindrome(s, start, i)){
        List<String> newList=new ArrayList<>(temp);
        newList.add(s.substring(start, i+1));
        helper(s, newList, i+1);
      }
    }
  }
  public static boolean isPalindrome(String s, int l, int r){
    if(l==r){
      return true;
    }
    while(l<r){
      if(s.charAt(l)!=s.charAt(r)){
        return false;
      }
      l++; r--;
    }
    return true;
  }
}