package Homework5;

public class HeapSort {
    public static void HeapS(Integer[] a, int l) {
        if(l<=0)
            return;

        for (int i = l/2-1; i >=0 ; i--) {

            int index=a[2*i+1]>a[2*i+2]?2*i+1:2*i+2;
            if(a[index]>a[i]){
                int temp=a[index];
                a[index]=a[i];
                a[i]=temp;
            }

        }
        int temp=a[l];
        a[l]=a[0];
        a[0]=temp;

        HeapS(a,l-1);
    }
}
