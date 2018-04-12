package anotherTechnique;

import java.awt.*;
import javax.swing.ImageIcon;
import java.lang.String;

public class Simulator {

    private DisplayFrame myDisplayer;  //JFrame
    private Circle myCircle;
    private Rectangle myRectangle;
    int x1 = (int) (Math.random() * 300);
    int x2 = (int) (Math.random() * 300);
    int y1 = (int) (Math.random() * 300);
    int y2 = (int) (Math.random() * 300);
    int limit = (int) ((int) 1*(Math.random() * 5));;

    //constructor
    public Simulator(DisplayFrame myDisplayer_) {
        this.setMyDisplayer(myDisplayer_);
        this.setMyCircle(new Circle());
        this.setMyRectangle(new Rectangle());

        //valores de las figuras
        myCircle.setHeight(60);
        myCircle.setWidth(70);
        myRectangle.setHeight(75);
        myRectangle.setWidth(100);
    }

    //ciclo infinito para mover las figuras
    public void startSimulation(int waitingTime) throws InterruptedException {
        //ciclo infinito

        while (true) {
            this.moveShapes();
            this.createImages();

            //pone en espera el flujo del programa
            Thread.sleep(waitingTime);//no se vea tan rapido el movimiento
        }
    }//end method

    //cambio los valores de las variables de las figuras que tengo
    public void moveShapes() {

        if (limit == 1) {
            x1--;
            y1--;
            if (x1 == 0) {
                limit = 2;
            }
            if (y1 == 0) {
                limit = 4;
            }
        }
        if (limit == 2) {
            x1++;
            y1--;
            if (x1 == (myDisplayer.getWidth() - 100)) 
            {
                limit = 1;
            }
            if (y1 == 0) {
                limit = 3;
            }
        }
        if (limit == 3) {
            x1++;
            y1++;
            if (x1 == (myDisplayer.getWidth() - 100)) {
                limit = 4;
            }
            if (y1 == (myDisplayer.getHeight() - 100)) {
                limit = 2;
            }
        }
        if (limit == 4) {
            x1--;
            y1++;
            if (x1 == 0) {
                limit = 3;
            }
            if (y1 == (myDisplayer.getHeight() - 100)) {
                limit = 1;
            }
        }

        getMyCircle().setRow(x1);
        getMyCircle().setColumn(y1);

        getMyRectangle().setRow(y1);
        getMyRectangle().setColumn(x1);

    }

    //coloca nuevos valores aleatorios en las figuras
    public void createImages() {
        myDisplayer.initImage();
        Graphics graphic = myDisplayer.getGraphicsImage();

        graphic.setColor(Color.BLUE);
        graphic.fillOval(getMyCircle().getColumn(),
                getMyCircle().getRow(),
                getMyCircle().getWidth(),
                getMyCircle().getHeight());

        graphic.setColor(Color.GREEN);
        graphic.fillRect(getMyRectangle().getColumn(),
                getMyRectangle().getRow(),
                getMyRectangle().getWidth(),
                getMyRectangle().getHeight());

        myDisplayer.paintAgain();
    }

    //**************************************************************************
    /*     metodos accesores      */
    public Circle getMyCircle() {
        return myCircle;
    }

    public void setMyCircle(Circle myCircle) {
        this.myCircle = myCircle;
    }

    public DisplayFrame getMyDisplayer() {
        return myDisplayer;
    }

    public void setMyDisplayer(DisplayFrame myDisplayer) {
        this.myDisplayer = myDisplayer;
    }

    public anotherTechnique.Rectangle getMyRectangle() {
        return myRectangle;
    }

    public void setMyRectangle(anotherTechnique.Rectangle myRectangle) {
        this.myRectangle = myRectangle;
    }

}
