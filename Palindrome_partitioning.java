class Solution {        
    List<List<String>> result;
    List<String> temp = new ArrayList<>();
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        temp = new ArrayList<>();
        backtrack(s, 0);
        return result;
    }
    private void backtrack(String s,int start){
        // base case
        if(temp.size() > 0 && start >= s.length()){
            List<String> cloneList = new ArrayList<>(temp);
            result.add(cloneList);
        }
        // logic 
        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s, start, i)){
                if(start == i){
                    temp.add(Character.toString(s.charAt(i))); //['a']
                } else {
                    temp.add(s.substring(start, i+1));
                }
                backtrack(s, i+1); // 'a'  'ab' ['a''b'] ['ab']
                // backtrack
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r){
        if(l==r) return true;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}
