package benchmarks;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.util.VMSupport;

public class HelloWorldBenchmark {

    public static class Padding01 {
        long l01, l02, l03, l04, l05, l06, l07, l08;
    }

    public static class VarA extends Padding01 {
        volatile int a;
    }

    public static class Padding02 extends VarA {
        long l09, l10, l11, l12, l13, l14, l15, l16;
    }

    public static class VarB extends Padding02 {
        volatile int b;
    }

    public static class Padding03 extends VarB {
        long l17, l18, l19, l20, l21, l22, l23, l24;
    }

    @State(Scope.Group)
    public static class Vars extends Padding03 {

        @Setup
        public void setup() {
            System.out.println(VMSupport.vmDetails());
            System.out.println(ClassLayout.parseClass(Vars.class).toPrintable());
        }
    }

    @GenerateMicroBenchmark
    @Group("a")
    public void writerA(Vars vars) {
        vars.a++;
    }

    @GenerateMicroBenchmark
    @Group("a")
    public void writerB(Vars vars) {
        vars.b++;
    }
}
