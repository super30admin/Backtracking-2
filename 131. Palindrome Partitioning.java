class Solution {
    // Time complexity: O(N * 2 ^ N)
    // Space complexity: O(N)
    List<List<String>> results;
    public List<List<String>> partition(String s) {
        results = new ArrayList<>();
        
        helper(s, 0, new ArrayList<>());
        
        return results;
    }
    
    public void helper(String s, int start, List<String> res){
        //base case
        if(start == s.length()){
            results.add(new ArrayList<>(res));
            return;
        }
        
        
        for(int i = start + 1; i <= s.length(); i++){
            String subString = s.substring(start, i);
            if(isPalindrome(subString)){
                res.add(subString);
                helper(s, i, res);
                res.remove(res.size() - 1);
            }
        }
        
    }
    
    public boolean isPalindrome(String subString){
        char[] subArray = subString.toCharArray();
        int i = 0;
        int j = subArray.length - 1;
        while(i < j){
            if(subArray[i] != subArray[j]){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}