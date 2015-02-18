package net.crew4ok;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SieveBenchmark {

    private static class Sieve {
        public static void calculateSieve(List<Integer> baseList) {
            int pos = 0;
            int length = baseList.size();
            while (pos < length) {
                int num = baseList.get(pos);

                Iterator<Integer> sievingIter = baseList.iterator();
                while (sievingIter.hasNext()) {
                    int el = sievingIter.next();
                    if (el % num == 0) {
                        sievingIter.remove();
                    }
                }
            }

        }
    }

    private static final int size = 65535;

    @State(value = Scope.Benchmark)
    public static class LinkedListState {

        private List<Integer> list;

        @Setup(Level.Invocation)
        public void setup() {
            list = new LinkedList<Integer>();

            for (int i = 2; i < size; i++) {
                list.add(i);
            }
        }

    }

    @State(value = Scope.Benchmark)
    public static class ArrayListState {

        private List<Integer> list;

        @Setup(Level.Invocation)
        public void setup() {
            list = new ArrayList<Integer>(size);

            for (int i = 2; i < size; i++) {
                list.add(i);
            }
        }
    }

    @Benchmark
    public void calculateWithLinkedList(LinkedListState state, Blackhole bh) {
        Sieve.calculateSieve(state.list);
        bh.consume(state.list);
    }

    @Benchmark
    public void calculateWithArrayList(ArrayListState state, Blackhole bh) {
        Sieve.calculateSieve(state.list);
        bh.consume(state.list);
    }
}
