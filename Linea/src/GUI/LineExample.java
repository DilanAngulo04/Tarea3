/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Nelson
 */
public class LineExample extends JPanel {

    public LineExample() {
        this.setPreferredSize(new Dimension(800, 600));
    } // constructor

    private void draw(Graphics g) {
        // dibujar los ejes del plano cartesiano

        for (int i = 0; i <= 2000; i++) {
            int x1 = (int) (Math.random() * 1000);
            int x2 = (int) (Math.random() * 1000);
            int y1 = (int) (Math.random() * 1000);
            int y2 = (int) (Math.random() * 1000);
            Color randomColor = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
            g.setColor(randomColor);
            linearFunction(g, x1, y1, x2, y2); //Al disminuir x la linea va a tener menos puntos
            //Tarea que la linea se vea continua aunque sea verical
            //linearFunction(g, 0, 0, 100, 600);

        }

    } // draw

    // funcion lineal f(x) = m x + b
    // x1 y x2 es el rango en el que se graficara la funcion
    private void linearFunction(Graphics g, double x0, double y0, double x1, double y1) {

        double y;
        //double punto;

        //calculo de pendiente y del termino b (interseccion con eje y)
        double m = (y0 - y1) / (x0 - x1);
        double b = y0 - ((y0 - y1) / (x0 - x1)) * x0;

        if (x1 + x0 > this.getWidth() / 2) {
            for (double x = x0; x <= x1; x += 1) {
                //for(double x = x0; x <= x1; x += 0.1){
                y = (m * x + b);// * 10; // se multiplica por 10 para escalar el punto a representar en pantalla
                //punto = x;// * 10;
                g.drawLine((int) coord_x(x), (int) coord_y(y), (int) coord_x(x), (int) coord_y(y));
            } // for
        } else {
            for (double x = x0; x <= x1; x += 1) {
                //for(double x = x0; x <= x1; x += 0.1){
                y = ((x - b) / m);// * 10; // se multiplica por 10 para escalar el punto a representar en pantalla
                //punto = x;// * 10;
                g.drawLine((int) coord_x(y), (int) coord_y(x), (int) coord_x(y), (int) coord_y(x));
            } // for
        }

    }// linearFunction

    private double coord_x(double x) {
        return x;
    }

    private double coord_y(double y) {
        double real_y = (double) this.getHeight() - y;
        return real_y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // se llama al meto draw
        draw(g);

    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Graphing Function");
        window.setContentPane(new LineExample());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.pack();
        window.setResizable(false);
        window.setLocation(150, 100);
        window.setVisible(true);
    }

} // fin clase

