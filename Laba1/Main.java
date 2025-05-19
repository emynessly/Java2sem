import java.util.concurrent.Semaphore;

class Fork { // объявление класса вилки
    private final int id;
    public Fork(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
}

class Philosopher extends Thread { // создание класса философа
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private final Semaphore semaphore;

    public Philosopher(int id, Fork leftFork, Fork rightFork, Semaphore semaphore) { // конструктор философа
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.semaphore = semaphore;
    }

    private void think() throws InterruptedException { // философ думает до 5 секунд, если прерывается, то ошибка
        System.out.println("Философ " + id + " думает");
        Thread.sleep((int)(Math.random() * 5000));
    }
    private void eat() throws InterruptedException { // философ ест до 5 секунд, если прерывается, то ошибка
        System.out.println("Философ " + id + " ест");
        Thread.sleep((int)(Math.random() * 5000));
    }

    @Override
    public void run() {
        while (true) {
            try {
                think();
                semaphore.acquire(); // "философ просит разрешение на место"
                synchronized (leftFork) { // блокировка левой вилки
                    System.out.println("Философ " + id + " взял вилку " + leftFork.getId());
                    synchronized (rightFork) { // блокировка правой вилки
                        System.out.println("Философ " + id + " взял вилку " + rightFork.getId());
                        eat(); // ням-ням
                        System.out.println("Философ " + id + " положил вилку " + rightFork.getId());
                    } // освободил правую
                    System.out.println("Философ " + id + " положил вилку " + leftFork.getId());
                } // освободил левую
                semaphore.release(); // "философ освобождает место"
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int philNumber = 5; // задаем кол-во философов
        Fork[] forks = new Fork[philNumber]; // создание массива вилок на каждого философа
        Philosopher[] philosophers = new Philosopher[philNumber]; // создание массива философов

        Semaphore semaphore = new Semaphore(philNumber - 1); // создание семафора с кол-вом разрешений = 5
        for (int i = 0; i < philNumber; i++) { // создание вилок и их id для n-ого количества философов (5 в нашем случае)
            forks[i] = new Fork(i);
        }

        for (int i = 0; i < philNumber; i++) {
            Fork leftFork = forks[i]; // левая вилка
            Fork rightFork = forks[(i + 1) % philNumber]; // правая вилка
            philosophers[i] = new Philosopher(i, leftFork, rightFork, semaphore); // создание философа с данными параметрами
            philosophers[i].start();
        }
    }
}