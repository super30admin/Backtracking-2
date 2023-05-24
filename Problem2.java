// Time: O(N * 2^N) 
// Space: O(N)

class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();

        helper(s, new ArrayList<String>(), 0);
        return res;
        
    }

    public void helper(String s, List<String> path, int idx){

        if(idx == s.length()){
            res.add(new ArrayList<>(path));
        }
        for(int i = idx; i< s.length(); i++){
            String sub = s.substring(idx,i+1);
            System.out.println(sub);
            if(isPalindrom(sub)){
                path.add(sub);
                helper(s, path,i +1);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrom(String s){
        int start = 0 ;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;

    }
}