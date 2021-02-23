class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backTrack(s, ans, new ArrayList<String>(), 0);
        return ans;
    }
    
    private void backTrack(String s, List<List<String>> ans, List<String> list, int start){
        
        if(start == s.length()){
            System.out.println("Came");
            ans.add(new ArrayList<>(list));
        }else{
            for(int i=start; i<s.length(); i++){
                if(isPalindrome(s, start, i)){
                    list.add(s.substring(start,i+1));
                    backTrack(s, ans, list, i+1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    
    private boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
}