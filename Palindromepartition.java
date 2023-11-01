// Time Complexity : O(n2^n)
// Space Complexity : O(n2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


public class Palindromepartition {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, List<String> path){
        //base
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
        }

        //logic
        for(int i = pivot; i < s.length(); i++){
            String sub = s.substring(pivot, i+1);
            if(isPalindrome(sub)){
                path.add(sub);

                helper(s, i+1, path);

                path.remove(path.size()-1);
            }

        }
    }

    private boolean isPalindrome(String s){
        int l = 0, r = s.length()-1;

        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            else{
                l++;
                r--;
            }
        }
        return true;
    }
}
