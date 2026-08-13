class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize != 0:
            return False
        count = Counter()
        for num in hand:
            count[num] += 1
        
        while count:
            minKey = min(count.keys())
            for i in range(minKey, minKey + groupSize):
                count[i] -= 1
                if count[i] < 0:
                    return False
                if count[i] == 0:
                    del count[i]    
        return True            
                
