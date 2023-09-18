interface Point {
    double distanceTo(Point other);
}

class Point2D implements Point {

    private double x, y;

    protected Point2D  (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point other) {
        var dx = x - ((Point2D)other).x;
        var dy = y - ((Point2D)other).y;
        return Math.hypot(dx, dy);
    }
}

class Point3D implements Point {

    private double x, y, z;

    public Point3D  (double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distanceTo(Point other) {
        var dx = x - ((Point3D)other).x;
        var dy = y - ((Point3D)other).y;
        var dz = z - ((Point3D)other).z;
        return Math.hypot(Math.hypot(dx, dy), dz);
    }
}

class MinkowskiPoint implements Point {

    private double x, y, z;
    private double t;                       // actually t*i
    private static double C = 299792458.0;  // speed of light, in m/s

    public MinkowskiPoint  (double x, double y, double z, double t) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.t = t;
    }

    private MinkowskiPoint ref(Point p) {
        return (MinkowskiPoint)p;
    }

    private double sqr(double x) {
        return x * x;
    }

    public double distanceTo(Point other) {
        var dx = x - ref(other).x;
        var dy = y - ref(other).y;
        var dz = z - ref(other).z;
        var dt = t - ref(other).t;
        return Math.sqrt(sqr(C * dt) - sqr(dx) - sqr(dy) - sqr(dz));
    }
}