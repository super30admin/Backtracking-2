// Time Complexity : O(2^n)
// Space Complexity : O(n) 
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(s,0,new ArrayList<>());
        return result;
        
    }
    private void recurse(String s, int index, List<String> path){
        //base
        if(index == s.length()){
            result.add(new ArrayList<>(path));
        }

        //logic
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s,index,i)){
                //action
                path.add(s.substring(index,i+1));
                //recurse
                recurse(s,i + 1, path);
                //backtrack
                path.remove(path.size() - 1);

            }

        }
    }
    private boolean isPalindrome(String s, int l, int r)
    {
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
