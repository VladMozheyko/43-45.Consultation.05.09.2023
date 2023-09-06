public class Main {
    static int count = 0;
    static int count1 = 0;
    static int count2 = 0;
    public static void main(String[] args) {
        /*
        Задача
        Реализовать последовательный вывод числа от 1 до 5 два раза
         */

        // Синхронизированный доступ к переменной count2
        System.out.println("Выполняем две задачи в двух потоках c синхронизацией: ");
        syncCounter();
        // Однопоточный доступ к переменной count1
        sinleСounter();
        // Несинхронизированный доступ к переменной count
//        System.out.println("Выполняем две задачи в двух потоках без синхронизации: ");
//        counter();

        stringWorker();


    }

    private static void stringWorker() {
        StringBuffer builder = new StringBuffer();   // TODO Заменить StringBuffer на StringBuilder и запустить программу несколько раз, пока не будет получена ошибка. Почему она была получена? Как с этим бороться?
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                builder
                        .append("hello, World hello, World hello, World hello, World hello, World hello, World hello, World hello, World hello, World hello, World hello, World hello, Worldhello, World hello, World hello, World")
                        .append(Thread.currentThread().getName())
                        .append("\n");
                System.out.println(builder);
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }

    private static void sinleСounter() {
        // Однопоточное исполнение двух задача
        System.out.println("Выполняем две задачи в одном потоке: ");
        count1 = 0;
        for (int i = 0; i < 5; i++) {
            count1 += 1;
            System.out.println("Задача 1: " + count1);
        }

        count1 = 0;
        for (int i = 0; i < 5; i++) {
            count1 += 1;
            System.out.println("Задача 2: " + count1);
        }
    }

    public static void counter(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {  // Действия, которые будут выполняться в потоке
                count = 0;
                for (int i = 0; i < 5; i++) {
                    count += 1;
                    System.out.println(Thread.currentThread().getName() + ": " + count);
                }

            }
        };

        Thread thread1 = new Thread(runnable); // Одна задача по изменению переменной count
        Thread thread2 = new Thread(runnable); // Вторая задача для изменения переменной count

        // Запускаем оба потока на выполнение
        thread1.start();
        thread2.start();
    }

    public static void syncCounter(){
        Runnable runnable = new Runnable() {
            // TODO Убрать synchronized из метода run. Почему изменились результаты работы программы?
            @Override
            public synchronized void run() {  // Действия, которые будут выполняться в потоке
                count2 = 0;
                for (int i = 0; i < 5; i++) {
                    count2 += 1;
                    System.out.println(Thread.currentThread().getName() + ": " + count2);
                }

            }
        };

        Thread thread1 = new Thread(runnable); // Одна задача по изменению переменной count
        Thread thread2 = new Thread(runnable); // Вторая задача для изменения переменной count

        // Запускаем оба потока на выполнение
        thread1.start();
        thread2.start();
    }
}
