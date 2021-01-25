/**
 * Planet
 */
public class Planet {

    public double xxPos;   //current x position
    public double yyPos;   //current y position
    public double xxVel;   //current velocity in the x direction
    public double yyVel;   //current velocity in the y direction
    public double mass;
    public String imgFileName;
    private static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet rocinante) {
        double dx = rocinante.xxPos - this.xxPos;
        double dy = rocinante.yyPos - this.yyPos;
        double r = dx * dx + dy * dy;
        r = Math.sqrt(r);
        return r;
    }

    public double calcForceExertedBy(Planet rocinante) {
        double F = G * this.mass * rocinante.mass / this.calcDistance(rocinante) / this.calcDistance(rocinante);
        return F;
    }

    public double calcForceExertedByX(Planet rocinante) {
        double dx = rocinante.xxPos - this.xxPos;
        double dy = rocinante.yyPos - this.yyPos;
        double F = this.calcForceExertedBy(rocinante);
        double r = dx * dx + dy * dy;
        r = Math.sqrt(r);
        double Fx = F * dx / r;
        return Fx;
    }

    public double calcForceExertedByY(Planet rocinante) {
        double dx = rocinante.xxPos - this.xxPos;
        double dy = rocinante.yyPos - this.yyPos;
        double F = this.calcForceExertedBy(rocinante);
        double r = dx * dx + dy * dy;
        r = Math.sqrt(r);
        double Fx = F * dy / r;
        return Fx;
    }
    
    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double[] Fx = new double[allPlanets.length];
        double Fnetx = 0.0;
        for (int i = 0; i < allPlanets.length; i++) {
            if (allPlanets[i].equals(this)) {
                Fx[i] = 0.0;
            } else {
                Fx[i] = this.calcForceExertedByX(allPlanets[i]);
            }
            Fnetx += Fx[i];
        }
        return Fnetx;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double[] Fy = new double[allPlanets.length];
        double Fnety = 0.0;
        for (int i = 0; i < allPlanets.length; i++) {
            if (allPlanets[i].equals(this)) {
                Fy[i] = 0.0;
            } else {
                Fy[i] = this.calcForceExertedByY(allPlanets[i]);
            }
            Fnety += Fy[i];
        }
        return Fnety;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel = xxVel + dt * aX;
        yyVel = yyVel + dt * aY;
        xxPos = xxPos + xxVel * dt;
        yyPos = yyPos + yyVel * dt;
    }
    
    public void draw() {
		StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
		StdDraw.show();
    }
}