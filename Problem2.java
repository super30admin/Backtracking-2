//time exponential o(2 pow n) * n, n is the string size
//space o(n) since there is a list of size n. 
class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if(s == null || s.length()==0)
            return res;
        backtrack(s, new ArrayList<>(), 0);
        return res;
    }
    
    private void backtrack(String s, List<String> list, int index) {
        //base case
        if(index == s.length())
        {
            res.add(new ArrayList<>(list));
            return;
        }
        //logic
        for(int i=index;i<s.length();i++) {
            if(isPalindrome(s, index, i)) {
                //action
                list.add(s.substring(index,i+1));
                //recurse
                backtrack(s,list,i+1);
                //backtrack
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}