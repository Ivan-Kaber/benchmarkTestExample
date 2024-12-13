package backend.academy.benchmark;

import lombok.experimental.UtilityClass;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class Main {
    private static final int forks = 2;
    private static final int warmupForks = 1;
    private static final int warmupIterations = 3;
    private static final int warmupTimeSeconds = 5;
    private static final int measurementIterations = 5;
    private static final int measurementTimeSeconds = 4;

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
            .include(BenchmarkRunner.class.getSimpleName())
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .forks(forks)
            .warmupForks(warmupForks)
            .warmupIterations(warmupIterations)
            .warmupTime(TimeValue.seconds(warmupTimeSeconds))
            .measurementIterations(measurementIterations)
            .measurementTime(TimeValue.seconds(measurementTimeSeconds))
            .build();

        new Runner(options).run();
    }
}
