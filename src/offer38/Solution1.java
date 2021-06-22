package offer38;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {
    private ArrayList<String> ans = new ArrayList<>();
    private void dfs(char[] chars, boolean[] visited, StringBuilder stringBuilder) {
        // 构造完成
        if (stringBuilder.length() == chars.length) {
            ans.add(stringBuilder.toString());
            return;
        }
        // 遍历下一选项
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            stringBuilder.append(chars[i]);
            dfs(chars, visited, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            visited[i] = false;
            // 跳过相同字符
            while (i + 1 < chars.length && chars[i] == chars[i + 1]) i++;
        }
    }
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        dfs(chars, visited, new StringBuilder());
        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().permutation("abc")));
        System.out.println(Arrays.toString(new Solution1().permutation("aab")));
    }
}
