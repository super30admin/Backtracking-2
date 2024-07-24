// Time Complexity : Ol*(2^l)
// Space Complexity : O(2^l)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(0, new ArrayList<>(), res, s);
        return res;
    }
    public void helper(int ind, List<String> state, List<List<String>> res, String s){
        if(ind == s.length()){
            res.add(new ArrayList<>(state));
            return;
        }
        for(int i = ind;i<s.length();i++){
            String c = s.substring(ind, i+1);
            if(isPalidrome(c)) {
                state.add(c);
                helper(i+1, state, res, s);
                state.remove(state.size()-1);
            }

        }


    }
    public boolean isPalidrome(String str){
        int l = 0;
        int h = str.length()-1;
        while(l<h){
            if(str.charAt(l) != str.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }
}
