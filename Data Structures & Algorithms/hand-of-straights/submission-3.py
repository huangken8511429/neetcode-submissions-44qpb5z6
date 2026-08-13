class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize != 0:
            return False
        count = Counter(hand)
        for num in hand:
            count[num] += 1
        
        for num in sorted(count):        # 排序一次 O(k log k)
            if count[num] > 0:           # 這個數字還有剩，必須當某組的開頭
                need = count[num]        # 有幾張，就要開幾組
                for i in range(num, num + groupSize):
                    if count[i] < need:
                        return False
                    count[i] -= need
        return True        
                
