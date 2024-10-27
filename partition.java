class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        helper(s,new ArrayList<>());
        return res;
    }
    private void helper(String s, List<String> path){
        if(s.length()==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int index=0;index<s.length();index++){
            String sb=s.substring(0,index+1);
            if(isPalindrome(sb)){
                path.add(sb);
                helper(s.substring(index+1),path);
                path.remove(path.size()-1);
            }

        }
    }
    private boolean isPalindrome(String s){
        int start=0,end=s.length()-1;

        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;end--;
        }
        return true;
    }
}
