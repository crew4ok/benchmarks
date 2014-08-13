package benchmarks;

import org.openjdk.jmh.annotations.*;

@BenchmarkMode(Mode.Throughput)
public class HierarchyInlining {

    public static class Parent {
        protected static double x = Math.PI;

        public double method() {
            return x;
        }
    }

    public static class Child1 extends Parent {
        @Override
        public double method() {
            return x;
        }
    }

    public static class Child2 extends Parent {
        @Override
        public double method() {
            return x;
        }
    }

    public static class Child3 extends Parent {
        @Override
        public double method() {
            return x;
        }
    }

    @State(Scope.Thread)
    public static class AwesomeState {
        Parent p = new Parent();
        Parent c1 = new Child1();
        Parent c2 = new Child2();
        Parent c3 = new Child3();
    }

    @GenerateMicroBenchmark
    public double parentCall(AwesomeState awesomeState) {
        return awesomeState.p.method();
    }

    @GenerateMicroBenchmark
    public double child1Call(AwesomeState awesomeState) {
        return awesomeState.c1.method();
    }

    @GenerateMicroBenchmark
    public double child2Call(AwesomeState awesomeState) {
        return awesomeState.c2.method();
    }

    @GenerateMicroBenchmark
    public double child3Call(AwesomeState awesomeState) {
        return awesomeState.c3.method();
    }
}
