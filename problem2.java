// Time : (2^n) * n
//space : n

class Solution {

    private List<List<String>> res;
    private List<String> curr;

    public List<List<String>> partition(String s) {

        res = new ArrayList<>();
        curr = new ArrayList<>();

        partition(s, 0);

        return res;
    }

    private void partition(String s, int index) {

        // base
        if (index == s.length()) {
            res.add(new ArrayList<>(curr));
        }

        //
        for (int end = index; end < s.length(); end++) {
            String initial = s.substring(index, end + 1);

            if (isPalidrome(initial)) {
                curr.add(initial);
                partition(s, end + 1);
                curr.remove(curr.size() - 1);
            }

        }
    }

    private boolean isPalidrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    /*
     * private boolean isPalidrome(String s){
     * int l = 0, r = s.length() - 1;
     * 
     * while (l < r){
     * if (s.charAt(l) != s.charAt(r)){
     * return false;
     * }
     * ++l;
     * --r;
     * }
     * 
     * return true;
     * 
     * }
     */
}