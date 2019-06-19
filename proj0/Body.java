import java.lang.Math;

public class Body {
    // add instance variables
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    String imgFileName;
    private final double g = 6.67E-11;

    // add constructors
    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
        double temp = Math.pow((b.xxPos - this.xxPos), 2) + Math.pow((b.yyPos - this.yyPos), 2);
        double distance = Math.sqrt(temp);
        return distance;
    }

    public double calcForceExertedBy(Body b) {
        double r = this.calcDistance(b);
        double F = g * this.mass * b.mass / (r * r);
        return F;
    }

    public double calcForceExertedByX(Body b) {
        double f = calcForceExertedBy(b);
        double dx = b.xxPos - xxPos;
        double r = calcDistance(b);
        return f * dx / r;
    }

    public double calcForceExertedByY(Body b) {
        double f = calcForceExertedBy(b);
        double dy = b.yyPos - yyPos;
        double r = calcDistance(b);
        return f * dy / r;
    }

    public double calcNetForceExertedByX(Body[] bodies) {
        double fX = 0;
        for (Body b : bodies) {
            if (!this.equals(b)) {
                fX += calcForceExertedByX(b);
            }
        }
        return fX;
    }

    public double calcNetForceExertedByY(Body[] bodies) {
        double fY = 0;
        for (Body b : bodies) {
            if (!this.equals(b)) {
                fY += calcForceExertedByY(b);
            }
        }
        return fY;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel += dt * aX;
        yyVel += dt * aY;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw(String img) {
        StdDraw.picture(xxPos, yyPos, "images/" + img);
    }

}