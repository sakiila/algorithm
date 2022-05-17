package me.bob.interview.moego;

import java.util.*;
import java.util.concurrent.*;

/**
 * Q1: 实现一个加权随机算法
 * <p>
 * 给定一个长度为 N (< 10000) 的正整数(< 100)数组,
 * 调用 next() 返回任意一个该数组的下标, 即 [0, N)
 * 区间内的整数, 下标 i 被返回的概率为 数组的第 i 个
 * 元素的值 / 数组所有元素之和.
 * <p>
 * 要求: 空间复杂度不限, next() 方法的时间复杂度最优
 * <p>
 * 例: 给定一个数组 {4, 1, 3, 2}, 则 next() 函数可
 * 返回 0, 1, 2, 3 中的任意一个数字, 对应被返回的概率
 * 为 4/10, 1/10, 3/10, 2/10.
 */

class WeightedRand_V1 {

    List<Integer> list;
    Map<Integer, Integer> map;

    public WeightedRand_V1(int[] input) {
        // show me your code
        list = new ArrayList<>();
        map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            map.put(input[i], i);
            // 假设num为4，则存放4个4到list中
            for (int j = 0; j < input[i]; j++) {
                list.add(input[i]);
            }
        }
    }

    /**
     * 整体空间复杂度：O(n^2)
     * next 方法时间复杂度：O(1)
     */
    public int next() {
        // show me your code, please delete the next line
        Random rand = new Random();
        return map.get(list.get(rand.nextInt(list.size())));
    }
}

/**
 * Q2: 题目同上, 要求: 空间复杂度最优的前提下, 尽可能降低 next() 方法的时间复杂度
 */
class WeightedRand_V2 {

    int sum;
    int[] array;

    public WeightedRand_V2(int[] input) {
        // show me your code
        sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }
        this.array = input;
    }

    /**
     * 整体空间复杂度：O(n)
     * next 方法时间复杂度：O(n)
     * 更进一步：使用前缀数组，提前计算，时间复杂度为 O(1)
     */
    public int next() {
        // show me your code, please delete the next line
        Random rand = new Random();
        int target = rand.nextInt(sum);

        int carry = 0;
        for (int i = 0; i < array.length; i++) {
            carry += array[i];
            if (target < carry) {
                return i;
            }
        }

        return 0;
    }
}


/**
 * Q3: 实现一个简单的多任务执行器, 其最多可以同时执行 capacity 个任务
 * <p>
 * 注意: 不可使用 JDK 提供的线程池相关接口.
 */
class ParallelTaskExecutor {

    // 任务队列
    private BlockingQueue<FutureTask> queue;

    // 线程池
    private Queue<Worker> workerQueue;

    private volatile boolean isShutdown = false;

    /**
     * @param capacity 最多可同时执行的任务个数
     */
    public ParallelTaskExecutor(int capacity) {
        // show me your code here
        this.queue = new ArrayBlockingQueue<>(100);
        this.workerQueue = new ArrayDeque<>();

        for (int i = 0; i < capacity; i++) {
            Worker worker = new Worker();
            workerQueue.add(worker);

//            new Thread(worker).start();
            worker.start();
        }
    }

    /**
     * 异步执行任务, 返回 Future 对象
     *
     * @param callable 要执行的任务
     * @param <T>      任务的返回值类型
     * @return 返回一个 Future, 任务执行完成时其状态变更为 Done.
     */
    public <T> Future<T> submit(Callable<T> callable) {
        // show me your code here, please delete the following line.
        FutureTask futureTask = new FutureTask(callable);
        try {
            queue.put(futureTask);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return futureTask;
    }

    public void shutdown() {
        isShutdown = true;
        for (Worker worker : workerQueue) {
            worker.interrupt();
        }
    }

    class Worker extends Thread {
        @Override
        public void run() {
            while (!isShutdown) {
                try {
                    queue.poll(1, TimeUnit.SECONDS).run();
                } catch (Exception e) {
                    break;
                }
            }
        }
    }

}


// 下面是测试代码
public class ShowMeBug {
    public static void main(String[] args) {
        try {
            System.out.println("Testing Q1...");
            testWeightedRand_V1();
            System.out.println("PASSED!");
        } catch (Exception e) {
            System.out.println("FAILED: " + e.toString());
        }
        try {
            System.out.println("Testing Q2...");
            testWeightedRand_V2();
            System.out.println("PASSED!");
        } catch (Exception e) {
            System.out.println("FAILED: " + e.toString());
        }
        try {
            System.out.println("Testing Q3...");
            testParallelTaskExecutor();
            System.out.println("PASSED!");
        } catch (Exception e) {
            System.out.println("FAILED: " + e.toString());
        }
    }

    private static void testWeightedRand_V1() throws Exception {
        int[] input = {4, 1, 3, 2};
        WeightedRand_V1 rand = new WeightedRand_V1(input);
        int[] result = new int[input.length];
        int runCount = 1000 * input.length;
        for (int i = 0; i < runCount; i++) {
            int next = rand.next();
            if (next < 0 || next > input.length) {
                throw new Exception("unexpected rand value: " + next);
            }
            result[next]++;
        }

        int sum = 0;
        for (int j : input) {
            sum += j;
        }

        for (int i = 0; i < input.length; i++) {
            double realP = result[i] / (double) runCount;
            double expectedP = input[i] / (double) sum;
            if (realP - expectedP > 0.1 || realP - expectedP < -0.1) {
                throw new Exception("unexpected probability " + realP + " for value " + i + ", expected is " + expectedP);
            }
        }
    }


    private static void testWeightedRand_V2() throws Exception {
        int[] input = {4, 1, 3, 2};
        WeightedRand_V2 rand = new WeightedRand_V2(input);
        int[] result = new int[input.length];
        int runCount = 1000 * input.length;
        for (int i = 0; i < runCount; i++) {
            int next = rand.next();
            if (next < 0 || next > input.length) {
                throw new Exception("unexpected rand value: " + next);
            }
            result[next]++;
        }

        int sum = 0;
        for (int j : input) {
            sum += j;
        }

        for (int i = 0; i < input.length; i++) {
            double realP = result[i] / (double) runCount;
            double expectedP = input[i] / (double) sum;
            if (realP - expectedP > 0.1 || realP - expectedP < -0.1) {
                throw new Exception("unexpected probability " + realP + " for value " + i + ", expected is " + expectedP);
            }
        }
    }


    /**
     * 系统开始执行时间
     */
    private static long startTime;

    /**
     * 创建一个虚拟的任务
     *
     * @param wait        指定任务耗时, 毫秒
     * @param shouldThrow 指定任务是否抛出异常, 如果为 true, 任务将抛出一个 Exception
     * @return 返回一个虚拟任务, 在开始执行后大约 wait 毫秒后执行完毕
     */
    private static Callable<Integer> createCallable(long wait, boolean shouldThrow) {
        return () -> {
            Thread.sleep(wait);
            long costTime = (System.currentTimeMillis() - startTime);
            // 以 100 为单位向下取整, 屏蔽精度对结果的影响.
            long expectedCostTime = costTime - (costTime % 100);
            if (shouldThrow) {
                throw new Exception(Long.toString(expectedCostTime));
            }
            return (int) expectedCostTime;
        };
    }

    private static void testParallelTaskExecutor() throws Exception {
        ParallelTaskExecutor pool = new ParallelTaskExecutor(2);

        List<String> expectedResults = Arrays.asList("RETURN: 100", "RETURN: 200", "THROW: java.lang.Exception: 300", "RETURN: 400", "RETURN: 600", "RETURN: 700");

        List<String> actualResults = new ArrayList<>();

        startTime = System.currentTimeMillis();
        List<Future<Integer>> futureList = new ArrayList<>();
        futureList.add(pool.submit(createCallable(101, false)));
        futureList.add(pool.submit(createCallable(202, false)));
        futureList.add(pool.submit(createCallable(203, true)));
        futureList.add(pool.submit(createCallable(204, false)));
        futureList.add(pool.submit(createCallable(305, false)));

        for (Future<Integer> future : futureList) {
            try {
                Integer v = future.get();
                actualResults.add("RETURN: " + v.toString());
            } catch (Exception e) {
                actualResults.add("THROW: " + e.getMessage());
            }
        }

        Future<Integer> anotherTask = pool.submit(createCallable(106, false));
        try {
            actualResults.add("RETURN: " + anotherTask.get().toString());
        } catch (Exception e) {
            actualResults.add("THROW: " + e.getMessage());
        }

        for (int i = 0; i < expectedResults.size(); i++) {
            if (!expectedResults.get(i).equals(actualResults.get(i))) {
                throw new Exception(String.format("Unexpected \"%s\" for task %d, expected is \"%s\"", actualResults.get(i), i, expectedResults.get(i)));
            }
        }

        pool.shutdown();
    }
}


