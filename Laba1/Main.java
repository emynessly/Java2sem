import java.util.concurrent.Semaphore;

class Fork { // ���������� ������ �����
    private final int id;
    public Fork(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
}

class Philosopher extends Thread { // �������� ������ ��������
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private final Semaphore semaphore;

    public Philosopher(int id, Fork leftFork, Fork rightFork, Semaphore semaphore) { // ����������� ��������
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.semaphore = semaphore;
    }

    private void think() throws InterruptedException { // ������� ������ �� 5 ������, ���� �����������, �� ������
        System.out.println("������� " + id + " ������");
        Thread.sleep((int)(Math.random() * 5000));
    }
    private void eat() throws InterruptedException { // ������� ��� �� 5 ������, ���� �����������, �� ������
        System.out.println("������� " + id + " ���");
        Thread.sleep((int)(Math.random() * 5000));
    }

    @Override
    public void run() {
        while (true) {
            try {
                think();
                semaphore.acquire(); // "������� ������ ���������� �� �����"
                synchronized (leftFork) { // ���������� ����� �����
                    System.out.println("������� " + id + " ���� ����� " + leftFork.getId());
                    synchronized (rightFork) { // ���������� ������ �����
                        System.out.println("������� " + id + " ���� ����� " + rightFork.getId());
                        eat(); // ���-���
                        System.out.println("������� " + id + " ������� ����� " + rightFork.getId());
                    } // ��������� ������
                    System.out.println("������� " + id + " ������� ����� " + leftFork.getId());
                } // ��������� �����
                semaphore.release(); // "������� ����������� �����"
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int philNumber = 5; // ������ ���-�� ���������
        Fork[] forks = new Fork[philNumber]; // �������� ������� ����� �� ������� ��������
        Philosopher[] philosophers = new Philosopher[philNumber]; // �������� ������� ���������

        Semaphore semaphore = new Semaphore(philNumber - 1); // �������� �������� � ���-��� ���������� = 5
        for (int i = 0; i < philNumber; i++) { // �������� ����� � �� id ��� n-��� ���������� ��������� (5 � ����� ������)
            forks[i] = new Fork(i);
        }

        for (int i = 0; i < philNumber; i++) {
            Fork leftFork = forks[i]; // ����� �����
            Fork rightFork = forks[(i + 1) % philNumber]; // ������ �����
            philosophers[i] = new Philosopher(i, leftFork, rightFork, semaphore); // �������� �������� � ������� �����������
            philosophers[i].start();
        }
    }
}