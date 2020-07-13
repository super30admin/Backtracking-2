Executed in Leet code - Yes
Time Complexity- n*2 pow n

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s==null) return result;
        
        helper(result,s,new ArrayList<String>(), 0);
        return result;
    }
    
    private void helper(List<List<String>> result,String s,ArrayList<String> tmpResult,int index){
        if(index==s.length()){
            result.add(new ArrayList<>(tmpResult));
            return;
        }
        for(int i=index;i<s.length();i++){
             if(isPalindrome(s,index,i)) {
                tmpResult.add(s.substring(index,i+1));
                 helper(result, s, tmpResult,i+1);
              tmpResult.remove(tmpResult.size()-1);
             }
        }
          
            
    }
    
     private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        } return true; 
    }
}
