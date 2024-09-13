package net.vrakin;

public class DynamicProgram implements ProviderMethod{
    @Override
    public Long method(int test) {
        Long[] f = new Long[test];
        f[0] = 1L;
        f[1] = 1L;
        for (int i = 2; i < test; i++) f[i] = f[i - 1] + f[i - 2];
        return f[test - 1];
    }
}
