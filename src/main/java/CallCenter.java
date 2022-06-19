import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {

    static final int MAX_ITERATIONS = 2;
    static final int CALLS_COUNT = 20;
    static final int WAIT_TIME = 2000;
    static final int CALL_PROCESSING = 3000;

    protected ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
    protected int iteration;
    protected int callNumber = 1;

    public void generateCalls() {
        try {
            while (iteration < MAX_ITERATIONS) {
                for (int i = 1; i <= CALLS_COUNT; i++) {
                    String call = "call" + callNumber;
                    queue.add(call);
                    callNumber++;
                }
                iteration++;
                Thread.sleep(WAIT_TIME);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void acceptCall() {
        while (true) {
            if (queue.isEmpty()) {
                break;
            }
            String call;
            if ((call = queue.poll()) != null) {
                System.out.printf("%s обработал звонок %s\n", Thread.currentThread().getName(), call);
                try {
                    Thread.sleep(CALL_PROCESSING);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                break;
            }
        }
    }
}
