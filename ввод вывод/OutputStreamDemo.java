import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class OutputStreamDemo {
    public static void main(String[] args) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            outputStream.write(72);
            outputStream.write(105);
            outputStream.write(33);

            String result = outputStream.toString();
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}