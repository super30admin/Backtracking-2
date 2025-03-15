// // for loop based recursion
// // TC: O(N X 2^N)
// // SC: O(N)
// class Solution {
//     List<List<String>> result;
//     public List<List<String>> partition(String s) {
        
//         result = new ArrayList<>();
//         if(s.length() == 0) return result;
//         recurse(s, 0, new ArrayList<>());
//         return result;
//     }
//     public void recurse(String s, int index, List<String> path){
//         //base
//         if(index == s.length()){
//             result.add(new ArrayList<>(path));
//             return;
//         }
//         for(int i = index; i < s.length(); i++){
//             if(isPalindrome(s, index, i)){
//                 path.add(s.substring(index, i + 1));
//                 recurse(s, i + 1, path);
//                 path.remove(path.size() - 1);
//             }
//         }
//     }
//     public boolean isPalindrome(String s, int l, int r){
//         while(l < r){
//             if(s.charAt(l) != s.charAt(r)) return false;
//             l++;
//             r--;
//         }
//         return true;
//     }
// }


// for loop based recursion (for loop starting from 0)
// TC: O(N X 2^N)
// SC: O(N)
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        
        result = new ArrayList<>();
        if(s.length() == 0) return result;
        recurse(s, new ArrayList<>());
        return result;
    }
    public void recurse(String s, List<String> path){
        //base
        if(s == null || s.length() == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(isPalindrome(s, 0, i)){
                path.add(s.substring(0, i + 1));
                recurse(s.substring(i + 1), path);
                path.remove(path.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
