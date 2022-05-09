//time - O(2^n)
//space - O(n)
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }
    private void helper(String s, int index, List<String> path){

        if(index==s.length()){
            result.add(new ArrayList<>(path));
        }

        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s.substring(index, i+1))){
                path.add(s.substring(index, i+1));
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int start = 0, end = s.length()-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
