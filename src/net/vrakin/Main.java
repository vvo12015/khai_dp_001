package net.vrakin;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Map<Integer, Double> testTimes = new HashMap<Integer, Double>();
        testTimes.put(10, 0D);
        testTimes.put(30, 0D);
        testTimes.put(50, 0D);
        testTimes.put(70, 0D);
        testTimes.put(100, 0D);

        AnalysisMethod analysisMethodRecursion = new AnalysisMethod("Recursion", testTimes, new Recursion());
        AnalysisMethod analysisMethodImprovedRecursion = new AnalysisMethod("ImprovedRecursion", testTimes, new ImprovedRecursion());
        AnalysisMethod analysisMethodDynamicProgram = new AnalysisMethod("DynamicProgram", testTimes, new DynamicProgram());

        analysisMethodRecursion.analysisMethod();
        System.out.println(analysisMethodRecursion);

        analysisMethodImprovedRecursion.analysisMethod();
        System.out.println(analysisMethodImprovedRecursion);

        analysisMethodDynamicProgram.analysisMethod();
        System.out.println(analysisMethodDynamicProgram);

    }



}