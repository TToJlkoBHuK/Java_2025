package com.example;

public class OuterAccess {

    // 1. Private: доступен только внутри OuterAccess
    private class PrivateInner {
        void print() { System.out.println("Private"); }
    }

    // 2. Package-private: доступен внутри пакета com.example
    class PackageInner {
        void print() { System.out.println("Package-private"); }
    }

    // 3. Protected: доступен внутри пакета и наследникам OuterAccess
    protected class ProtectedInner {
        void print() { System.out.println("Protected"); }
    }

    // 4. Public: доступен всем
    public class PublicInner {
        void print() { System.out.println("Public"); }
    }

    public void createInner() {
        // Внутри внешнего класса доступны ВСЕ варианты
        new PrivateInner();
        new PackageInner();
        new ProtectedInner();
        new PublicInner();
    }
}