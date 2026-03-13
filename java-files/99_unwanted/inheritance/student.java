

class a {
    void boss() {
        System.out.println("Hello");
    }
}

class b extends a {
    void beboss() {
        System.out.println("World!");
    }
}

class student {
    public static void main(String[] args) {
        b obj = new b();
        obj.boss();
        obj.beboss();
    }
}