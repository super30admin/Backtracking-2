class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        // helper_forRecusion(s,0,new ArrayList<>(),result);
        helper_01Reursion(s,0,0,new ArrayList<>(),result,0);
        return result;

    }


    private void helper_forRecusion(String s, int pivot, List<String> path, List<List<String>> result) {
        //base 
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic 
        for (int i = pivot; i < s.length(); i++) {
            String currPath = s.substring(pivot, i+1 );

            if (isPalindrome(currPath, 0, currPath.length() - 1)) {
                //action
                path.add(currPath);
                //recurse 
                helper_forRecusion(s, i+1 , path, result);
                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private void helper_01Reursion(String s, int pivot,int idx, List<String> path, List<List<String>> result,int cnt){
        //base
        if (idx == s.length()) {
            if(cnt==s.length()){
             result.add(new ArrayList<>(path));
            }
            return;
        }
        //not choose
        helper_01Reursion(s,pivot,idx+1,path,result,cnt);
        //choose
        String currPath = s.substring(pivot, idx+1);
        if(isPalindrome(currPath,0,currPath.length()-1)){
            path.add(currPath);
            int newCnt = cnt+currPath.length();
            helper_01Reursion(s,idx+1,idx+1,path,result,newCnt);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int l, int r){

        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }

            l++;
            r--;
        }
        return true;
    }
}