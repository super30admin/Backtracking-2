TC : O(2^N)
SC : O(N2^N)

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        //EDGE CONDITION
        if(s == null || s.length()<1) return result;
        backTrack(s, new ArrayList<>(), 0);
        return result;
    }
    
    private void backTrack(String s, List<String> temp, int start){
        //base
        if(start>=s.length()){
            result.add(new ArrayList<>(temp));
        }
        //logic
        for(int i = start; i<s.length(); i++){
            if(isPalindrome(s,start, i)){
                //Action
                temp.add(s.substring(start,i+1));
                //Recurse
                backTrack(s.substring(i+1),temp,0);
                //BackTrack
                temp.remove(temp.size()-1);
            }
        }
    }
    
    //Method to check if the string is palimdrome or not
    private boolean isPalindrome(String s, int l, int r){
        if(l == r) return true;
        while(l<r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}