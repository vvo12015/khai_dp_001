package net.vrakin;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AnalysisMethod {
    public static final int TRIAL_NUMBER = 10;
    private String nameMethod;
    private Map<Integer, Double> testTimes;
    private Map<Integer, Long> resultTimes;

    private ProviderMethod providerMethod;

    public AnalysisMethod(String nameMethod, Map<Integer, Double> testTimes, ProviderMethod providerMethod) {
        this.nameMethod = nameMethod;
        this.testTimes = testTimes;
        this.providerMethod = providerMethod;
        resultTimes = new HashMap<Integer, Long>();
        for(Map.Entry<Integer, Double> entry : testTimes.entrySet()){
            resultTimes.put(entry.getKey(), 0L);
        }
    }

    public void analysisMethod(){
        for (Map.Entry<Integer, Double> testTime : testTimes.entrySet()) {
            List<Double> times = new ArrayList<>();
            testTime.setValue(0D);
            for (int i = 0; i < TRIAL_NUMBER; i++) {
                long m = System.currentTimeMillis();
                resultTimes.put(testTime.getKey(), providerMethod.method(testTime.getKey()));
                times.add((double) (System.currentTimeMillis() - m));
            }
            testTimes.put(testTime.getKey(), times.stream().reduce(testTime.getValue(), Double::sum) / TRIAL_NUMBER);
        }

    }

    public String getNameMethod() {
        return nameMethod;
    }

    public void setNameMethod(String nameMethod) {
        this.nameMethod = nameMethod;
    }

    public ProviderMethod getProviderMethod() {
        return providerMethod;
    }

    public void setProviderMethod(ProviderMethod providerMethod) {
        this.providerMethod = providerMethod;
    }

    public Map<Integer, Double> getTestTimes() {
        return testTimes;
    }

    public void setTestTimes(Map<Integer, Double> testTimes) {
        this.testTimes = testTimes;
    }

    @Override
    public String toString() {
        return "AnalysisMethod{" +
                "nameMethod='" + nameMethod + '\'' +
                ", resultTimes=" + resultTimes +
                ", testTimes=" + testTimes +
                '}';
    }
}
