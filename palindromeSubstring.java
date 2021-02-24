// time complexity - O(2^n)
// space complexity - O(n)
// works on leetcode

class Solution {
    private List<List<String>> output = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return output;
        }
        backtracking(0,s,new ArrayList<>());
        return output;
    }
    
    private void backtracking(int index, String s, List<String> path){
        if(index >= s.length()){
            output.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=index;i<s.length();i++){
            String curr = s.substring(index, i+1);
            if(isPalindrome(curr)){
                path.add(curr);
                backtracking(i+1,s, path);
                path.remove(path.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() -1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left = left + 1;
            right = right - 1;
        }
        return true;
    }
}
