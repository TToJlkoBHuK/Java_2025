package com.example;

public class Test {
    public static void main(String[] args) {
        OuterAccess outer = new OuterAccess();

        // outer.new PrivateInner(); //ОШИБКА КОМПИЛЯЦИИ

        outer.new PackageInner();
        outer.new ProtectedInner();
        outer.new PublicInner();
    }
}