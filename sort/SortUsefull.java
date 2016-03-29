package sort;

public class SortUsefull {

    public static boolean less(Comparable comp1,Comparable comp2){
        return (comp1.compareTo( comp2)<0);
    }
    public static void Exch(Comparable[] array,int one,int two){
        Comparable temp=array[one];
        array[one]=array[two];
        array[two]=temp;
    }
}
