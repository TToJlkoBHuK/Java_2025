import java.io.ByteArrayInputStream;
import java.io.IOException;

public class InputStreamDemo {
    public static void main(String[] args) {
        byte[] buffer = {74, 97, 118, 97};

        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(buffer)) {
            int data;

            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}