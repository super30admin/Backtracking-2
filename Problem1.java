//Time Complexity: O(n * 2^n)
//Space Complexity:O(n) n is the size of the string 
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        palindromePartitioning(s,0,new ArrayList<String>(),list);
        return list;
    }
    
    private void palindromePartitioning(String s, int start, List<String> slist, List<List<String>> list) {
        
        if(start == s.length())  {
            list.add(new ArrayList<>(slist));
            return;
        }
        for(int i = start; i < s.length(); i++) {
            if(palindrome(s,start,i)) {
                slist.add(s.substring(start,i+1));
                palindromePartitioning(s,i+1,slist,list);
                slist.remove(slist.size() - 1);
            }
        }
    }
    
    private boolean palindrome(String s,int i, int j) {
        if(i == j)
            return true;
        while(i <= j ) {
            if(s.charAt(i++) == s.charAt(j--))
                continue;
            else
                return false;
        }
        return true;
    }
}
