class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       // 步驟1: 建立 numberToCount (你原本的 HashMap 是對的!)
      Map<Integer, Integer> numberToCount = new HashMap<>();
      for (int num: nums) {
         numberToCount.put(num, numberToCount.getOrDefault(num, 0) + 1);
      }

      // 步驟2: 建立 buckets
      // bucket[i] 存放「出現 i 次的所有數字」
      List<Integer>[] buckets = new List[nums.length + 1];
      for (int i = 0; i < buckets.length; i++) {
         buckets[i] = new ArrayList<>();
       }

       // 步驟3: 把數字放進對應的 bucket 
      for (Map.Entry<Integer, Integer> entry : numberToCount.entrySet()) {
         int num = entry.getKey();
         int count = entry.getValue();
         buckets[count].add(num);  // 關鍵:用 count 當索引!
        }

        int[] result = new int[k];
        int index = 0;  // 記錄 result 放到哪裡了

// 從最大的 count 開始往回找
for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
    // 如果這個 bucket 有數字
    if (!buckets[i].isEmpty()) {
        // 把這個 bucket 裡的數字都加入 result
        for (int num : buckets[i]) {
            result[index] = num;
            index++;
            if (index == k) {  // 已經收集夠 k 個了
                break;
            }
        }
    }
}

 return result;
    }
}
