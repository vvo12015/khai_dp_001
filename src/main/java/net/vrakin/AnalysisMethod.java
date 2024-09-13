package net.vrakin;


import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class AnalysisMethod {

    final static Logger logger = LoggerFactory.getLogger(AnalysisMethod.class);
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
        logger.info("Test of {} starting", nameMethod);

        for (Map.Entry<Integer, Double> testTime : testTimes.entrySet()) {
            List<Double> times = new ArrayList<>();
            testTime.setValue(0D);

            for (int i = 0; i < TRIAL_NUMBER; i++) {
                long m = System.currentTimeMillis();
                resultTimes.put(testTime.getKey(), providerMethod.method(testTime.getKey()));
                double currentTime = (double) (System.currentTimeMillis() - m);
                times.add(currentTime);
                logger.info("time{} for number {} - {}", i, testTime.getKey(), currentTime);
            }
            testTimes.put(testTime.getKey(), times.stream().reduce(testTime.getValue(), Double::sum) / TRIAL_NUMBER);
            logger.info("Test: {}, Result: {}, time: {}", testTime.getKey(),
                    resultTimes.get(testTime.getKey()), testTimes.get(testTime.getKey()));
        }

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
