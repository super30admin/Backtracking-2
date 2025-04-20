
class PalindromePartition {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        int pivot = 0;
        helper(s, pivot, path);
        return res;
    }
    private void helper(String s, int pivot, List<String> path){
        if(pivot == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=pivot; i<s.length(); i++){
            String subStr = s.substring(pivot, i+1);
            if(isSubStrPalindrome(subStr)){
                path.add(subStr);
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isSubStrPalindrome(String s){
        int low = 0;
        int high = s.length() -1;
        while(low < high){
            if(s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}

