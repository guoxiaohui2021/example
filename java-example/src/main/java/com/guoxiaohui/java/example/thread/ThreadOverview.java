package com.guoxiaohui.java.example.thread;

/**
 * 面向线程设计的系统中，操作系统能调度的最小单元。
 * Java线程
 * ·Green Thread 绿色线程 @since 1.2    Java1.2之前的Java Thread实现，模拟多线程并发
 * ·Native OS Thread 原生OS线程 @since > 1.2    基于OS线程实现，数量映射 1：1
 * <p>
 * Java Thread Programming Model Java线程编程模型
 * <Java 5 ： {@link Thread}，{@link Runnable}
 * Java 5 ： {@link java.util.concurrent.Executor}/{@link java.util.concurrent.Future}/{@link java.util.concurrent.Callable}
 * Java 7 ： {@link java.util.concurrent.ForkJoinPool}
 * Java 8 ： {{@link java.util.concurrent.CompletionStage},{@link java.util.concurrent.CompletableFuture}
 * Java 9 : {@link java.util.concurrent.Flow}
 * <p>
 * Java Thread Pool
 * < Java 5 ： 自定义ThreadPool
 * Java 5+ ：{@link java.util.concurrent.ExecutorService}
 * {@link java.util.concurrent.ThreadPoolExecutor}
 * {@link java.util.concurrent.ScheduledThreadPoolExecutor}
 * Java 7+ : {@link java.util.concurrent.ForkJoinPool}
 * <p>
 * Java Concurrent Framework    Java并发框架
 * Java 5 ：JUC
 * Java 6 ：Fork/Join
 * Java 7 ：CompletableFuture,RxJava,Reactor
 * Java 8 ：FlowAPI,Reactive Streams
 * <p>
 * 同步：任务发起方和任务执行方在同一个线程中完成
 * 异步：提升吞吐的手段，任务发起方和任务执行方在不同的线程中完成。 异步可能会更慢：IO密集/CPU密集型可能会发送堵塞
 * 非阻塞：一种编程模型，由通知状态被动的回调执行，同步或异步执行均可
 * <p>
 * Java Thread State    {@link java.lang.Thread.State} @since 1.5
 * NEW：线程已创建，尚未启动
 * RUNNABLE：线程处于可运行状态，不代表一定执行
 * BLOCKED：线程被monitor锁阻塞，表示线程在同步锁的场景运行
 * WAITING：线程处于等待状态，Object.wait ，Thread.join ，LockSupport.park
 * TIMED_WAITING：Thread.sleep，Object.wait ，Thread.join，LockSupport.parkNanos，LockSupport.parkUntil
 * TERMINATED：终止
 * <p>
 * POSIX线程
 *
 * @author guoxiaohui
 */
public class ThreadOverview {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(ThreadOverview::method);
        thread.start();
//        thread.join();
    }

    private static void method() {
        System.out.println("Thread Id" + Thread.currentThread().getId());
    }

}
