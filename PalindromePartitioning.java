// TC : O(2^n * n)
// SC : O(n*n+n)

package S30_Codes.Backtracking_2;

import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
    boolean[][] dp;
    List<List<String>> result;
    List<String> curList;

    public List<List<String>> partition(String s) {
        dp = new boolean[s.length()][s.length()];
        fillDp(s);

        result = new ArrayList<>();
        curList = new ArrayList<>();
        partition(s, 0);
        return result;
    }

    private void partition(String s, int idx){
        if(idx == s.length()){
            result.add(new ArrayList<>(curList));
        }

        StringBuilder sb = new StringBuilder();
        for(int i=idx; i<s.length(); i++){
            sb.append(s.charAt(i));
            if(isPalindrome(idx, i)){
                curList.add(sb.toString());
                partition(s, i+1);
                curList.remove(curList.size()-1);
            }
        }
    }

    private boolean isPalindrome(int start, int end){
        return dp[start][end];
    }

    private void fillDp(String str){
        for(int curLen=1; curLen<=dp.length; curLen++){
            for(int start=0; start+curLen-1<dp.length; start++){
                int end = start+curLen-1;

                if(str.charAt(start) == str.charAt(end)){
                    if(start+1<end-1){
                        dp[start][end] = dp[start+1][end-1];
                    }
                    else
                        dp[start][end] = true;
                }
            }
        }
    }
}