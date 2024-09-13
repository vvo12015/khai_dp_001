package net.vrakin;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    final static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Map<Integer, Double> testTimes = new HashMap<Integer, Double>();
        testTimes.put(10, 0D);
        testTimes.put(30, 0D);
        testTimes.put(50, 0D);

        AnalysisMethod analysisMethodRecursion = new AnalysisMethod("Recursion", testTimes, new Recursion());
        testTimes.put(70, 0D);
        testTimes.put(100, 0D);
        AnalysisMethod analysisMethodImprovedRecursion = new AnalysisMethod("ImprovedRecursion", testTimes, new ImprovedRecursion());
        AnalysisMethod analysisMethodDynamicProgram = new AnalysisMethod("DynamicProgram", testTimes, new DynamicProgram());

        logger.info("Start testing...");
        analysisMethodRecursion.analysisMethod();
        logger.info(analysisMethodRecursion.toString());

        analysisMethodImprovedRecursion.analysisMethod();
        logger.info(analysisMethodImprovedRecursion.toString());

        analysisMethodDynamicProgram.analysisMethod();
        logger.info(analysisMethodDynamicProgram.toString());

    }



}