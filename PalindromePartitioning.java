class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result= new ArrayList<>();
        helper(s, 0, result, new ArrayList<>());
        return result;
    }

    public void helper(String s, int idx,List<List<String>> result,List<String> path ){
        if(idx==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx; i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                path.add(s.substring(idx,i+1));
                helper(s, i+1, result, path);
                path.remove(path.size()-1);
            }
        }

    }

    public static boolean isPalindrome(String s, int start, int end ){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;    
    }
}