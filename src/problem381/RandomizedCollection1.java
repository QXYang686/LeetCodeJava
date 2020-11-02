package problem381;

import java.util.*;

public class RandomizedCollection1 {

    private Map<Integer, Set<Integer>> idx;
    private List<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedCollection1() {
        idx = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        // 保存
        nums.add(val);
        // 保存索引
        Set<Integer> set = idx.getOrDefault(val, new HashSet<Integer>());
        set.add(nums.size() - 1);
        idx.put(val, set);
        // 只有新值才会只有一个
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        // 元素不存在
        if (!idx.containsKey(val)) {
            return false;
        }
        // 提取元素的索引
        Iterator<Integer> it = idx.get(val).iterator();
        int i = it.next();
        // 提取存储的最后一个元素
        int lastNum = nums.get(nums.size() - 1);
        // 将存储的最后一个元素放到当前删除元素的位置上
        nums.set(i, lastNum);
        // 从元素索引存储中删除一个元素索引
        idx.get(val).remove(i);
        // 调整存储的最后一个元素的索引存储
        idx.get(lastNum).remove(nums.size() - 1);
        // 删除的不是最后一个元素的情况下需要重新添加删除的元素的索引
        if (i < nums.size() - 1) {
            idx.get(lastNum).add(i);
        }
        // 清理无效的索引存储
        if (idx.get(val).size() == 0) {
            idx.remove(val);
        }
        // 清理实际存储
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}
