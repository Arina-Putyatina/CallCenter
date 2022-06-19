public class Main {

    static final int WAIT_TIME = 1000;

    public static void main(String[] args) throws InterruptedException {

        CallCenter callCenter = new CallCenter();

        Thread atc = new Thread(callCenter::generateCalls, "АТС");

        Thread operator1 = new Thread(callCenter::acceptCall, "Оператор 1");
        Thread operator2 = new Thread(callCenter::acceptCall, "Оператор 2");
        Thread operator3 = new Thread(callCenter::acceptCall, "Оператор 3");
        Thread operator4 = new Thread(callCenter::acceptCall, "Оператор 4");

        atc.start();

        Thread.sleep(WAIT_TIME);
        operator1.start();
        Thread.sleep(WAIT_TIME);
        operator2.start();
        Thread.sleep(WAIT_TIME);
        operator3.start();
        Thread.sleep(WAIT_TIME);
        operator4.start();

        atc.join();
        operator1.join();
        operator2.join();
        operator3.join();
        operator4.join();

    }
}
