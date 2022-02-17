// Time Complexity : O(2^n)
// Space Complexity :O(2^n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// DFS- for loop recursion, check for the string for index to i, if found palindrom then add to the list; if the index == s.lenght, add it to the result
// Your code here along with comments explaining your approach
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        dfs(s, 0, new ArrayList<>());
        return result;
    }
    private void dfs(String s, int index, List<String> ls){
        // base
        if(index == s.length()){
            result.add(new ArrayList<>(ls));
            return;
        }
        // logic
        for(int i = index; i < s.length(); i++){
            if(!isPalim(s, index, i)) continue;
            // action
            ls.add(s.substring(index, i+1));
            // recurse
            dfs(s, i+1, ls);
            // backtrack
            ls.remove(ls.size()-1);
        }
    }
    private boolean isPalim(String s, int l, int r){
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
