class SegmentTree {
    int[] tree;
    int n;

    public SegmentTree(int[] nums) {
        n = nums.length;
        tree = new int[n * 4];
        build(nums, 0, 0, n - 1);
    }

    private void build(int[] nums, int node, int l, int r) {
        if (l == r) {
            tree[node] = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        build(nums, 2 * node + 1, l, mid);
        build(nums, 2 * node + 2, mid + 1, r);
        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }

    public int queryFirst(int target) {
        return queryFirst(0, 0, n - 1, target);
    }

    private int queryFirst(int node, int l, int r, int target) {
        if (tree[node] < target) return -1;
        if (l == r) return l;

        int mid = (l + r) / 2;
        int left = queryFirst(2 * node + 1, l, mid, target);
        if (left != -1) return left;
        return queryFirst(2 * node + 2, mid + 1, r, target);
    }

    public void update(int index, int value) {
        update(0, 0, n - 1, index, value);
    }

    private void update(int node, int l, int r, int index, int value) {
        if (l == r) {
            tree[node] = value;
            return;
        }
        int mid = (l + r) / 2;
        if (index <= mid) {
            update(2 * node + 1, l, mid, index, value);
        } else {
            update(2 * node + 2, mid + 1, r, index, value);
        }
        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }
}

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        SegmentTree st = new SegmentTree(baskets);
        int placed = 0;

        for (int fruit : fruits) {
            int idx = st.queryFirst(fruit);
            if (idx == -1) continue;  // ✅ skip, but keep going
            st.update(idx, -1);       // mark basket as used
            placed++;
        }

        return fruits.length - placed;
    }
}
