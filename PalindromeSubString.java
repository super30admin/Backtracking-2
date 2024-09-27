//expontial time and o(n) space
//passed all leetcode cases
//used backtracking approach discussed in class

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null ||s.length()==0) return result;
        backtrack(s,new ArrayList<>(),0);
        return result;

    }
    private void backtrack(String s,List<String> temp, int index){

        if(index == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                temp.add(s.substring(index,i+1));
                backtrack(s,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }

    }
    private boolean isPalindrome(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}