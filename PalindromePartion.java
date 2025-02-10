//Time Complexity : exponential
//Space Complexity : O(n)
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        if(s.length() == 0 || s == null){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        backtracking(s, new ArrayList<>());
        return result;
    }

    private void backtracking(String s, List<String> path){
        //base case
        if(s.length() == 0){
            result.add(new ArrayList<>(path));
        }

        //logic
        for(int i = 0; i<s.length(); i++){
            if(isPalindrome(s,0,i)){
                //action
                path.add(s.substring(0,i+1));
                //recurse
                backtracking(s.substring(i+1),path);
                //backtrack
                path.remove(path.size()-1);
            }
        }

    }

    boolean isPalindrome(String s, int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}