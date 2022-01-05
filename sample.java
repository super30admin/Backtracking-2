//palindrome partitioning
// Time Complexity : O(2^n)
// Space Complexity : O(n)
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<String>());
        return result;
    }
    private void helper(String s, int index, List<String> path){
        
        if(index==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = index; i<s.length(); i++){
            String curr = s.substring(index, i+1);
            if(isPalindrome(curr)){
                path.add(curr);  //action
                helper(s, i+1, path);   //recurse
                path.remove(path.size()-1); //backtrack
            }
        }
        
    }
    private boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
//subsets
// Time Complexity : O(n*2^n)
// Space Complexity : O(n)

class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> path){
        
        result.add(new ArrayList<>(path));
        
        if(index==nums.length){
            return;
        }
        
        for(int i = index; i<nums.length; i++){
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }
        
    }
}
