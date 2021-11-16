class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        boolean dp[][] = new boolean[s.length()][s.length()];
        helper(result, new ArrayList<String>(), s, 0, dp);
        return result;
    }

    public void helper(List<List<String>> result, List<String> current, String s, int index, boolean dp[][]){
        if(index == s.length())
            result.add(new ArrayList<>(current));
        for(int i = index; i<s.length(); i++){
            if(checkPalindrome(s, index, i, dp)){
                current.add(s.substring(index, i+1));
                helper(result, current, s, i+1,dp);
                current.remove(current.size()-1);
            }
        }
    }

    public boolean checkPalindrome(String sb, int start, int end, boolean dp[][]){
        if(start==end)
            dp[start][end] = true;
        else if(sb.charAt(start) == sb.charAt(end) && (dp[start+1][end-1] || end-start<=2))
            dp[start][end] = true;
        return dp[start][end];
    }
}
