Time Complexity-(2^n)
Space Complexity-O(n)-for temporary array
Leetcode Subl=mission successful
class Solution {        
    List<List<String>> result;
    List<String> temp = new ArrayList<>();
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        temp = new ArrayList<>();
        backtrack(s, 0);
        return result;
    }
    private void backtrack(String s,int start){
        if(temp.size() > 0 && start >= s.length()){
            result.add(new ArrayList<>(temp));
        }
        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s, start, i)){
                
                    temp.add(s.substring(start, i+1));
                
                backtrack(s, i+1); 
                // backtrack
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r){
        if(l==r) return true;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}
