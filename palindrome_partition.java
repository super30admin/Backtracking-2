//Time - O(2^n) + O(n*l)
// Space - O(n)
class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(0,s,new ArrayList<String>());
        return res;
    }

    public void helper(int idx, String s, List<String> path){
        boolean flag = true;
        if(idx==s.length()){
            for(int j=0;j<path.size();j++){
                if(!checkPalindrome(path.get(j))){
                    flag = false;
                }
            }
            if(flag==true){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for(int i=idx;i<s.length();i++){
            path.add(s.substring(idx,i+1));
            helper(i+1,s,path);
            path.remove(path.size()-1);
        }
    }

    public boolean checkPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
