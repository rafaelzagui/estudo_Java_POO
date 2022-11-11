import java.awt.*;
import java.util.StringTokenizer;

public class Linha extends Figura {
    private Ponto p1,p2;

    public Linha (int x, int y, int x1, int y1)
    {
        this(x,y,x1,y1,Color.BLACK);
    }
    public Linha (int x,int y,int x1,int y1,Color cor)
    {
        super(cor);
        this.setP1(new Ponto(x,y,cor));
        this.setP2(new Ponto(x1,y1,cor));

    }
    public Linha (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");
        quebrador.nextToken();

        int x = Integer.parseInt(quebrador.nextToken());
        int y = Integer.parseInt(quebrador.nextToken());

        int x1 = Integer.parseInt(quebrador.nextToken());
        int y1 = Integer.parseInt(quebrador.nextToken());
       Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                Integer.parseInt(quebrador.nextToken()),  // G
                Integer.parseInt(quebrador.nextToken())); // B

        this.setP1(new Ponto(x,y,cor));
        this.setP2(new Ponto(x1,y1,cor));
        this.cor = cor;


    }
    @Override
    public String toString()
    {
        return "r:" +
                this.p1.getX() +
                ":" +
                this.p1.getY() +
                ":" +
                this.p2.getX() +
                ":" +
                this.p2.getY() +
                ":" +
                this.getCor().getRed() +
                ":" +
                this.getCor().getGreen() +
                ":" +
                this.getCor().getBlue();
    }

    @Override
    public void torneSeVisivel(Graphics g) {
        g.setColor(this.cor);
        g.drawLine(this.p1.getX(), this.p1.getY(),   // ponto inicial
                this.p2.getX(), this.p2.getY());  // ponto final
    }

    public Ponto getP1() {
        return p1;
    }

    public void setP1(Ponto p1) {
        this.p1 = p1;
    }

    public Ponto getP2() {
        return p2;
    }

    public void setP2(Ponto p2) {
        this.p2 = p2;
    }
}
