//Time Complexity : O(n * 2^n)
//Space Complexity: O(n^2)
public class PalindromePartitioning {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(0, 0, s, new ArrayList<>(), 0);
        return result;

    }

    private void helper(int pivot, int index, String s, List<String> curr, int cnt) {

        if (index == s.length()) {
            if(cnt == s.length()) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }

        helper(pivot, index + 1, s, curr, cnt);

        String sub = s.substring(pivot, index + 1);
        if (isPalindrome(sub)) {

            curr.add(sub);
            cnt = cnt + sub.length();
            helper(index + 1, index + 1, s, curr, cnt);

            curr.remove(curr.size() - 1);



        } else {
            return;
        }

    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
