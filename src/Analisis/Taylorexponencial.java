package Analisis;

import javax.swing.JOptionPane;

public class Taylorexponencial {

    public static void main(String[] args) {

        int cifS, opcion;
        double valorVerdadero, nivTolerancia, errorAprox = 100;

        String result;
        //pidiendo cifras significativas
        cifS = Integer.parseInt(JOptionPane.showInputDialog("cuantas cifras sig?"));

        //calculando el nivel de tolerancia
        result = "";
        nivTolerancia = (0.5 * Math.pow(10, (2 - cifS)));
        result = "" + nivTolerancia;
        JOptionPane.showMessageDialog(null, nivTolerancia + "%");

        opcion = Integer.parseInt(JOptionPane.showInputDialog("1.metodo 1\n2.metodo2"));
        do {
            if (opcion == 1) {
//                int x = -5;
//                //calculando el valor verdadero de e^-5
//                valorVerdadero = Math.exp(x);
//                result = "" + valorVerdadero;
//                JOptionPane.showMessageDialog(null, result);
//
//                int i = 0;
//                double t, s = 0, ant;
//                while (Math.abs(errorAprox) > nivTolerancia) {
//
//                    System.out.println("iteracion  " + (i + 1));
//                    if (i % 2 == 0) {
//                        if (i == 0) {
//                            t = Math.pow(x, i) / factorial(i);
//                            ant = s;
//                            s += t;
//                            System.out.println("actual    " + s);
//                            System.out.println("anterior    " + ant);
//                        } else {
//                            t = Math.pow(x, i) / factorial(i);
//                            ant = s;
//                            s += t;
//                            System.out.println("actual    " + s);
//                            System.out.println("anterior    " + ant);
//
//                            errorAprox = ((s - ant) / s) * 100;
//
//                            System.out.println("ERROR " + errorAprox);
//                        }
//                    } else {
//                        t = Math.pow(x, i) / factorial(i);
//                        ant = s;
//                        s += t;
//                        System.out.println("actual    " + s);
//                        System.out.println("anterior    " + ant);
//
//                        errorAprox = ((s - ant) / s) * 100;
//
//                        System.out.println("ERROR " + errorAprox);
//                    }
//
//                    i++;
//                }
//                JOptionPane.showMessageDialog(null, "raíz con metodo 1 " + s);
//                JOptionPane.showMessageDialog(null, "error con metodo 1 " + errorAprox);

            } else {
                int x = 5;
                double vVerdadero, error = 100;
                //calculando el valor verdadero de e^-5
                vVerdadero = 1 / (Math.exp(x));
                result = "" + vVerdadero;
                JOptionPane.showMessageDialog(null, result);

                int j = 0;
                double taylor, sumTaylor = 0, anterior, div = 0;
                while (Math.abs(error) > nivTolerancia) {

                    System.out.println("iteracion  " + (j + 1));
                    if (j % 2 == 0) {
                        if (j == 0) {
                            taylor = Math.pow(x, j) / factorial(j);
                            anterior = sumTaylor;
                            div = 1 / (sumTaylor += taylor);

                            System.out.println("actual    " + div);
                            System.out.println("anterior    " + anterior);
                        } else {
                            taylor = Math.pow(x, j) / factorial(j);

                            anterior = sumTaylor;
                            div = 1 / (sumTaylor += taylor);

                            System.out.println("actual    " + div);
                            System.out.println("anterior    " + anterior);

                            error = ((sumTaylor - anterior) / sumTaylor) * 100;

                            System.out.println("ERROR " + error);
                        }
                    } else {
                        taylor = Math.pow(x, j) / factorial(j);

                        anterior = sumTaylor;
                        div = 1 / (sumTaylor += taylor);
                        System.out.println("actual    " + div);
                        System.out.println("anterior    " + anterior);

                        error = ((sumTaylor - anterior) / sumTaylor) * 100;

                        System.out.println("ERROR " + error);
                    }

                    j++;
                }
                JOptionPane.showMessageDialog(null, "raíz con metodo 2 " + div);
                JOptionPane.showMessageDialog(null, "error con metodo 2 " + error);
            }
        } while (opcion > 2);
    }

    public static void taylor1(int a, int b) {
        int x = -5;
        double valorVerdadero, errorAprox = 100;
        //calculando el valor verdadero de e^-5
        valorVerdadero = Math.exp(x);
        JOptionPane.showMessageDialog(null, valorVerdadero);

        int i = 0, cifS = 5;
        double t, s = 0, ant;
        while (Math.abs(errorAprox) > (0.5 * Math.pow(10, (2 - cifS)))) {

            System.out.println("iteracion  " + (i + 1));
            if (i % 2 == 0) {
                if (i == 0) {
                    t = Math.pow(x, i) / factorial(i);
                    ant = s;
                    s += t;
                    System.out.println("actual    " + s);
                    System.out.println("anterior    " + ant);
                } else {
                    t = Math.pow(x, i) / factorial(i);
                    ant = s;
                    s += t;
                    System.out.println("actual    " + s);
                    System.out.println("anterior    " + ant);

                    errorAprox = ((s - ant) / s) * 100;

                    System.out.println("ERROR " + errorAprox);
                }
            } else {
                t = Math.pow(x, i) / factorial(i);
                ant = s;
                s += t;
                System.out.println("actual    " + s);
                System.out.println("anterior    " + ant);

                errorAprox = ((s - ant) / s) * 100;

                System.out.println("ERROR " + errorAprox);
            }

            i++;
        }
        JOptionPane.showMessageDialog(null, "raíz con metodo 1 " + s);
        JOptionPane.showMessageDialog(null, "error con metodo 1 " + errorAprox);

    }

    public static double factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return (n * factorial(n - 1));
        }
    }
}
