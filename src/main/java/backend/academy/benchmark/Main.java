package backend.academy.benchmark;

import java.util.concurrent.TimeUnit;
import lombok.experimental.UtilityClass;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@UtilityClass
public class Main {
    private static final int FORKS = 2;
    private static final int WARMUP_FORKS = 1;
    private static final int WARMUP_ITERATIONS = 3;
    private static final int WARMUP_TIME_SECONDS = 5;
    private static final int MEASUREMENT_ITERATIONS = 5;
    private static final int MEASUREMENT_TIME_SECONDS = 4;

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
            .include(BenchmarkRunner.class.getSimpleName())
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .forks(FORKS)
            .warmupForks(WARMUP_FORKS)
            .warmupIterations(WARMUP_ITERATIONS)
            .warmupTime(TimeValue.seconds(WARMUP_TIME_SECONDS))
            .measurementIterations(MEASUREMENT_ITERATIONS)
            .measurementTime(TimeValue.seconds(MEASUREMENT_TIME_SECONDS))
            .build();

        new Runner(options).run();
    }
}
