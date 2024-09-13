package net.vrakin;

public class ImprovedRecursion implements ProviderMethod{
    @Override
    public Long method(int test) {
        long[] a = new long[test+1];
        if (a[test]==0){
            if (test <= 2) return 1L;
            else return method(test - 1) + method(test - 2);
        }
        else return a[test];
    }
}
