class PalimdromeParitioning {
    public List<List<String>> partition(String s) {

        List<List<String>> list = new ArrayList<>();

        for (int i=0; i<s.length(); i++) {
            substr = str.substring(0, i);
            list.add(substr);
        }

        return list;

    }
}