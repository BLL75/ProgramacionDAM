/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.tema6;

/**
 *
 * @author Bernar
 */
public class Ej01_ComposicionHerencia {
    public static void main(String[] args){
        CirculoHeredaDePunto c1 = new CirculoHeredaDePunto(10, 5, 3);
        System.out.println(c1);
        System.out.println("Área: " + c1.area());
        System.out.println("Perímetro: " + c1.perimetro());
    }
}

class Punto {
    protected double x;
    protected double y;
    
    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public void mover(double dx, double dy){
        this.x += dx;
        this.y += dy;
    }
    
    @Override
    public String toString(){
        return("Punto(" + x + ", " + y + ")");
    }
}


class CirculoHeredaDePunto extends Punto{
    private double radio;
    
    public CirculoHeredaDePunto(double x, double y, double radio) {
        super(x, y);
        this.radio = radio;
    }
    
    public double area(){
        return Math.PI * radio * radio;
    }
    
    public double perimetro() {
        return 2 * Math.PI * radio;
    }
    
    public String toString(){
        return "CirculoHeredaDePunto(centro=(" + x + "," + y + "), radio=" + radio + ")";
    }
}