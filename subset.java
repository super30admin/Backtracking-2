// Time Complexity : O(N * 2^N)
// Space Complexity : O(N * 2^N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Recursive solution
//choose first Solution
import java.util.*;
class Main{
  public static void main(String []args){
    int []nums={1,2,3};
    System.out.println(findSubset(nums));
  }
  static List<List<Integer>> result;
  public static List<List<Integer>> findSubset(int []nums){
    result=new ArrayList<>();
    if(nums==null || nums.length==0){
      return result;
    }
    helper(nums, new ArrayList<>(), 0);
    return result;
  }
  public static void helper(int []nums, List<Integer> temp, int start){
    //base
    if(start==nums.length){
      result.add(temp);
      return;
    }
    //logic
    //choose
    List<Integer> newList=new ArrayList<>(temp);
    newList.add(nums[start]);
    helper(nums, newList, start+1);
    //dont choose
    helper(nums, new ArrayList<>(temp), start+1);
  }
}

//Recursive solution 
//Don't choose first solution
import java.util.*;
class Main{
  public static void main(String []args){
    int []nums={1,2,3};
    System.out.println(findSubset(nums));
  }
  static List<List<Integer>> result;
  public static List<List<Integer>> findSubset(int []nums){
    result=new ArrayList<>();
    if(nums==null || nums.length==0){
      return result;
    }
    helper(nums, new ArrayList<>(), 0);
    return result;
  }
  public static void helper(int []nums, List<Integer> temp, int start){
    //base
    if(start==nums.length){
      result.add(temp);
      return;
    }
    //logic
    //dont choose
    helper(nums, new ArrayList<>(temp), start+1);
    //choose
    temp.add(nums[start]);
    helper(nums, new ArrayList<>(temp), start+1);
  }
}



//BackTracking Solution
// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Backtrack Solution
import java.util.*;
class Main{
  public static void main(String []args){
    int []nums={1,2,3};
    System.out.println(findSubset(nums));
  }
  static List<List<Integer>> result;
  public static List<List<Integer>> findSubset(int []nums){
    result=new ArrayList<>();
    if(nums==null || nums.length==0){
      return result;
    }
    backtrack(nums, new ArrayList<>(), 0);
    return result;
  }
  public static void backtrack(int []nums, List<Integer> temp, int start){
    //base
    
    //logic
    result.add(new ArrayList<>(temp));
    for(int i=start;i<nums.length;i++){
      //action
      temp.add(nums[i]);
      //recurse
      backtrack(nums, new ArrayList<>(temp), i+1);
      //backtrack
      temp.remove(temp.size()-1);
    }
  }
}