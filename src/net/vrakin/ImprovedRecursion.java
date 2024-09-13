package net.vrakin;

public class ImprovedRecursion implements ProviderMethod{
    @Override
    public Long method(int test) {
        Long[] a = new Long[test+1];
        if (a[test] == 0) {
            if ((test == 0) || (test == 1)) a[test] = 1L;
        }else {
            a [test] = method(test - 1) + method (test - 2);
        }
        return a[test];
    }
}
