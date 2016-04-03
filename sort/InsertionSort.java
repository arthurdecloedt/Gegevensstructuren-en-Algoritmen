package sort;


import java.math.BigInteger;

import static sort.SortUsefull.Exch;

public class InsertionSort {


    public void sort(Comparable[] array){
        this.count=BigInteger.ZERO;
        if (array==null) throw new IllegalArgumentException();
        if (array.length<2)return;
        int len=array.length;
        for (int loc = 1; loc <len; loc++) {
            for (int loc2 = loc; loc2 >=1 ; --loc2) {
                if (less(array[loc2],array[loc2-1])){
                    Exch(array,loc2,loc2-1);
                }
                else break;
            }
        }
    }

    public BigInteger count;
    public boolean less(Comparable comp1,Comparable comp2){
        this.count=this.count.add(BigInteger.ONE);
        if (this.count.remainder(BigInteger.valueOf(1000000)).equals(BigInteger.ZERO)) System.out.println(count.toString());
        return SortUsefull.less(comp1,comp2);
    }


}
