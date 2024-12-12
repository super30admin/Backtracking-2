function subsets(nums: number[]): number[][] {
  let result: number[][] = [];

  function backtracking(nums: number[], index: number, path: number[]) {
    // Base
    if (index == nums.length) {
      result.push([...path]);
      return;
    }

    // Logic
    // No Choose
    backtracking(nums, index + 1, path);

    // Choose
    path.push(nums[index]);
    backtracking(nums, index + 1, path);
    path.pop();
  }

  backtracking(nums, 0, []);

  return result;
}

function subsets_with_pivot(nums: number[]): number[][] {
  let result: number[][] = [];

  function backtracking(nums: number[], pivot: number, path: number[]) {
    // Base
    result.push([...path]);

    // Logic
    for (let index = pivot; index < nums.length; index++) {
      path.push(nums[index]);
      backtracking(nums, index + 1, path);
      path.pop();
    }
  }

  backtracking(nums, 0, []);

  return result;
}

describe("Subsets", () => {
  it("Happy Path - Pivot", () => {
    let candidates = [1, 2, 3];
    expect(subsets_with_pivot(candidates)).toEqual([
      [],
      [1],
      [1, 2],
      [1, 2, 3],
      [1, 3],
      [2],
      [2, 3],
      [3],
    ]);
  });

  it("Happy Path - 0/1 Scenario", () => {
    let candidates = [1, 2, 3];
    expect(subsets(candidates)).toEqual([
      [],
      [3],
      [2],
      [2, 3],
      [1],
      [1, 3],
      [1, 2],
      [1, 2, 3],
    ]);
  });
});
