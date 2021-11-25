package INFO_6205_FinalProject;


import java.util.Arrays;


public class DualQuicksort {

    static void swap(String[] arr, int i, int j)
    {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void dualPivotQuickSort(String[] arr,
                                   int low, int high)
    {
        if (low < high)
        {

            int[] piv;
            piv = partition(arr, low, high);

            dualPivotQuickSort(arr, low, piv[0] - 1);
            dualPivotQuickSort(arr, piv[0] + 1, piv[1] - 1);
            dualPivotQuickSort(arr, piv[1] + 1, high);
        }
    }

    static int[] partition(String[] arr, int low, int high)
    {
        if (arr[low].compareTo( arr[high])>0)
            swap(arr, low, high);

        int j = low + 1;
        int g = high - 1, k = low + 1;
        String  p = arr[low], q = arr[high];

        while (k <= g)
        {

            if (arr[k].compareTo(p)<0)
            {
                swap(arr, k, j);
                j++;
            }else if (arr[k].compareTo(q)>=0) {
                while (arr[g].compareTo(q)>0 && k < g)
                    g--;

                swap(arr, k, g);
                g--;

                if (arr[k].compareTo(p)<0)
                {
                    swap(arr, k, j);
                    j++;
                }
            }
            k++;
        }
        j--;
        g++;

        swap(arr, low, j);
        swap(arr, high, g);

        return new int[] { j, g };
    }

    // Driver code
    public static void main(String[] args)
    {

        String str[] = { "qop","hyp","oou" ,"lz","hxy", "pzj","qhy", "albb","zy" };

        dualPivotQuickSort(str, 0, str.length-1);

        System.out.print("Sorted array: ");
        for (int i = 0; i < str.length; i++)
            System.out.print(str[i] + " ");

    }

}
