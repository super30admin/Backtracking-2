class Solution {
    List<List<String>> output;
    public List<List<String>> partition(String s) { 
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }

        output = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return output;
    }

    private void backtrack(String s, int index, List<String> path){
        if(index == s.length()){
            output.add(new ArrayList<>(path));
        }

        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i+1));
                backtrack(s, i + 1, path);
                path.remove(path.size() - 1);
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
