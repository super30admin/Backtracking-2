//Time complexity: O(2^n)
//Space Complexity: O(n)
class Solution {
    List<List<String>> res= new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s,0, new ArrayList<>());
        return res;
        
    }
    private void helper(String s, int index, ArrayList<String> path){
        
        if(index==s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=index;i<s.length();i++){
            String curr=s.substring(index,i+1);
            if(ispalindrome(curr)){
                path.add(curr);
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean ispalindrome(String s){
        int l=0,r=s.length()-1;
        if(l==r) return true;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}