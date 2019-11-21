/**
 * Time Complexity: O(n^n)??
 * Space Complexity: O(n)?
 * Leetcode: Runs Successfully
 * Problems: I have problems understanding time/space complexity of backtracking problems.
 * Will be reviewing this weekend
 */

class Solution {
    private List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        //call getPartitions()
        getPartitions(s, 0, new ArrayList<>());
        return result;
    }
    
    private void getPartitions(String s, int index, List<String> list){
        //base case: if we have gone past the length of our string, add list to result, then return
        if(index == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = index; i < s.length(); i++){
            String sub = s.substring(index, i + 1);
            if(isPalindrome(sub)){
                list.add(sub);
                getPartitions(s, i+1, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        if(s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
