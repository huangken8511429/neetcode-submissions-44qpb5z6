class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        for (int num : numbers) {
            if (num > numbers[right]) {
                right--;
            }
        }
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                break;
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            }
            if (numbers[left] + numbers[right] < target) {
            left++;
            }
        }
        int[] result = new int[]{left + 1, right + 1};
        return result;
    }
}
