//Time complexity: O(2^n)
//space Complexity: O(n)
//Pivot recursive backtracking  approach
class Solution {
    List<List<String>> result;
    List<String> path;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        helper(s,0);
        return result;
    }

    private void helper(String s, int pivot){

        //base
        if(pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;}

        //logic

        for(int i = pivot;i<s.length();i++){
            String sub = s.substring(pivot,i+1);
            if(isPalindrome(sub)){
                path.add(sub);
                helper(s,i+1);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;

        while(start<end){
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if(startChar!=endChar)
                return false;
            start++;
            end--;
        }
        return true;
    }
}

