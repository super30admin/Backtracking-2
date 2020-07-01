// Time Complexity : O(n* 2^n) as a new list created at each recursion point
// Space Complexity : O(n* 2^n) as a new list created at each recursion point
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
     List<List<Integer>> list; //global list
    public List<List<Integer>> subsets(int[] nums) {
       list = new ArrayList<>();
        
        if(nums==null || nums.length==0) //edge case
            return list;
        
        helper(nums, new ArrayList<>(), 0); //calling helper on nums array with a temp list and starting index 0
        return list;
    }
    
    private void helper(int[] nums, List<Integer> temp, int i)
    {
        //base
        if(i == nums.length) // if we reach the end of nums array
        {
              list.add(temp); //add temp to final list 
                return;
        }
          
        //logic
        //dont choose
        helper(nums, new ArrayList<>(temp), i+1); // a new list passed each time, i+1 as we can't choose again if we dont choose
        
        //choose
        temp.add(nums[i]); //adding the chosen value to temp
        helper(nums, new ArrayList<>(temp), i+1); // a new list passed each time, i+1 as we can't choose again if we dont choose
    }
}

// Time Complexity : O(n* 2^n) as a new list created at each recursion point
// Space Complexity : O(n* 2^n) as a new list created at each recursion point
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    List<List<Integer>> list;
   public List<List<Integer>> subsets(int[] nums) {
      list = new ArrayList<>();
       
       if(nums==null || nums.length==0)
           return list;
       
       helper(nums, new ArrayList<>(), 0);
       return list;
   }
   
   private void helper(int[] nums, List<Integer> temp, int i)
   {
       //base
       if(i == nums.length)
       {
             list.add(temp);
               return;
       }
         
       //logic
        //choose first
       List<Integer> newList = new ArrayList<>(temp); //create a newlist and store the temp upto now in it (to avoid passing the modified temp in the not choose part)
       newList.add(nums[i]); //add the chosen element to newlist
       helper(nums, new ArrayList<>(newList), i+1); //pass newlist as temp
       
       //dont choose
       helper(nums, new ArrayList<>(temp), i+1); //pass original temp here
       
      
   }
}

// Time Complexity : O(2^n) as two options of choosing a value or other
// Space Complexity : O(n) as a single list used throughout
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None



class Solution {
    List<List<Integer>> list;
   public List<List<Integer>> subsets(int[] nums) {
      list = new ArrayList<>();
       
       if(nums==null || nums.length==0)
           return list;
       
       backtrack(nums, new ArrayList<>(), 0);
       return list;
   }
   
   private void backtrack(int[] nums, List<Integer> temp, int index)
   {
       //base
      
          list.add(new ArrayList<>(temp)); //all lists have to be added
       
       //logic
       for(int i=index;i<nums.length;i++)
       {
           //action
           temp.add(nums[i]); //adding value to temp
           
           //backtrack
           backtrack(nums,temp, i+1); //moving to next value
           
           //recurse
           temp.remove(temp.size()-1); //when reach the base i.e end of list, we backtrack to remove elements from temp, corresponding state from recursion stack is used i.e index value
           
       }
       
      
   }
}


// Time Complexity : O(n* 2^n) as two options of choosing a value or other and checking palindrome at ech level
// Space Complexity : O(n) as a single list used throughout
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
    List<List<String>> result;
   public List<List<String>> partition(String s) {
       result = new ArrayList<>();
       
       if(s.length()==0 || s==null) //edge case
           return result;
       
       backtrack(s, new ArrayList<>(), 0);
       return result;
   }
   
  private void backtrack(String s, List<String> temp, int index)
   {
         if(index >= s.length()){ // if the index reaches end of string i.e no characters left to process

           result.add(new ArrayList<>(temp)); //add temp to result

       }

       // logic 

       for(int i = index; i < s.length(); i++)
       {

           if(isPalindrome(s, index, i)){  //checking if the substring is palindrome

               temp.add(s.substring(index, i+1)); // if it is add the substring to temp

               backtrack(s, temp, i+1); // recurse with increased index 'a'  'ab' ['a''b'] ['ab']

               // backtrack

               temp.remove(temp.size() - 1);

           }

       }

   }
   
   private boolean isPalindrome(String s, int l, int r)
   {
       if(l==r)
           return true;
       
       while(l<r)
       {
            if(s.charAt(l)!=s.charAt(r))
               return false;
           
           l++;
           r--;
       }
       
       return true;
          
   }
}

// Time Complexity : O(n* 2^n) as two options of choosing a value or other and checking palindrome at each level + creating a new list
// Space Complexity : O(n * 2^n) as a new list created at each recursion point
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None



class Solution {
    List<List<String>> result;
   public List<List<String>> partition(String s) {
       result = new ArrayList<>();
       
       if(s.length()==0 || s==null)
           return result;
       
       helper(s, new ArrayList<>(), 0);
       return result;
   }
   
  private void helper(String s, List<String> temp, int index)
   {
         if(index >= s.length()){

           result.add(temp);

       }

       // logic 

       for(int i = index; i < s.length(); i++)
       {

           if(isPalindrome(s, index, i)){
               List<String> newList = new ArrayList<>(temp); //new list created using temp
               newList.add(s.substring(index, i+1)); //add substring to new list

               helper(s, new ArrayList<>(newList), i+1); // 'a'  'ab' ['a''b'] ['ab']
                //make copy of list at each level
              

           }

       }

   }
   
   private boolean isPalindrome(String s, int l, int r)
   {
       if(l==r)
           return true;
       
       while(l<r)
       {
            if(s.charAt(l)!=s.charAt(r))
               return false;
           
           l++;
           r--;
       }
       
       return true;
          
   }
}