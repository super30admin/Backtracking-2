// Time and Space Complexity: l2^l, l:length of substring

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s,0,new ArrayList<>(),result);
        return result;
    }

    private void helper(String s,int pivot,List<String> path,List<List<String>> result ){

        if(pivot==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=pivot;i<s.length();i++){
            String currSub = s.substring(pivot,i+1);
            if(isPalindrome(currSub)){
                path.add(currSub);
                helper(s,i+1,path,result);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;

        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}