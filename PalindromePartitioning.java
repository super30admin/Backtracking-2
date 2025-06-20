//solved successfully on leetcode and faced no issues
//TC:O(2^n) SC:O(2^n)

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>output = new ArrayList<>();
        List<String>path = new ArrayList<>();
        helper(s , 0 , output , path);
        return output;
        
    }
    private void helper(String s , int pivot , List<List<String>>output , List<String>path ){
        //base
        if(pivot == s.length()){
            output.add(new ArrayList<>(path)); // deep copy
            return;
        }

        //logic
        for(int i = pivot ; i < s.length() ; i++){
            String split = s.substring(pivot , i+1);
            if(isPalindrome(split , 0 , split.length()-1)){
                path.add(split);
                helper(s , i+1 , output , path);
            path.remove(path.size()-1);
            }
            

        }
    }
    private boolean isPalindrome(String s , int left , int right){
        while(left < right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}