package me.bob.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Test {

    private static Integer test() {
        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // 创建 CompletionService
        CompletionService<Integer> cs = new ExecutorCompletionService<>(executor);
        // 用于保存 Future 对象
        List<Future<Integer>> futures = new ArrayList<>(3);
        // 提交异步任务，并保存 future 到 futures 
        futures.add(cs.submit(() -> 1));
        futures.add(cs.submit(() -> 2));
        futures.add(cs.submit(() -> 3));

        List<CompletableFuture> list = new ArrayList<>();
        list.add(CompletableFuture.runAsync(() -> 1).)


        // 获取最快返回的任务执行结果
        Integer r = 0;
        try {
            // 只要有一个成功返回，则 break
            for (int i = 0; i < 3; ++i) {
                r = cs.take().get();
                // 简单地通过判空来检查是否成功返回
                if (r != null) {
                    break;
                }
            }
        } catch (Exception e) {
            
        } finally {
            // 取消所有任务
            for (Future<Integer> f : futures) {
                f.cancel(true);
            }
            executor.shutdown();
        }
        // 返回结果
        return r;
    }

    public static void main(String[] args) {
        System.out.println("test() = " + test());
    }
}
