//Time complexity:O(2^N)
//Space complexity:O(N)
//Pss the string with start and end index
//check if the cuurent string is a plindrom, if it is a plaindrom add it to the path and then backtrack to tje next index
//define a plaindrom function
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<List<String>>();
        if(s.isEmpty()|| s.length()==0){
            return result;
        }
        backtracker(s,0,new ArrayList<>());
        return result;
    }
    private void backtracker(String s, int index,List<String> path){
        //base
        if(index==s.length()){
            result.add(new ArrayList<>(path));
        }
        //logic
        for(int i=index; i<s.length();i++){
            
            
            if(isPali(index,i, s)){
                path.add(s.substring(index,i+1));
                backtracker(s,i+1,path);
                path.remove(path.size()-1);
                
            }
        }
        
        
    }
    
    private boolean isPali(int start, int end,String s){
        if(start==end){
            return true;
        }
        while(start<=end){
            if(s.charAt(end)!=s.charAt(start)){
                return false;
            }
          start++;
            end--;
        }
        return true;
    }
}