// Time cpmplexity - O(n) + creatignsubstrings
//Space - O(1)
//ran on leetcode - yes

class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        //null case
        //if(s == null || s.length() == 0) return s;
        backtrack(s, new ArrayList<>());
        return res;
    }
    public void backtrack(String s, List<String> path){
        //base case when entire string is exhausted
        if(s.length() == 0){
            
            res.add(new ArrayList<>(path));
            
            return;
        }
        
        //logic
        for(int i=0; i<s.length(); i++){
            //if current substring is palindrome
            if(isPalindrome(s, 0, i)){
                path.add(s.substring(0, i+1));
                backtrack(s.substring(i+1), path);
                path.remove(path.size() - 1);
            }
    }
}
    
    public boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}