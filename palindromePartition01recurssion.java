// Time Complexity : O(2^n*n)
// Space Complexity : O(2^n * 2n)
// Did this code successfully run on Leetcode : Yes
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, 0,new ArrayList<>(),0);
        return result;
    }

    private void helper(String s, int pivot, int i, List<String> path, int count){
        //base
        if(i == s.length()){
            if(count == s.length()){
            result.add(new ArrayList<>(path));
            }
            return;
        }

        helper(s, pivot, i+1, path, count);

        String substr = s.substring(pivot, i+1);
        if(isPalindrome(substr)){
            path.add(substr);
            helper(s,i+1,i+1,path,count+substr.length());
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() -1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
