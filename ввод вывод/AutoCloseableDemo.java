class MyResource implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("Ресурс был автоматически закрыт!");
    }

    public void work() {
        System.out.println("Ресурс работает...");
    }
}

public class AutoCloseableDemo {
    public static void main(String[] args) {
        try (MyResource resource = new MyResource()) {
            resource.work();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}