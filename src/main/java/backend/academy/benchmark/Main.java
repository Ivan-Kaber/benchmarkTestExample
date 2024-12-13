package backend.academy.benchmark;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
            .include(BenchmarkRunner.class.getSimpleName())
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .forks(2)
            .warmupForks(1)
            .warmupIterations(3)
            .warmupTime(TimeValue.seconds(5))
            .measurementIterations(5)
            .measurementTime(TimeValue.seconds(4))
            .build();

        new Runner(options).run();
    }
}
