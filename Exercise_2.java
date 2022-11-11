class Solution {
    private List<String> c;
    private List<List<String>> r;

    public List<List<String>> partition(String s) {
        c = new ArrayList<>();
        r = new ArrayList<>();
        p(s,0);
        return r;
    }
    private void p(String s, int i){
        if(i==s.length()){
            r.add(new ArrayList<>(c));
            return;
        }

        for(int e=i; e<s.length(); ++e){
            String cs = s.substring(i, e+1);
            if(isp(cs)){
                c.add(cs);
                p(s, e+1);
                c.remove(c.size()-1);
            }
        }
    }
    private boolean isp(String s){
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
//tc=2^n +n
//sc=O(n)
