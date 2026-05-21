class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();
        for (int num : arr1) {
            String s = String.valueOf(num);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                set.add(sb.toString());
            }
        }
        int max = 0;
        for (int num : arr2) {
            String s = String.valueOf(num);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                if (set.contains(sb.toString())) {
                    max = Math.max(max, i + 1);
                }
            }
        }

        return max;
    }
}
