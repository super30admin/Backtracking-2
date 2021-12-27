class Solution {
    
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        
        result = new ArrayList();
        helper(s,new ArrayList(),0);
        return result;
    }
    
    private void helper(String s, List<String> curr, int index){
        
        if(index== s.length()){
            result.add(new ArrayList(curr));
            return;
        }
        
        for(int i=index;i<s.length();i++){
            String currString = s.substring(index,i+1);
            
            if(isPalin(currString)){
                //action
                curr.add(currString);
                //recurse
                helper(s,curr,i+1);
                //backtracking
                curr.remove(curr.size()-1);
            }
        }
    }
    
    public boolean isPalin(String s){
        int start=0;
        int end = s.length()-1;
        
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}