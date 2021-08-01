class Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();

        answer.add(new ArrayList<Integer>());

        for (int i=0; i<nums.length; i++) {

            List<List<Integer>> subsets = new ArrayList();

            for (List<Integer> element : answer) {

                subsets.add(new ArrayList<>(element));

            }

            for (List<Integer> element : subsets) {
                answer.add(element);
            }

        }

        return answer;


    }
}