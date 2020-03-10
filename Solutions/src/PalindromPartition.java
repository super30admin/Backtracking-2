// Time Complexity :O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : No
class PalindromPartition {
    public List<List<String>> partition(String s) {
        if(s==null || s.length()==0) return new ArrayList<List<String>>();
        List<List<String>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(),0,s);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> tmp, int start, String s){
        if(start==s.length()){
            result.add(new ArrayList<String>(tmp));
        }
        else{
            for(int i = start;i<s.length();i++){
                if(isPalindrome(start,i,s)){
                    tmp.add(s.substring(start,i+1));
                    backtrack(result,tmp,i+1,s);
                    tmp.remove(tmp.size()-1);
                }
            }

        }
    }

    private boolean isPalindrome(int start, int end, String s ){
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}
