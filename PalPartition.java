import java.util.ArrayList;
import java.util.List;

public class PalPartition {

    // TC: O(2 ^ n)
    // SC: O(n) n decides the number of stack frames on the recursion stack.
        //  If n is high we'll go deep enough in a tree and the stack size will grow up.
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;

        helper(s, 0, new ArrayList<>());

        return result;
    }

    private void helper(String s, int index, ArrayList<String> path) {
        //base condition
        if(index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        for(int i=index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)){

                //action
                path.add(s.substring(index, i + 1));

                //recurse
                helper(s, i + 1, path);

                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int l, int r) {
        while(l <= r) {
            if(str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }


}
