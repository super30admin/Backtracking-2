Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

 //Approach 1 :As we are told to find all possible solutions we can think of recursion 
 // let's go with 0-1 recursion

 // Time Complexity : 
 As every call is doing further two calls so it is exponential : 2^n a
 We are creating a new list at every time so we will create 2^n list and we will copy max n elements so 2^n * n 
 Time Complexity : O(2^n . n)
 // Space Complexity :
 We will have O(n) for stack Space
 2^n . n -> for creating list and copying elements
 Space Complexity : O(2^n . n)

 class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0){
            return new ArrayList<>();
        }
        result=new ArrayList<>();
        recurse(nums,0,new ArrayList<>());
        return result;
    }
    private void recurse(int[] nums, int index, ArrayList<Integer> path){
        //base case
        if(index==nums.length){
            result.add(path);
            return;
        }
        //logic
        //0 case
        recurse(nums,index+1,new ArrayList<>(path));
        //1 case
        path.add(nums[index]);
        recurse(nums,index+1,new ArrayList<>(path));
    }
}

//Back tracking solution:
Time Complexity : O(n . 2^n)
Space Complexity : O(n . 2^n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0){
            return new ArrayList<>();
        }
        result=new ArrayList<>();
        recurse(nums,0,new ArrayList<>());
        return result;
    }
    private void recurse(int[] nums, int index, ArrayList<Integer> path){
        //base case
        if(index==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //0 case
        recurse(nums,index+1,path);
        //1 case
        path.add(nums[index]);
        recurse(nums,index+1,path);
        path.remove(path.size()-1);
    }
}


//For loop based backtracking solution

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0){
            return new ArrayList<>();
        }
        result=new ArrayList<>();
        recurse(nums,0,new ArrayList<>());
        return result;
    }
    private void recurse(int[] nums, int index, ArrayList<Integer> path){
        //base case
        result.add(new ArrayList<>(path));
        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            recurse(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}


// Generate All Subsets (Backtracking)
import java.util.*;

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>());
        return result;
    }

    private void recurse(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // Exclude the current element
        recurse(nums, index + 1, path);
        // Include the current element
        path.add(nums[index]);
        recurse(nums, index + 1, path);
        path.remove(path.size() - 1);
    }
}


2. Generate All Subsequences (Backtracking)
import java.util.*;

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsequences(int[] nums) {
        result = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>());
        return result;
    }

    private void recurse(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            if (!path.isEmpty()) { // Subsequence must not be empty
                result.add(new ArrayList<>(path));
            }
            return;
        }
        // Include current element
        path.add(nums[index]);
        recurse(nums, index + 1, path);
        path.remove(path.size() - 1);

        // Exclude current element
        recurse(nums, index + 1, path);
    }
}

3. Subsets Without Duplicates
import java.util.*;

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums); // Sort first
        recurse(nums, 0, new ArrayList<>());
        return result;
    }

    private void recurse(int[] nums, int index, List<Integer> path) {
        result.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue; // Skip duplicate elements

            path.add(nums[i]);
            recurse(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}

4. Subsequences Without Duplicates (Sorting + Skipping Duplicates)
import java.util.*;

class Solution {
    Set<List<Integer>> result; // Using Set to store unique subsequences

    public List<List<Integer>> subsequencesWithoutDuplicates(int[] nums) {
        result = new HashSet<>();
        Arrays.sort(nums); // Sort first
        recurse(nums, 0, new ArrayList<>());
        return new ArrayList<>(result);
    }

    private void recurse(int[] nums, int index, List<Integer> path) {
        if (!path.isEmpty()) { // Non-empty subsequence
            result.add(new ArrayList<>(path));
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue; // Skip duplicates

            path.add(nums[i]);
            recurse(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}

5. Unique Subsequences Using HashSet
import java.util.*;

class Solution {
    Set<List<Integer>> result; // HashSet ensures unique subsequences

    public List<List<Integer>> subsequencesUnique(int[] nums) {
        result = new HashSet<>();
        recurse(nums, 0, new ArrayList<>());
        return new ArrayList<>(result);
    }

    private void recurse(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            if (!path.isEmpty()) { // Non-empty subsequence
                result.add(new ArrayList<>(path));
            }
            return;
        }
        // Include current element
        path.add(nums[index]);
        recurse(nums, index + 1, path);
        path.remove(path.size() - 1);

        // Exclude current element
        recurse(nums, index + 1, path);
    }
}
