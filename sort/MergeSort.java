package sort;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static sort.SortUsefull.less;

public class MergeSort {




    public void sort(Comparable[] array)throws IllegalArgumentException{
        if (array==null) throw new IllegalArgumentException("array is null");
        if (array.length<=1) return;
        mergesort(array,0,array.length-1);


    }
    public void mergesort(Comparable[] array,int lo,int hi) {
        if (lo>=hi) return;
        int mid=lo+(hi-lo)/2;
        mergesort(array,lo,mid);
        mergesort(array,mid+1,hi);
        merge(array,lo,mid,hi);
        }

    private void merge(Comparable[] array, int lo, int mid, int hi) {
        if(hi-lo<1)return;
        Comparable[] aux=new Comparable[hi-lo+1];
        for (int x = 0; x < hi-lo+1; x++) {
            aux[x]=array[x+lo];
        }
        int i=lo;
        int j=mid+1;
        int k=lo;
        while(k<=hi){
            if (i>mid){
                array[k]=aux[j-lo];
                j++;
                k++;
                continue;
            }
            if (j>hi){
                array[k]=aux[i-lo];
                i++;
                k++;
                continue;
            }
            if(!less(aux[i-lo],aux[j-lo])){
                array[k]=aux[j-lo];
                j++;
                k++;
                continue;
            }
            array[k]=aux[i-lo];
            i++;
            k++;
        }

    }

}




