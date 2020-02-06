//Time Complexity: O(n * 2^n)
import java.util.ArrayList;
import java.util.List;

class PalindromePartition {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return result;
        backtrack(s, 0, new ArrayList<String>());
        return result;
    }
    
    private void backtrack(String word, int index, ArrayList<String> temp){
        //Base Case
        if(index == word.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        //Logic
        for(int i = index; i < word.length(); i++){
            if(isPalindrome(word, index, i)){
                temp.add(word.substring(index, i + 1));
                backtrack(word, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String word, int l, int r){
        while(l < r){
            if(word.charAt(l) != word.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}