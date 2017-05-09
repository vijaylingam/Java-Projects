/**
 * Created by vijaychandra on 5/2/16.
 */
    class MyThread extends java.lang.Thread {
        int tid;

        public MyThread(String name, int tid) {
            super(name);
            this.tid = tid;
        }

        @Override
        public void run() {
            Thread t = Thread.currentThread();
            if (tid == 0) {
                try {
                    t.sleep(100);
                }
                catch (Exception f){
                    System.out.println(f);
                }
            } else {
                for (int j = 10; j > 1; j--) {
                    try {
                        if (tid + 1 == j) {
                            //t.join();
                            t.sleep((10 - j) + 1);
                            //System.out.println(tid);
                        }

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

            }
            System.out.println(getName());
        }
    }

    class Threading {
        static MyThread[] threads = new MyThread[10];

        public static void main(String args[]) throws InterruptedException {
            for (int i = 9; i >= 0; i--) {
                threads[i] = new MyThread("thread " + i, i);
                threads[i].start();
            }

            /* for testing purpose (10 different threads with random tid number)
            threads[5] = new MyThread("thread " + 5, 5);
            threads[5].start();
            threads[3] = new MyThread("thread " + 3, 3);
            threads[3].start();
            threads[7] = new MyThread("thread " + 7, 7);
            threads[7].start();
            threads[4] = new MyThread("thread " + 4, 4);
            threads[4].start();
            threads[1] = new MyThread("thread " + 1, 1);
            threads[1].start();
            threads[2] = new MyThread("thread " + 2, 2);
            threads[2].start();
            threads[8] = new MyThread("thread " + 8, 8);
            threads[8].start();
            threads[6] = new MyThread("thread " + 6, 6);
            threads[6].start();
            threads[0] = new MyThread("thread " + 0, 0);
            threads[0].start();
            threads[9] = new MyThread("thread " + 9, 9);
            threads[9].start();
            */
        }
    }

