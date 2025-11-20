class SmartPhone {
    //PRIVATE
    private String cpuArchitecture = "Секретная архитектура процессора";

    //DEFAULT
    String serialNumber = "SN-12345678";

    //PROTECTED
    protected String osVersion = "Android 14";

    //PUBLIC
    public String brandName = "Samsung";

    public void showDiagnostics() {
        System.out.println("--- Внутри класса SmartPhone ---");
        System.out.println("Private: " + cpuArchitecture);
        System.out.println("Default: " + serialNumber);
        System.out.println("Protected: " + osVersion);
        System.out.println("Public: " + brandName);
    }
}

public class AccessDemo {
    public static void main(String[] args) {
        SmartPhone phone = new SmartPhone();

        System.out.println("\n--- Внутри чужого класса (AccessDemo) ---");

        //PRIVATE
        System.out.println("Private: НЕДОСТУПЕН (Ошибка компиляции)");

        //DEFAULT
        System.out.println("Default: " + phone.serialNumber);

        //PROTECTED
        System.out.println("Protected: " + phone.osVersion);

        //PUBLIC
        System.out.println("Public: " + phone.brandName);

       System.out.println("\n--- Через публичный метод ---");
        phone.showDiagnostics();
    }
}