// Time Complexity : O(exp^N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Nope.


// Your code here along with comments explaining your approach
class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(null == s || s.length() == 0){return result;}
        backtrack(s,0,new ArrayList<>(),result);
        return result;
    }
    private void backtrack(String s, int start,List<String> list, List<List<String>> result){
        if(start == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < s.length(); i++){
            String str = s.substring(start,i+1);
            if(isPalindrome(s,start,i)){
                list.add(str);
                backtrack(s,i+1,list,result);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isPalindrome(String str,int start,int end){
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){return false;}
            start++;
            end--;
        }
        return true;
    }
}