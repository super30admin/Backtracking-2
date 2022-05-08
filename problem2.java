import java.util.ArrayList;
import java.util.List;

class palindromePartitioning{
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;

        helper(s, 0, new ArrayList<String>());
        return result;
    }

    private void helper(String s, int index, List<String> path){
        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i +1));
                helper(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r){
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)) return false;

            l++;
            r--;
        }
        return true;
    }
}

//time complexity O(2^n)
//space complexity O(n) where n is length of string