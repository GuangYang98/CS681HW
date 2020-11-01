package edu.umb.cs681.hw05;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {

    public RunnablePrimeGenerator(long from, long to) {
        super(from, to);
    }

    public void run() {
        generatePrimes();
    }

    public static void main(String[] args) {

        //one thread
        RunnablePrimeGenerator g = new RunnablePrimeGenerator(1L, 2000000L);
        Thread t = new Thread(g);
        long startTime = System.currentTimeMillis();
        t.start();
        try{
            t.join();
        }catch (InterruptedException e){}
        long endTime = System.currentTimeMillis();
        float time = endTime-startTime;
        g.getPrimes().forEach((prime) -> System.out.print(prime + ","));
        System.out.println("Found " + g.getPrimes().size() + " numbers.");
        System.out.println("one thread time: "+ time/1000 + "seconds");


        //2 threads
        RunnablePrimeGenerator g21 = new RunnablePrimeGenerator(1L, 1000000L);
        RunnablePrimeGenerator g22 = new RunnablePrimeGenerator(1000000L, 2000000L);
        Thread t1 = new Thread(g21);
        Thread t2 = new Thread(g22);
        long startTime2 = System.currentTimeMillis();
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){}
        long endTime2 = System.currentTimeMillis();
        float time2 = endTime2-startTime2;
        //g.getPrimes().forEach((prime) -> System.out.print(prime + ","));
        System.out.println("Found " + g.getPrimes().size() + " numbers.");
        System.out.println("2 thread time: "+ time2/1000 + "seconds");


        //4 threads
        RunnablePrimeGenerator g41 = new RunnablePrimeGenerator(1L, 500000L);
        RunnablePrimeGenerator g42 = new RunnablePrimeGenerator(500000L, 1000000L);
        RunnablePrimeGenerator g43 = new RunnablePrimeGenerator(1000000L, 1500000L);
        RunnablePrimeGenerator g44 = new RunnablePrimeGenerator(1500000L, 2000000L);
        Thread t41 = new Thread(g41);
        Thread t42 = new Thread(g42);
        Thread t43 = new Thread(g43);
        Thread t44 = new Thread(g44);
        long startTime4 = System.currentTimeMillis();
        t41.start();
        t42.start();
        t43.start();
        t44.start();
        try{
            t41.join();
            t42.join();
            t43.join();
            t44.join();
        }catch (InterruptedException e){}
        long endTime4 = System.currentTimeMillis();
        float time4 = endTime4-startTime4;
        //g.getPrimes().forEach((prime) -> System.out.print(prime + ","));
        System.out.println("Found " + g.getPrimes().size() + " numbers.");
        System.out.println("4 threads time: "+ time4/1000 + "seconds");


        //8 threads
        RunnablePrimeGenerator g81 = new RunnablePrimeGenerator(1L, 250000L);
        RunnablePrimeGenerator g82 = new RunnablePrimeGenerator(250000L, 500000L);
        RunnablePrimeGenerator g83 = new RunnablePrimeGenerator(500000L, 750000L);
        RunnablePrimeGenerator g84 = new RunnablePrimeGenerator(750000L, 1000000L);
        RunnablePrimeGenerator g85 = new RunnablePrimeGenerator(1000000L, 1250000L);
        RunnablePrimeGenerator g86 = new RunnablePrimeGenerator(1250000L, 1500000L);
        RunnablePrimeGenerator g87 = new RunnablePrimeGenerator(1500000L, 1750000L);
        RunnablePrimeGenerator g88 = new RunnablePrimeGenerator(1750000L, 2000000L);
        Thread t81 = new Thread(g81);
        Thread t82 = new Thread(g82);
        Thread t83 = new Thread(g83);
        Thread t84 = new Thread(g84);
        Thread t85 = new Thread(g85);
        Thread t86 = new Thread(g86);
        Thread t87 = new Thread(g87);
        Thread t88 = new Thread(g88);
        long startTime8 = System.currentTimeMillis();
        t81.start();
        t82.start();
        t83.start();
        t84.start();
        t85.start();
        t86.start();
        t87.start();
        t88.start();
        try{
            t81.join();
            t82.join();
            t83.join();
            t84.join();
            t85.join();
            t86.join();
            t87.join();
            t88.join();
        }catch (InterruptedException e){}
        long endTime8 = System.currentTimeMillis();
        float time8 = endTime8-startTime8;
        //g.getPrimes().forEach((prime) -> System.out.print(prime + ","));
        System.out.println("Found " + g.getPrimes().size() + " numbers.");
        System.out.println("8 threads time: "+ time8/1000 + "seconds");


        //16 threads
        RunnablePrimeGenerator g161 = new RunnablePrimeGenerator(1L, 125000L);
        RunnablePrimeGenerator g162 = new RunnablePrimeGenerator(125000L, 250000L);
        RunnablePrimeGenerator g163 = new RunnablePrimeGenerator(250000L, 375000L);
        RunnablePrimeGenerator g164 = new RunnablePrimeGenerator(375000L, 500000L);
        RunnablePrimeGenerator g165 = new RunnablePrimeGenerator(500000L, 675000L);
        RunnablePrimeGenerator g166 = new RunnablePrimeGenerator(675000L, 750000L);
        RunnablePrimeGenerator g167 = new RunnablePrimeGenerator(750000L, 875000L);
        RunnablePrimeGenerator g168 = new RunnablePrimeGenerator(875000L, 1000000L);
        RunnablePrimeGenerator g169 = new RunnablePrimeGenerator(1000000L, 1125000L);
        RunnablePrimeGenerator g1610 = new RunnablePrimeGenerator(1125000L, 1250000L);
        RunnablePrimeGenerator g1611 = new RunnablePrimeGenerator(1250000L, 1375000L);
        RunnablePrimeGenerator g1612 = new RunnablePrimeGenerator(1375000L, 1500000L);
        RunnablePrimeGenerator g1613 = new RunnablePrimeGenerator(1500000L, 1675000L);
        RunnablePrimeGenerator g1614 = new RunnablePrimeGenerator(1675000L, 1750000L);
        RunnablePrimeGenerator g1615 = new RunnablePrimeGenerator(1750000L, 1875000L);
        RunnablePrimeGenerator g1616 = new RunnablePrimeGenerator(1875000L, 2000000L);
        Thread t161 = new Thread(g161);
        Thread t162 = new Thread(g162);
        Thread t163 = new Thread(g163);
        Thread t164 = new Thread(g164);
        Thread t165 = new Thread(g165);
        Thread t166 = new Thread(g166);
        Thread t167 = new Thread(g167);
        Thread t168 = new Thread(g168);
        Thread t169 = new Thread(g169);
        Thread t1610 = new Thread(g1610);
        Thread t1611 = new Thread(g1611);
        Thread t1612 = new Thread(g1612);
        Thread t1613 = new Thread(g1613);
        Thread t1614 = new Thread(g1614);
        Thread t1615 = new Thread(g1615);
        Thread t1616 = new Thread(g1616);
        long startTime16 = System.currentTimeMillis();
        t161.start();
        t162.start();
        t163.start();
        t164.start();
        t165.start();
        t166.start();
        t167.start();
        t168.start();
        t169.start();
        t1610.start();
        t1611.start();
        t1612.start();
        t1613.start();
        t1614.start();
        t1615.start();
        t1616.start();
        try{
            t161.join();
            t162.join();
            t163.join();
            t164.join();
            t165.join();
            t166.join();
            t167.join();
            t168.join();
            t169.join();
            t1610.join();
            t1611.join();
            t1612.join();
            t1613.join();
            t1614.join();
            t1615.join();
            t1616.join();
        }catch (InterruptedException e){}
        long endTime16 = System.currentTimeMillis();
        float time16 = endTime16-startTime16;
        //g.getPrimes().forEach((prime) -> System.out.print(prime + ","));
        System.out.println("Found " + g.getPrimes().size() + " numbers.");
        System.out.println("16 threads time: "+ time16/1000 +"seconds");

    }

}
