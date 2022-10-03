package backjoon.binary_search;

public class Example {

    static int[] arr = {1, 3, 5, 7, 8, 10, 20, 35, 99, 100};

    // 재귀적 탐색
    static int binarySearch1(int key, int min, int max) {
        if (min <= max) {
            int mid = (min + max) / 2;

            if (key < arr[mid]) {
                return binarySearch1(key, min, mid - 1); // 왼쪽 부분 탐색
            } else if (key > arr[mid]) {
                return binarySearch1(key, mid + 1, max); // 오른쪽 부분 탐색
            } else {
                return mid; // 탐색 성공
            }
        }
        return -1; // 탐색 실패
    }

    // 반복적 탐색
    static int binarySearch2(int key, int min, int max) {
        while (min <= max) {
            int mid = (min + max) / 2;

            if (key < arr[mid]) {
                max = mid - 1; // 왼쪽 부분 탐색
            } else if (key > arr[mid]) {
                min = mid + 1; // 오른쪽 부분 탐색
            } else {
                return mid; // 탐색 성공
            }
        }
        return -1; // 탐색 실패
    }

    public static void main(String[] args) {
        System.out.println("1. 순환 호출을 이용한 이진 탐색");
        System.out.println(binarySearch1(5, 0, arr.length-1)); // 2

        System.out.println("\n2. 반복을 이용한 이진 탐색");
        System.out.println(binarySearch2(20, 0, arr.length-1)); // 6
    }
}