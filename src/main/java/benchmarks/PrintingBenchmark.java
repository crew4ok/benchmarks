package benchmarks;

import org.openjdk.jmh.annotations.Benchmark;

public class PrintingBenchmark {

    @Benchmark
    public void printHash() {
        System.out.print("#");
    }

    @Benchmark
    public void printB() {
        System.out.print("B");
    }
}
