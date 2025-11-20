final class SecurityGuard {
    public void checkAccess() {
        System.out.println("Доступ разрешен");
    }
}
// (Нельзя наследоваться от final класса 'SecurityGuard')
/*
class Hacker extends SecurityGuard { 
    // Этот класс даже не начнет компилироваться
}
*/