class Solution {
    public int[] intersect(int[] a, int[] b) {

        HashMap<Integer, Integer> aMap = new HashMap<>();

        for (int ele : a) {
            if (aMap.containsKey(ele)) {
                int freq = aMap.get(ele);
                aMap.put(ele, freq + 1);
            }
            else {
                aMap.put(ele, 1);
            }
        }

        HashMap<Integer, Integer> bMap = new HashMap<>();

        for (int ele : b) {
            if (bMap.containsKey(ele)) {
                int freq = bMap.get(ele);
                bMap.put(ele, freq + 1);
            }
            else {
                bMap.put(ele, 1);
            }
        }

        int[] ans = new int[Math.min(a.length, b.length)];
        int index = 0;

        for (int ele : bMap.keySet()) {

            if (aMap.containsKey(ele)) {

                int freq = bMap.get(ele);
                int aFreq = aMap.get(ele);

                int count = Math.min(aFreq, freq);

                for (int i = 0; i < count; i++) {
                    ans[index++] = ele;
                }
            }
        }

        return Arrays.copyOf(ans, index);
    }
}






// class Solution {
//     public int[] intersect(int[] a, int[] b) {
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for (int ele : a) {
//             if (aMap.containsKey(ele)) {
//                 int freq = aMap.get(ele);
//                 aMap.put(ele, 1);
//             }
//             else aMap.put(ele, 1);
//         }
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int ele : b) {
//             if (bMap.containsKey(ele)) {
//                 int freq = bMap.get(ele);
//                 bMap.put(ele, freq + 1);
//             }
//             else bMap.put(ele, 1);
//         }
//         for (int ele : bMap.keySet()) {
//             int freq = bMap.get(ele);
//             int aFreq = bMap.get(ele);
//             if (aFreq < freq) return false;

//         }
//         return true;
//     }
// }