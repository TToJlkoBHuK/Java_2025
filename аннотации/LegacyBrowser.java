import java.util.ArrayList;
import java.util.List;

class Browser {
    public void start() {
        System.out.println("Браузер запущен");
    }
}

public class LegacyBrowser extends Browser {

    @Override
    public void start() {
        super.start();
        System.out.println("Загрузка старого движка...");
    }

    @Deprecated
    public void connectViaDialUp() {
        System.out.println("Звуки модема... Подключение...");
    }

    @SuppressWarnings("deprecation")
    public void forceConnection() {
        connectViaDialUp();

        @SuppressWarnings("unchecked")
        List list = new ArrayList();
        list.add("Test");
    }

    public static void main(String[] args) {
        LegacyBrowser browser = new LegacyBrowser();
        browser.start();
        browser.forceConnection();
    }
}