package problem771;

public class Solution1 {
    public int numJewelsInStones(String J, String S) {
        boolean[] jewels = new boolean[128];
        for (int i = 0; i < J.length(); i++) {
            jewels[J.charAt(i)] = true;
        }
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            ans += jewels[S.charAt(i)] ? 1 : 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().numJewelsInStones("aA", "aAAbbbb")); // 3
        System.out.println(new Solution1().numJewelsInStones("z", "ZZ")); // 0

    }
}
