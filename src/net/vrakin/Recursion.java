package net.vrakin;

public class Recursion implements ProviderMethod{
    @Override
    public Long method(int test) {
            if (test < 2) return 1L;
            else return method(test - 1) + method(test - 2);
        }
}
