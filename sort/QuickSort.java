package sort;

import static sort.SortUsefull.*;
public class QuickSort {



    public void sort(Comparable[] array) throws IllegalArgumentException {
        if (array==null) throw new IllegalArgumentException("array is null");
        if (array.length<=1) return;
        quicksort(0,array.length-1,array);

    }
    private void quicksort(int lo,int hi,Comparable[] array){
        if (hi<=lo) return;
        int j=Partition(lo,hi,array);
        quicksort(lo,j-1,array);
        quicksort(j+1,hi,array);
    }

    public int Partition(int lo,int hi,Comparable[] array){
        Comparable pivot=array[lo];
        int i=lo, j=hi+1;
        while(true){
            while (less(array[++i],pivot)) if(i==hi) break;
            while (less(pivot,array[--j])) if (j==lo) break;
            if (i>=j) break;
            Exch(array,i,j);
        }
        Exch(array,lo,j);
        return j;

    }
}
