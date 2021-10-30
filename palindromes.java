//Time complexity:-O(n*2^n)
//Spacecomplexity:- 0(1).
//Did it run on leetcode:- yes.
//What was the problem you faced?:- got many times memory limit exceeded.
//your code with explanation:only difference between previous sum and this sum is that if and only if string is palindrome
// then we add to temporary arraylist while traversing. when index reached out of length of string at that time we have
// already palindrome strings, so adding them to main output.

class Solution {
    private List<List<String>> result=new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> track=new ArrayList<>();
        partitionhelper(s,0,track);
      
return result;}
    private void partitionhelper(String s,int index,List<String> track){
        if(index>=s.length()){
            result.add(new ArrayList<>(track));
            return ;
        }
        for(int i=index;i<s.length();i++){
           String addingstring=s.substring(index,i+1);
            if(checkpalindrome(addingstring)){
                track.add(addingstring);
                partitionhelper(s,i+1,track);
                track.remove(track.size()-1);
            }
        }
        
    }
    private boolean checkpalindrome(String s){
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left=left+1;
            right=right-1;
        }
    return true;}
}