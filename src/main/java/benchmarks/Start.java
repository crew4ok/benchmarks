package benchmarks;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.VerboseMode;

public class Start {
    public static void main(String[] args) throws Exception {
        new Runner(
                new OptionsBuilder()
                        .include(".*" + PrintingBenchmark.class.getSimpleName() + ".*")
                        .forks(1)
                        .verbosity(VerboseMode.NORMAL)
                        .build()
        ).run();
    }
}
