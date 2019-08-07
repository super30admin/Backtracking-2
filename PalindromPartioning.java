//Time Complexity : O(2^n)
//Space Complexity : O(2^n)

//Idea : 1. for each iteration , if the substring is palindrom add the substring to list.
// 2 . back track the substring and retrun the final list.. 

class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<List<String>>();
        backtrack(s,0,result,new ArrayList<String>());
        return result;
    }
    
    public void backtrack(String s, int idx,List<List<String>> result,List<String> temp){
        if(idx>= s.length()){
            List<String> cloneList = new ArrayList<String>(temp);
            result.add(cloneList); //error
        }
        
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                temp.add(s.substring(idx,i+1));
                backtrack(s,i+1,result,temp); // think
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int idx, int i){
        while(idx<=i){
            if(s.charAt(idx)!=s.charAt(i)) return false;
            idx++; i--;
        }
        return true;
    }
}
