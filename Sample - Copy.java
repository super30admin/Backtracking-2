// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class PalindromePartitioning {
    List<List<String>> res;
    
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if(s.length()==0)
            return res;
        
        getPartitions(s,0,new ArrayList<>());
        
        return res;
    }
    
    private void getPartitions(String s, int index, List<String> temp) {
        if(index==s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=index;i<s.length();i++) {
            sb.append(s.charAt(i));
            if(isPalindrome(sb.toString(),0,sb.length()-1)) {
                temp.add(sb.toString());
                getPartitions(s,i+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while(start<=end) {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            else{
                start++; end--;
            }
        }
        
        return true;
    }
}
