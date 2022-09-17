import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort{
    int count = 0;
    int mid;
    /*READ ARRAY NUMBERS*/
    public Integer[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Integer> lines = new ArrayList<Integer>();
        String line = null;
        int temp;
        while ((line = bufferedReader.readLine()) != null) {
            temp = Integer.parseInt(line);
            lines.add(temp);
        }
        bufferedReader.close();
        return lines.toArray(new Integer[lines.size()]);
    }
    
    /*SWAP FUNCNTION*/
    public void swap(Integer arr[], int index1, int index2)
    {
        int temp;
        temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public void choosePivot(Integer arr[], int l, int r, int choice)
    {
        if(choice == 1)
        {
            //pivot as last element
            swap(arr, l, r);
        }
        else if(choice == 2) {
            // pivot as median
            int len = (r - l) + 1;
            int median;
            int middle;

            if(len % 2 == 0)
            {
                middle = len / 2;
                middle -= 1;
            }
            else
            {
                middle = l + (r-l) /2;
            }

            int[] array = new int[3];
            array[0] = arr[l];
            array[1] = arr[r];
            array[2] = arr[middle];
            Arrays.sort(array);
            median = array[1];

            if(median == arr[l])
            {
                mid = l;
            }
            else if(median == arr[r])
            {
                mid = r;
            }
            else {
                mid = middle;
            }

            System.out.println("pivot: " + mid);
            swap(arr,l,mid);

        }
    }

    public int partition(Integer arr[],int l, int r)
    {
        int pivot = arr[l];
        int i = l+1;
        int temp;
        for(int j = l+1; j <= r; j++)
        {
            if(arr[j] < pivot)
            {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }

        //swap 
        swap(arr, l, i-1);

        return i-1;
    }

    public void quickSort(Integer arr[], int first, int end) 
    {
        if(first < end)
        {
            choosePivot(arr, first, end, 1);
            int p = partition(arr, first, end);
            quickSort(arr,first, p-1);
            count += (p-1) - first + 1;
            quickSort(arr, p+1, end);
            count += end - (p+1) + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        QuickSort obj = new QuickSort();
        Integer[] arr = obj.readLines("input.txt");
        int size = arr.length;
        obj.quickSort(arr, 0, size-1);
        System.out.println(obj.count);
    }
}