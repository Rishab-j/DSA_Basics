package LeetCode;

public class SingleElementInArray {

    public int singleNonDuplicate(int[] arr) {
        
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }
            if (arr[mid] == arr[mid + 1]) {
                if ((right - mid) % 2 == 0) {
                    left = mid + 2;
                } else {

                    right = mid - 1;
                }
            } else {
                if ((right - mid) % 2 == 0) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            }
        }

        return arr[left];

    }

}