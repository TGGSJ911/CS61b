public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);
        int numberOfPlanets = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String filename) {
        In in = new In(filename);
        int length = in.readInt();
        Body[] result = new Body[length];
        double radius = in.readDouble();
        // read the row data
        for (int i = 0; i < length; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgName = in.readString();
            result[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgName);
        }
        return result;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Body[] list = readBodies(filename);

        // draw
        // 1,set the size
        stdDraw.setScale(-radius, radius);
        stdDraw.picture(0, 0, "images/starfield.jpg");
        stdDraw.show();

        for (Body b : list) {
            b.draw();
        }
        stdDraw.enableDoubleBuffering();

        // somehow stdDraw cannot work well.

    }
}