class Outer {

    void accessInnerMembers() {
        Inner inner = new Inner();

        System.out.println(inner.publicInnerField);

        System.out.println(inner.privateInnerField);

        inner.privateInnerMethod();
    }

    class Inner {
        public String publicInnerField = "Inner Public";
        private String privateInnerField = "Inner Private";

        private void privateInnerMethod() {
            System.out.println("Inner Private Method");
        }
    }
}

class Stranger {
    void tryAccess() {
        Outer.Inner inner = new Outer().new Inner();
        System.out.println(inner.publicInnerField);
        // System.out.println(inner.privateInnerField); // ОШИБКА
    }
}