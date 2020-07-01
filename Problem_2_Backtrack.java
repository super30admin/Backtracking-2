// Time complexity - O(n* 2^n)
//  Space complexity - O(n)

// backtracking

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        backtrack(s, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtrack(String s, List<String> temp, int start){
        // base 
        if(start == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        // logic
        for(int i = start; i< s.length(); i++){
            if(isPalli(s,start,i)){
                // action
                temp.add(s.substring(start,i+1));
                // recurse
                backtrack(s,temp,i+1);
                // backtrack
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalli(String s, int l, int r){
        if(l == r) return true;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;r--;
        }
        return true;
    }
}
