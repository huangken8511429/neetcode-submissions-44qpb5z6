class CountSquares {
    private Map<List<Integer>, Integer> count;
    private List<List<Integer>> points;
    
    public CountSquares() {
       count = new HashMap<>();
       points = new ArrayList<>();   
    }
    
    public void add(int[] point) {
        List<Integer> p = Arrays.asList(point[0], point[1]);
        count.put(p, count.getOrDefault(p, 0) + 1);
        points.add(p);
    }
    
    public int count(int[] point) {
        int res = 0;
        int px = point[0], py = point[1];
        for (List<Integer> p : points) {
            int x = p.get(0), y = p.get(1);
            if (Math.abs(x - px) != Math.abs(y - py) || x == px || y == py) {
                continue;
            }
            res += count.getOrDefault(Arrays.asList(x, py), 0) * count.getOrDefault(Arrays.asList(px, y), 0);
        }
        return res;
    }
}
