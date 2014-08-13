package benchmarks;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;

import java.util.Random;

public class PrintingBenchmark {

    @GenerateMicroBenchmark
    public void printHash() {
        System.out.print("#");
    }

    @GenerateMicroBenchmark
    public void printB() {
        System.out.print("B");
    }
}
