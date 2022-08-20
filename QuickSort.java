import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuickSort{


    int count = 0;
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

        temp = arr[l];
        arr[l]= arr[i-1];
        arr[i-1] = temp;
        return i-1;
    }

    public void quickSort(Integer arr[], int first, int end) 
    {
        if(first < end)
        {
            int p = partition(arr, first, end);
            quickSort(arr,first, p-1);
            count += (p-1) - first + 1;
            quickSort(arr, p+1, end);
            count += end - (p+1) + 1;
        }
    }
    public static void main(String[] args) throws IOException {
        Integer[] intArray = new Integer[]{10,2,9,3,1,8};
        int len = intArray.length;
        QuickSort obj = new QuickSort();
        Integer[] arr = obj.readLines("input.txt");
        int size = arr.length;
        
        obj.quickSort(arr, 0, size-1);

        for(int i = 0; i < size; i++)
        {
            System.out.println(arr[i]);
        }
        System.out.println(obj.count);
    }
}