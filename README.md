# Конфигурация:
```
Options options = new OptionsBuilder()
.include(BenchmarkRunner.class.getSimpleName())
.shouldFailOnError(true)
.shouldDoGC(true)
.mode(Mode.AverageTime)
.timeUnit(TimeUnit.NANOSECONDS)
.forks(3)
.warmupForks(1)
.warmupIterations(5)
.warmupTime(TimeValue.seconds(10))
.measurementIterations(10)
.measurementTime(TimeValue.seconds(7))
.build();
```

# Результаты тестирования:
| Benchmark                         | Mode | Cnt | Score          | Units |
|-----------------------------------| --- | --- |----------------|--- |
| BenchmarkRunner.directAccess      | avgt | 30 | 0,640 +- 0,011 | ns/op
| BenchmarkRunner.lambdaMetafactory | avgt | 30 | 0,890 +- 0,003 | ns/op
| BenchmarkRunner.methodHandles     | avgt | 30 | 3,931 +- 0,009 | ns/op
| BenchmarkRunner.reflection        | avgt | 30 | 8,553 +- 0,404 | ns/op
0
00000000000000000000000
0
0
0
0
0
00
0
0

