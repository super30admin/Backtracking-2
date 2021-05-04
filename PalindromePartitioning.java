/*

Thought Process: Had to see professor's video to remember the approach again. Need to solve it using iterative template.

Base -> Iterate -> Action -> Recurse -> Backtrack

Time Complexity - O(N * 2 * pow(N)) -> Recursive Approach in 2 Pow(N) , Palindrome Check and Substring 2N
Space Complexity - O(N) -> Recursive height + 1 arraylist (path) + Substring

*/

class PalindromePartitioning {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length() == 0) return result;
        backtrack(s, 0, new ArrayList<>());
        return result;
    }
    
    private void backtrack(String s, int index, ArrayList<String> path){
        //base
        // Mistake Commited -> Was using s.lenght()-1
        if(index == s.length()){
            result.add(new ArrayList<>(path)); 
            return;
        }
        
        // Mistake Commited -> i=0; i<=index; i++
        for(int i=index; i< s.length(); i++){
            
            if(isPalindrome(s, index, i)){
                
                // Mistake Commited -> Was doing substring from i to index+1
                //Action
                path.add(s.substring(index, i+1));

                //Recurse
                backtrack(s, i+1, path);

                //Bactrack
                path.remove(path.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int p1, int p2){
        //Writing this line of code makes the code 1ms faster
        if(p1 == p2) return true;
        while(p1<=p2){
            if(s.charAt(p1) != s.charAt(p2))
                return false;
            p1++;
            p2--;
        }
        return true;
    }
}