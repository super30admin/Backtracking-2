import java.util.*;
public class Backtracking {
    // time complexity : 2^N
    // space complexity : N
    // did it run on leetcode : yes
    // any doubts : no
    //https://leetcode.com/problems/subsets/
    //using choose not choose technique
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        
        if(nums == null || nums.length== 0) return result;
        helper(nums,0,new ArrayList<Integer> ());
        return result;
    }
    private void helper(int[] nums,int index,ArrayList<Integer> path){
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //pick
        path.add(nums[index]);
        System.out.println(path);
        helper(nums,index+1,path);
        //backtrack
        path.remove(path.size()-1);
        //not pick
        helper(nums,index+1,path);
    }

    //using for loop based reqcursion technique
    // time complexity : 2^N
    // space complexity : N
    // did it run on leetcode : yes
    // any doubts : no
    List<List<Integer>> result1;
    public List<List<Integer>> subsets1(int[] nums) {
        result = new ArrayList<>();
        
        if(nums == null || nums.length== 0) return result;
        helper1(nums,0,new ArrayList<Integer> ());
        return result;
    }
    private void helper1(int[] nums,int index,ArrayList<Integer> path){
      
        result.add(new ArrayList<>(path));
        for(int i = index;i< nums.length ; i++){
            path.add(nums[i]);
            helper(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }

    //using iterative approach
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0;i<nums.length;i++){
          int size = result.size(); 
            for(int j = 0;j<size;j++){
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
          return result;             
      }

    // time complexity : N^N
    // space complexity : N
    // did it run on leetcode : yes
    // any doubts : no
    //https://leetcode.com/problems/palindrome-partitioning/
      List<List<String>> result3;
      public List<List<String>> partition(String s) {
          result = new ArrayList<>();
          helper(s,0,new ArrayList<String>());
          return result3;
      }
      private void helper(String s,int index, ArrayList<String> path){
          if(index == s.length()){
              result3.add(new ArrayList<>(path));
              return;
          }
          
          for(int i =index;i<s.length();i++){
              
              if(ispalindrome(s,index,i)){
                  path.add(s.substring(index,i+1));
                  helper(s,i+1,path);
                  path.remove(path.size()-1);
              }
             
          }
          
      }
      
      private boolean ispalindrome(String s,int start,int end){
          
          while(start<end){
              if(s.charAt(start)==s.charAt(end)){
                  start++;
                  end--;
              }else{
                  return false;
              }
          }
          return true;
      }
}
