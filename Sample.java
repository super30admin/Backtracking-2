//Problem-1: Subsets
TC = O(n*2^n) exponential. Where n is the number of elements in nums array
SC= O(n)
/**
Bactrack solution(without for loop): Making choice at each step(choosing or not choosing the current element). Each leaf node in the recursion tree will be the resultant set. Undoing the last action after returning back from the leaf node
*/
class Solution {
    List<List<Integer>> result; // global resultant arraylist to store all the subsets
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        // recursion: passing nums array, starting index and an empty arraylist to store resultant subsets
        helper(nums,new ArrayList<>(),0);
        
        return result;
    }
    
    
    private void helper(int[] nums, List<Integer> curSet, int index){
        
        //base
        if(index == nums.length){
            result.add(new ArrayList<>(curSet)); // Adding the new instance of the curSet every time we have a set since we are adding the reference to the curSet at each recursive step
            return;
        }
        
        //Logic and recurse 
        // not choosing
        helper(nums, curSet, index+1);
        //choosing and adding the cur element in the curSet
        curSet.add(nums[index]);
        helper(nums, curSet, index+1);
        curSet.remove(curSet.size()-1);
    }
}
//Problem-1: Subsets
TC = O(n*2^n) exponential. Where n is the number of elements in nums array
SC= O(2^n)

/**
Recursive solution: Making choice at each step(choosing or not choosing the current element). Each leaf node in the recursion tree will be the resultant set. 
*/
class Solution {
    List<List<Integer>> result; // global resultant arraylist to store all the subsets
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        // recursion: passing nums array, starting index and an empty arraylist to store resultant subsets
        helper(nums,new ArrayList<>(),0);
        
        return result;
    }
    
    
    private void helper(int[] nums, List<Integer> curSet, int index){
        
        //base
        if(index == nums.length){
            result.add(curSet); // dont need to create new instance of curSet since we are maintaining copy of it at each recursive step
            return;
        }
        
        //Logic and recurse 
        // not choosing
        helper(nums, new ArrayList<>(curSet), index+1);
        //choosing and adding the cur element in the curSet
        curSet.add(nums[index]);
        helper(nums, new ArrayList<>(curSet), index+1);
        
    }
}

//Problem-1: Subsets
TC = O(n*2^n) exponential. Where n is the number of elements in nums array
SC= O(n)
/**
Bactrack solution: Iterating over the nums array with the index and recurse using for loop. 
*/
class Solution {
    List<List<Integer>> result; // global resultant arraylist to store all the subsets
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        // recursion: passing nums array, starting index and an empty arraylist to store resultant subsets
        helper(nums,new ArrayList<>(),0);
        
        return result;
    }
    
    
    private void helper(int[] nums, List<Integer> curSet, int index){
        
      
        
        //Logic and recurse
        result.add(new ArrayList<>(curSet));
        for(int i=index; i<nums.length; i++){
            
            curSet.add(nums[i]);
            helper(nums, curSet, i+1);
            //backtrack
            curSet.remove(curSet.size()-1);
        }
        

     
    }
}
//Problem-2: Palinddrome partitioning
TC = O(n^2*2^n) where n is the len of the string
SC= O(2^n)
/**
Recursive solution: Partitioning at each index and check if the substring is valid palindrome or not.
*/
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        
        recurse(s, new ArrayList<>(), 0);
        
        return result;
    }
    
    
    private void recurse(String s, List<String> temp, int start){
        //base
        if(start == s.length()){
            result.add(temp);
            return;
        };
        // recurse and logic
        for(int i= start; i<s.length(); i++){
            if(isPalindrome(s,start,i)){
                
                List<String> ls = new ArrayList<>(temp);
                ls.add(s.substring(start, i+1));
                recurse(s,ls, i+1);
            }
            
        }        
    }
    
    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        
        return true;
    }
}
//Problem-2: Palinddrome partitioning
TC = O(n^2*2^n) where n is the len of the string
SC= O(n)

/**
Backtracking solution: The string s is partitioned at each index. The partitioned portion is checked if it is valid palindrome or not. If it is, only then it is added in the temporary list and continue the same process until it reaches end of the string. After the leaf node is reached, the current temporary list is added as a copy in the resultant arraylist.
*/
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        
        // backtrack recursively with the current string, a temp arraylist to store current combination of palindrome, and the starting index
        backtrack(s, new ArrayList<>(), 0);
        
        return result;
    }
    
    
    private void backtrack(String s, List<String> temp, int start){
        //base
        if(start == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        };
        // recurse and logic
        for(int i= start; i<s.length(); i++){
            if(isPalindrome(s,start,i)){
                
                temp.add(s.substring(start, i+1));
                backtrack(s, temp, i+1);
                
                //backtrack
                temp.remove(temp.size()-1);
            }
            
        }        
    }
    
    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        
        return true;
    }
}
