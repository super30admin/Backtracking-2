//Time Complexity : O(n*2^n)
//Space Complexity : O(n*2^n)

class Solution {
    List<List<String>> result;
    
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, List<String> path){

        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = pivot; i<s.length(); i++){
            String currPart = s.substring(pivot, i+1);
            if(isPalindrome(currPart,0,currPart.length()-1)){
                path.add(currPart);
                helper(s, i+1, path);

                path.remove(path.size() -1);

            }
        }
    }
    private boolean isPalindrome(String s, int l, int r){
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
