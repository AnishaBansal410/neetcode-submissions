
class CountSquares {

    Map<String, Integer> ptsCount;
    List<int[]> pts;

    public CountSquares() {
        ptsCount = new HashMap<>();
        pts = new ArrayList<>();
    }

    private String getKey(int x, int y) {
        return x + "," + y;
    }

    public void add(int[] point) {
        pts.add(point);

        String key = getKey(point[0], point[1]);

        ptsCount.put(key, ptsCount.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0;

        int px = point[0];
        int py = point[1];

        for (int[] pt : pts) {

            int x = pt[0];
            int y = pt[1];

            // Check if pt can be a diagonal point
            if (Math.abs(px - x) != Math.abs(py - y)
                    || x == px || y == py) {
                continue;
            }

            int count1 = ptsCount.getOrDefault(getKey(x, py), 0);
            int count2 = ptsCount.getOrDefault(getKey(px, y), 0);

            res += count1 * count2;
        }

        return res;
    }
}
