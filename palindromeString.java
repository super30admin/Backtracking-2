/* Time complexity: O(2^n)
space complexity: O(n)
*/

class Solution{
    List<List<String>> result;
    public List<List<String>> partition(String s){
        result = new ArrayList<>();
        if(s == null || s.length == 0) return result;
        backtrack(s, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(String s, List<String> temp, int start){
        if(start >= s.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<s.length; i++){
            if(isPalindrome(s,start,i)){
                temp.add(s.Substring(start, i+1));
                backtrack(s.Substring(i), temp, i);
                temp.remove(temp.size() - 1);                
            }

        }
    }

    private boolean isPalindrome(String s, int l, int r){
        if(l == r) return true;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
                l++; r--;
            }
        }
        return true;
    }
}