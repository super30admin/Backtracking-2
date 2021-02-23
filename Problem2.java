//Time complexity:O(2^n)
//Space complexity:O(length of string)
//Ran on leetcode:yes
//Solution with comments: 
class Solution {
    
    public List<List<String>> partition(String s) {
            backtrack(s,0,new ArrayList<>());
            return output;
    }
    
    List<List<String>> output= new ArrayList<>();
    
    public void backtrack(String s, int index, List<String> path){
        if(index >=s.length()){
            output.add(new ArrayList<>(path));//we add to ouput only when all substring till length are checked
            return;
        }
        
        for(int i=index;i<s.length();i++){
            String curr= s.substring(index,i+1);
            if(isPalindrome(curr)){
                path.add(curr);
                backtrack(s,i+1,path);
                path.remove(path.size()-1);//once backtrack is done for particular path remove the last added element
            }
        }
    }
    
    public boolean isPalindrome(String s){//check a string is palindrome
        int low=0;
        int high=s.length()-1;
        while(low<high){
            if(s.charAt(low)!=s.charAt(high)){
               return false; 
            }

            low++;
            high--;
            }
        return true;
    }
    
}