//Time Complexity: O(n*2^n);
//Space complexity:O(n)
//Approach: we used backtracking solution
class Solution {
    List<List<String>> output = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0,new ArrayList<>());
        return output;
    }
    
    private void backtracking(String s,int index,List<String> path){
        if(index>=s.length()){
            output.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = index;i<s.length();i++){
            String curr = s.substring(index,i+1);
            if(isPalindrome(curr)){
                path.add(curr);
                backtracking(s,i+1,path);
                path.remove(path.size()-1);
            }
            
        }
    }
    
    private boolean isPalindrome(String s) {
        int start=0;
        int end = s.length()-1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) 
                return false;
        }
        return true;
    }
}
