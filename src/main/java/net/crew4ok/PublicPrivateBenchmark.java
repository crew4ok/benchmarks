package net.crew4ok;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;

@Fork(1)
public class PublicPrivateBenchmark {
    static final Inner inner = new Inner();

    static class Inner {
        int x = 1;

        int getX1() { return x; }
        int getX2() { return getX1(); }
        int getX3() { return getX2(); }
        int getX4() { return getX3(); }
        int getX5() { return getX4(); }
        int getX6() { return getX5(); }
        int getX7() { return getX6(); }
        int getX8() { return getX7(); }
        int getX9() { return getX8(); }

        private int getPrivate() { return getX9(); }
        public int getPublic()   { return getX9(); }
    }

    @Benchmark
    public int testGetPrivate() {
        return inner.getPrivate();
    }

    @Benchmark
    public int testGetPublic() {
        return inner.getPublic();
    }

}
