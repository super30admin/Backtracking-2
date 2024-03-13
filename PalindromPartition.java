class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>();
        helper(s,0, new ArrayList<>());
        return res; 
    }
    private void helper(String s, int pivot, List<String> path){
        if(pivot == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=pivot;i<s.length();i++){
            String currSub = s.substring(pivot, i+1);
            if(isPalindrome(currSub)){
                path.add(currSub);
                helper(s,i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int left=0, right =s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;

    }
}
