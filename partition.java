//TC: TC: O((n+n) * 2^n) → 2^n for loop based, n→ create substring, n → check whether palindrome or not
//SC: O(N) n is length of string and depth of stack. bcz we are backtracking, if brute force i.e we create list everytime , then exponential i.e 2^n

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
       
        helper(s, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(String s, int pivot, List<String> path){
        //base
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=pivot; i<s.length(); i++){
            String curr = s.substring(pivot, i+1);  
            //action
            if(isPalindrom(curr)){
                path.add(curr);
                //recurse
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrom(String s){
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
       return true;
    }
}
