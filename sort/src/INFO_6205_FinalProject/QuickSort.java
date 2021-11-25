package INFO_6205_FinalProject;


import java.util.Arrays;



public class QuickSort {

    public String[] sort(String[] sourceArray,int index) {


        // 对 arr 进行拷贝，不改变参数内容
        String[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return  quickSort(arr, 0, arr.length - 1);
    }

    public String[] sort(String[] sourceArray) {

        // 对 arr 进行拷贝，不改变参数内容
        String[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return  quickSort(arr, 0, arr.length - 1);
    }

    private String[] quickSort(String[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(String[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {

                if (arr[i].compareTo(arr[pivot]) < 0) {
                    swap(arr, i, index);
                    index++;
                }

        }

        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        String str[] = { "qop","hyp","oou" ,"lz","hxy", "pzj","qhy", "albb","zy" };


        QuickSort q = new QuickSort();


        System.out.print("Unsorted array : ");


        for(String i: str){
            System.out.print(i + " ");
        }

        str =  q.sort(str);

        System.out.print("Sorted array : ");

        for(String i: str){
            System.out.print(i + " ");
        }
    }




}
