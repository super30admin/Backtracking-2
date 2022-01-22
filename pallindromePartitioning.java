
// Time complexity : approx 2^N 
// Space complexity : O(N)
// worked on LC : YES

class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList();
        
        dfs(0, s, new ArrayList(), res);
        return res;
        
    }
    
    private void dfs(int index, String s, List<String> path, List<List<String>> res) {
        if(s.length() == index) {
            res.add(new ArrayList(path));
        }
        
        for(int i=index; i< s.length(); i++) {
            // if current substring is pallindrome then proceed further
            if(isPallindrome(s.substring(index, i+1))) {
                // add this stirng to current path
                path.add(s.substring(index, i+1));
                // recursive call dfs next index
                dfs(i+1, s, path, res);
                path.remove(path.size()-1);
            }
            
        }
        
    }
    
    private boolean isPallindrome(String s) {
        int left = 0;
        char[] char_arr = s.toCharArray();
        
        int right = s.length()-1;
        
        while(left <= right) {
            
            if(char_arr[left] != char_arr[right]){
                return false;
            }else{
                left++;
                right--;
            }
            
            
        }
        
        return true;
        
        
    }
}
