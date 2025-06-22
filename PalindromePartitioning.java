// TC:
// N*2^N
// N is check for palindromes
// 2^N is the number of combinations

// SC:
// N -- recursion depth -- Size of the string
// result string is O(1) -- Since we dont consider the output string
// path list holds at most N size string
// in worst case the result can hold 2^N-1 Partitions


class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s,0,new ArrayList<>(), result);
        return result;
    }

    private boolean isPalindrome(String s){
        int n = s.length();
        if(n==1) return true;
        int l =0;
        n--;
        while(l <= n){
            if(s.charAt(l) != s.charAt(n)) return false;
            l++;n--;
        }
        return true;
    }

    private void helper(String s,int pivot, List<String> path, List<List<String>> result){
        if(s.length() == pivot){
            result.add(new ArrayList(path));
            return;
        }
        for(int i = pivot; i< s.length();++i){
            if(isPalindrome(s.substring(pivot,i+1))){
                path.add(s.substring(pivot,i+1));
                helper(s,i+1,path,result);
                path.remove(path.size()-1);
            }
        }
    }
}
