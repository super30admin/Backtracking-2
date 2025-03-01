// Time Complexity: n*O(2^n) where n is the number of elements in the input array
// Space Complexity: O(n) where n is the number of elements in the input array
import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        if(s == null || s.length() == 0){
            return result;
        }

        List<String> path = new ArrayList<>();

        helper(s, path, result, 0);

        return result;
    }

    private void helper(String s, List<String> path, List<List<String>> result, int pivot){
        // base
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }


        // logic
        for(int i = pivot; i < s.length(); i++){
            String sub = s.substring(pivot, i+1);

            if(isPalindrome(sub)){
                path.add(sub);
                helper(s, path, result, i+1);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
