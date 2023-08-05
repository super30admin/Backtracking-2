//Problem 1: Number of Subsets
// Time Complexity : O(2^n)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Approach-> take a number, add current to path, recurse to next, do this until all number subsets are formed.
class Solution {
    //TC: 2^n SC: O(n)
    List<List<Integer>> res;
    // public List<List<Integer>> subsets(int[] nums) {
    //     res= new ArrayList<>();
    //     if(nums==null) return res;
    //     helper(nums, 0 , new ArrayList<>()); //call recursive function
    //     return res;
    // }

    // private void helper(int[] nums, int idx, List<Integer> path){
    //     //base
    //     if(idx>nums.length){//if all numbers are covered -> return
    //         return;
    //     }

    //     res.add(new ArrayList<>(path)); // add all possible paths to result because we want all subsets
    //     //logic

    //     // //choose
    //     // path.add(nums[idx]); // add to path
    //     // helper(nums, idx+1,path); //recurse for next number
    //     // path.remove(path.size()-1); // backtrack

    //     // //not choose
    //     // helper(nums, idx+1, path); // if not choose, choose next number

    //     for(int i=idx; i<nums.length; i++){ //for loop based recursion
    //         List<Integer> li=new ArrayList<>(path);
    //         li.add(nums[i]);
    //         helper(nums, i+1, li);
    //         //path.remove(path.size()-1);
    //     }
    // }

    //brute force subsets
    public List<List<Integer>> subsets(int[] nums) {
        this.res=new ArrayList<>();
        if(nums==null) return res;
        res.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            int size=res.size();
            for(int j=0;j<size;j++){
                List<Integer> li=new ArrayList<>(res.get(j));
                li.add(nums[i]);
                res.add(li);
            }
        }
        return res;
    }
}
//Problem 2: Palindrome Partitioning
// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Approach -> 
class Solution {
    //TC: n * 2^n SC : O(n)
    List<List<String>> res;
    // public List<List<String>> partition(String s) {
    //     this.res=new ArrayList<>();
    //     if(s=="") return res;
    //     helper(s, 0, new ArrayList<>());
    //     return res;
    // }
    // private void helper(String s, int pivot, List<String> path){
    //     //base
    //     if(pivot==s.length()){
    //         res.add(new ArrayList<>(path)); //add at end when we travese to end of a tree with any given pivot, 
    //         return;
    //     }
    //     //logic
    //     for(int i=pivot;i<s.length();i++){ //for loop based recursion
    //         String sub= s.substring(pivot, i+1);
    //         if(isPalindrome(sub)){ // if substring is a palindrome, add-> recurse->backtrack
    //             //action
    //             path.add(sub);
    //             //recurse
    //             helper(s, i+1, path);

    //             //backtrack
    //             path.remove(path.size()-1);
    //         }
    //     }
    // }

    //01 recursion
     public List<List<String>> partition(String s) {
        this.res=new ArrayList<>();
        if(s=="") return res;
        helper(s, 0, 0, new ArrayList<>(), 0);
        return res;
     }

    private void helper(String s, int pivot, int i, List<String> path, int sum){
        //base
        if(i==s.length()){
            if(sum==s.length())
                res.add(new ArrayList<>(path));
            return;
        }
        //logic
        //not choose
        helper(s, pivot, i+1 , path, sum); //recursive call

        //choose
        String sub=s.substring(pivot, i+1);
        if(isPalindrome(sub)){
            //action
            path.add(sub);
            //recurse
            helper(s, i+1, i+1, path, sum+sub.length());
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s){
        int l=0, h=s.length()-1;
        while(l<h){
            if(s.charAt(l)!=s.charAt(h)) return false;
            else{
                l++; h--;
            }
        }
        return true;
    }
}