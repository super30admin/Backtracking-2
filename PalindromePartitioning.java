import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> answer = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s, 0, new ArrayList<>());
        return answer;
    }

    // for - loop based recursion
    void helper(String s, int pivot, List<String> curList) {
        // base
        if(pivot >= s.length()) {
            answer.add(new ArrayList<>(curList));
            return;
        }
        // logic
        for(int i=pivot; i<s.length(); i++) {
            String sub = s.substring(pivot, i+1);
            if(isPalindrome(sub)) {
                curList.add(sub);
                helper(s, i+1, curList);
                curList.remove(curList.size()-1);
            }
        }
    }

    boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) 
                return false;
            start++;
            end--;
        }
        return true;
    }
}

// time - O(n*2^n)
// space - O(n) // n is the length of the string