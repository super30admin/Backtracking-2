function partition(s: string): string[][] {
  let result: string[][] = [];

  function isPalindrom(str: string): boolean {
    let left = 0;
    let right = str.length - 1;

    while (left < right) {
      if (str.charAt(left) != str.charAt(right)) return false;
      left++;
      right--;
    }
    return true;
  }

  function backtracking(s: string, pivot: number, path: string[]) {
    // Base
    if (pivot == s.length) {
      result.push([...path]);
    }

    // Logic
    for (let index = pivot; index < s.length; index++) {
      let substring = s.substring(pivot, index + 1);
      if (isPalindrom(substring)) {
        path.push(substring);
        backtracking(s, index + 1, path);
        path.pop();
      }
    }
  }

  backtracking(s, 0, []);

  return result;
}

describe("Palindrome Partitioning", () => {
  it("Happy Path - 01", () => {
    let candidates = [1, 2, 3];
    expect(partition("aab")).toEqual([
      ["a", "a", "b"],
      ["aa", "b"],
    ]);
  });
});
