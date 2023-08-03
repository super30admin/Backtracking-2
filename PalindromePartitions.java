import java.util.ArrayList;
import java.util.List;
//Time Complexity: O(N*2^N)
//Space Complexity: O(N)
public class PalindromePartitions {
    List<String> current;
    List<List<String>> list;
    public List<List<String>> partition(String s) {
        current = new ArrayList<>();
        list = new ArrayList<>();
        //find all partitions of a string and for each string check if its a palindrome
        backtrack(s, 0);
        return list;
    }

    private void backtrack(String s, int idx){
        //base
        if(idx == s.length()){
            list.add(new ArrayList<>(current));
        }

        //logic
        for(int i = idx; i< s.length(); i++){
            String curr = s.substring(idx, i+1);
            if(isPalindrome(curr))
            {
                current.add(curr);
                backtrack(s, i+1);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str){
        int begin = 0;
        int end = str.length()-1;
        while(begin < end){
            if(str.charAt(begin) != str.charAt(end)) return false;
            begin++;
            end--;
        }
        return true;
    }
}
