class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {

        if (list.contains(tempList))
            return;
        if (start == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        if (start == nums.length)
            return;
        // System.out.println(list);
        tempList.add(nums[start]);
        backtrack(list, tempList, nums, start + 1);
        tempList.remove(tempList.size() - 1);
        backtrack(list, tempList, nums, start + 1);
    }

}