class Outer {
    public String publicField = "Public Field";
    private String privateField = "Private Field";
    private static int staticPrivateField = 100;

    private void privateMethod() {
        System.out.println("Private Method from Outer");
    }

    class Inner {
        void accessOuterMembers() {
            System.out.println(privateField);

            System.out.println(publicField);

            System.out.println(staticPrivateField);

            privateMethod();
        }
    }

    void run() {
        Inner inner = new Inner();
        inner.accessOuterMembers();
    }
}