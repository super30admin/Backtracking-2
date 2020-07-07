/**
 * Time: Exponential - O(n^n) where n - length of input string
 * Space: O(n)
 */
class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        helper(s,0,new ArrayList<String>());
        return res;
    }
    private boolean chkPalindrome(String s){
        if(s == null)return true;
        int j=s.length()-1, i=0;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    private void helper(String s, int index, List<String> lst){
        //base
        if(index == s.length()){
            res.add(new ArrayList<String>(lst));
            return;
        }

        for(int i=index; i<s.length(); i++){
            String ss = s.substring(index, i+1);
            if(!chkPalindrome(ss)){
                continue;
            }
            lst.add(ss);
            helper(s,i+1,lst);
            lst.remove(lst.size()-1);
        }
    }
}