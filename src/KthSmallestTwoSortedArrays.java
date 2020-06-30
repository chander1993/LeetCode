class KthSmallestTowSortedArrays {

    public int findKthSmallestElement(int[] arr1, int[] arr2, int k) {
        if(arr1 == null && arr2 == null) {
            return -1;
        }

        if(arr1.length + arr2.length < k) {
            return -1;
        }
        int i = 0;
        int j = 0;

        while(i < arr1.length && j < arr2.length) {
            int cur;
            if(arr1[i] < arr2[j]) {
                cur = arr1[i];
                i++;
            } else {
                cur = arr2[j];
                j++;
            }

            if(--k == 0) {
                return cur;
            }
        }

        while(i < arr1.length) {
            int cur = arr1[i];
            i++;
            if(--k == 0) {
                return cur;
            }
        }

        while(j < arr2.length) {
            int cur = arr2[j];
            j++;
            if(--k == 0) {
                return cur;
            }
        }

        return -1;
    }
}