function subsetsWithDup(nums: number[]): number[][] {
  let result: number[][] = [];

  function backtracking(nums: number[], pivot: number, path: number[]) {
    // Base
    result.push([...path]);

    // Logic
    for (let index = pivot; index < nums.length; index++) {
      if (index > pivot && nums[index] == nums[index - 1]) continue;
      path.push(nums[index]);
      backtracking(nums, index + 1, path);
      path.pop();
    }
  }

  nums.sort();

  backtracking(nums, 0, []);

  return result;
}

describe("Subsets ||", () => {
  it("Happy Path - 01", () => {
    let candidates = [1, 2, 2];
    expect(subsetsWithDup(candidates)).toEqual([
      [],
      [1],
      [1, 2],
      [1, 2, 2],
      [2],
      [2, 2],
    ]);
  });
});
