//for loop based recursion
// Time complexity - O(2^n)
// Space complexity - O(n)? or O(2^n)?
class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s,0, new ArrayList<>());
        return result;
    }
    public void helper(String s, int idx, List<String> path) {
        if (idx == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx, i + 1); 
            if (isPalindrome(sub)) {
                path.add(sub);                    
                helper(s, i + 1, path);            
                path.remove(path.size() - 1);      
            }
        }
    }
    public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
    }
}

// // Approach : Using 0-1 based recursion, 
// // Time Complexity : O(2^n)
// // Space Complexity : O(2^n)
// class Solution {
//     public List<List<String>> partition(String s) {
//         List<List<String>> result = new ArrayList<>();
//         helper(s, 0, 0, new ArrayList<String>(), result);
//         return result;
//     }
//     public void helper(String s, int pivot, int i, ArrayList<String> path, List<List<String>> result){
//         //base
//         if(pivot == s.length() && path.size()!=0){
//             result.add(new ArrayList<String>(path));
//             return;
//         }
//         if(i==s.length()){
//             return;
//         }
//         //logic
//         helper(s, pivot, i+1, path, result);
//         String currStr = s.substring(pivot, i+1);
//         if(palindrome(currStr)){
//             path.add(currStr);
//             helper(s, i+1, i+1, path, result);
//             path.remove(path.size()-1);
//         }
//     }
//     boolean palindrome(String s){
//         int start = 0, end = s.length()-1;
//         while(start<end){
//             if(s.charAt(start)!=s.charAt(end)){
//                 return false;
//             }
//             start++;
//             end--;
//         }
//         return true;
//     }
// }
