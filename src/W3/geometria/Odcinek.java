package W3.geometria;

/**
 * Class representing a line segment in 2D space.
 * If two Segments have the same points, but in different order,
 * they are seen as different segments
 * e.g. segment {A, B} is different than {B, A]
 */
public class Odcinek extends Figura {
    public Punkt A, B;

    public Odcinek(Punkt a, Punkt b) {
        A = a;
        B = b;
        validate();
    }

    public Odcinek(double x1, double y1, double x2, double y2) {
        this(new Punkt(x1, y1), new Punkt(x2, y2));
    }

    private void validate() throws IllegalArgumentException {
        if (A.equals(B))
            throw new IllegalArgumentException("Endpoints must be different!");
    }

    @Override
    public void przesuń(Wektor v) {
        A.przesuń(v);
        B.przesuń(v);
    }

    @Override
    public void obruć(Punkt p, double kąt) {
        A.obruć(p, kąt);
        B.obruć(p, kąt);
    }

    @Override
    public void odbij(Prosta p) {
        A.odbij(p);
        B.odbij(p);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Odcinek odcinek = new Odcinek((Punkt) this.A.clone(), (Punkt) this.B.clone());
        return odcinek;
    }

}
