class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
            # 配對並按位置降序排序（離終點最近的在前）
        cars = sorted(zip(position, speed), reverse=True)
        stack = []
        
        for i, car in enumerate(cars):
            p = car[0]
            s = car[1]
            time = (target - p) / s
            if not stack or time > stack[-1]:
                stack.append(time)

        return len(stack)         




