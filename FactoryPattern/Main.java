class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        distanceBetween("0.0 0.0",
                        "1.0 1.0",
                        new Point2DFactory());
        distanceBetween("0.0 0.0 0.0",
                        "1.0 1.0 1.0",
                        new Point3DFactory());
    }

    void distanceBetween(String s1, String s2, PointFactory pf) {
        var p1 = pf.create(s1);
        var p2 = pf.create(s2);
        System.out.println(p1.distanceTo(p2));
    }void distanceBetween(String s1, String s2, PointFactory pf) {
        var p1 = pf.create(s1);
        var p2 = pf.create(s2);
        System.out.println(p1.distanceTo(p2));
    }
}