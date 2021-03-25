//TC: O(N. 2^N)
//SC: O(N)
class Solution {
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0)
            return output;
        backtracker(s,0,new ArrayList<>());
        return output;
    }
    private List<List<String>> output = new ArrayList<>();
    
    private void backtracker(String s , int index, List<String> path){
        if(index >= s.length())
        {output.add(new ArrayList<>(path)); return;}
        for(int i = index;i<s.length();i++){
            String curr = s.substring(index,i+1);
            if(isPalindrome(curr)){
                path.add(curr);
                backtracker(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String str){
        int left =0;
        int right = str.length()-1;
        while(left<right)
        {
            if(str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}