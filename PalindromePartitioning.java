class Solution {
    //Time Complexity: O(2^n)
    //Space Complexity: O(n)
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> sub = new ArrayList<>();
        dfs (s, res, sub, 0);
        return res;
    }

    public void dfs (String s, List<List<String>> res, List<String> sub, int i) {
        if (i >= s.length()){
            res.add (new ArrayList<>(sub));
            return;
        }
        for (int j = i; j < s.length(); j++){
            if (isPali(s,i,j)){
                sub.add(s.substring( i, j+1));
                dfs(s, res, sub, j+1);
                sub.remove (sub.size()-1);
            }
        }
    }

   private boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

