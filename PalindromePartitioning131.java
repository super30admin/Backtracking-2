import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//leetcode : yes
class PalindromePartitioning131 {

        public List<List<String>> partition(String s) {
            
            List<List<String>> result = new LinkedList<>();
            
            List<String> state = new LinkedList<>();
            
            backtracking(result,state,s,0);
            
            return result;
        }
        
        public void backtracking(List<List<String>> result, List<String> state, String s, int start){
            
            
            if(start==s.length()){
                result.add(new ArrayList<>(state));
                return;
            }
            
            
            for(int end = start; end < s.length(); end++){
                if(isPlaindrome(s,start,end)){
                    state.add(s.substring(start,end+1));
                    backtracking(result,state,s,end+1);
                    state.remove(state.size()-1);
                }
                
            }
                  
                
                
        
            
            
        }
        
        public boolean isPlaindrome(String s, int start, int end){
            while(start<=end){
                if(s.charAt(start)!=s.charAt(end)){
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
        
    }



