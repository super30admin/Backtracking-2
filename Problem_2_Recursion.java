// Time complexity - O(n^2 * 2^n)
// Space complexity- O(n*2^n)

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, new ArrayList<>(), 0);
        return result;
    }
    
    private void helper(String s, List<String> temp, int start){
        // base 
        if(start == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        // logic
        for(int i = start; i< s.length(); i++){
            if(isPalli(s,start,i)){
                // action
                List<String> list = new ArrayList<>(temp);
                list.add(s.substring(start,i+1));
                // recurse
                helper(s,list,i+1);
                
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
