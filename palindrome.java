//TC: O(n * 2^n), where n is the length of s.
//SC: O(n^2), where n is the length of s.

public class palindrome {
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> answer = new ArrayList<>();
            List<String> partition = new ArrayList<>();
            backTrack(s, partition, answer);
            return answer;
        }
        
        public static void backTrack
            (String s, List<String> partition , List<List<String>> answer){
            
            if(s.length() == 0){
                answer.add(new ArrayList<>(partition));
                return;
            }
            else{
                for(int i=0; i<s.length(); i++){
                    //cs = current sub-string
                    String cs = s.substring(0, i+1);
                    
                    if(isPalindrome(cs)){
                        partition.add(cs);
                        
                        //moving on with next string as previous sub-string is a successfull palindrome and added into partition
                        //ns = new sub-string (or) next sub-string
                        String ns = s.substring(i+1);
                        backTrack(ns, partition, answer);
                        //removing during backtracking- only inside if block not for every for loop iteration
                        partition.remove(partition.size()-1);
                    }
                }
            }
        }
        
        public static boolean isPalindrome(String s){
            int l = 0;
            int r = s.length()-1;
            
            while(l < r){
                if(s.charAt(l) != s.charAt(r)){
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }
}
