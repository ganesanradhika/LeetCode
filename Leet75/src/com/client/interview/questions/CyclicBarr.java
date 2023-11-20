package com.client.interview.questions;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarr {


        public static void main(String[] args) {

            // number of threads that need to synchronize
            int n = 4;

            CyclicBarrier barrier = new CyclicBarrier(n);

            Runnable printNNumbers = new Runnable() {

                @Override
                public void run() {
                    for (int i = 1; i <= 5; i++) {
                        System.out.print(i);
                        try {
                            barrier.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } catch (BrokenBarrierException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            };

            for (int i = 1; i <= n; i++) {
                Thread t = new Thread(printNNumbers);
                t.start();
            }

        }
    }