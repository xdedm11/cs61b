public class NBody {
    /** Read Planets and Tadius */
    public static Planet[] readPlanets(String planetsTxtPath) {
        In in = new In(planetsTxtPath);        
        int NumofPlanets = in.readInt();
        // System.out.println(NumofPlanets);
        Planet[] AllPlanets = new Planet[NumofPlanets];
        double radius = in.readDouble();

        for (int i = 0; i < NumofPlanets; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            // imgFileName = "./images/" + imgFileName;
            // System.out.println(imgFileName);
            AllPlanets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return AllPlanets;
    }

    public static double readRadius(String planetsTxtPath) {
        In in = new In(planetsTxtPath);
        int NumofPlanets = in.readInt();
        double radius = in.readDouble();
        return radius;
    }
    
    /** Drawing the Initial Universe State */
    public static void drawBackground(double radius) {
        String imageBackground = "./images/starfield.jpg";
        StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, imageBackground);
		StdDraw.show();
		// StdDraw.pause(2000);
    }

    /** Use
     *  javac -encoding utf-8 NBody.java
     * when there is encode problem
     * java NBody 157788000.0 25000.0 data/planets.txt
     * java NBody 20000000 20000 ./data/suninterference.txt
     */
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        // String filename = "./data/planets.txt";
        String filename = args[2];
        Planet[] AllPlanets = readPlanets(filename);
        double radius = readRadius(filename);
        
        /** Drawing the Initial Universe State */
        drawBackground(radius);
        for (Planet planet : AllPlanets) {
            planet.draw();
        }
        /** Creating an Animation */
        StdDraw.enableDoubleBuffering();
        double t = 0.0;
        while (t < T) {
            double[] xForces = new double[AllPlanets.length];
            double[] yForces = new double[AllPlanets.length];
            for (int i = 0; i < AllPlanets.length; i++) {
                xForces[i] = AllPlanets[i].calcNetForceExertedByX(AllPlanets);
                yForces[i] = AllPlanets[i].calcNetForceExertedByY(AllPlanets);
            }
            StdDraw.clear();
            drawBackground(radius);
            for (int i = 0; i < AllPlanets.length; i++) {
                AllPlanets[i].update(dt, xForces[i], yForces[i]);
                AllPlanets[i].draw();
            }
            StdDraw.pause(10);
            t = t + dt;
        }
        /** Printing the Universe */
        StdOut.printf("%d\n", AllPlanets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < AllPlanets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        AllPlanets[i].xxPos, AllPlanets[i].yyPos, AllPlanets[i].xxVel,
                        AllPlanets[i].yyVel, AllPlanets[i].mass, AllPlanets[i].imgFileName);   
        }
    }
}
