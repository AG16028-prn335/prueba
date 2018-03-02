package Analisis;

public class Taylorexponencial {

    public static void main(String[] args) {
    }
    Double taylor2(int cifS,int cont) {
        double  nivTolerancia;
        nivTolerancia = (0.5 * Math.pow(10, (2 - cifS)));
        int x = 5;
       double  error = 100;
        int j = 0;
       double taylor, sumTaylor = 0, anterior, div = 0;
            while (Math.abs(error) > nivTolerancia) {
                    if (j % 2 == 0) {
                        if (j == 0) {
                            taylor = Math.pow(x, j) / factorial(j);
                            anterior = sumTaylor;
                            div = 1 / (sumTaylor += taylor);

                        } else {
                            taylor = Math.pow(x, j) / factorial(j);

                            anterior = sumTaylor;
                            div = 1 / (sumTaylor += taylor);
                            error = ((sumTaylor - anterior) / sumTaylor) * 100;
                        }
                    } else {
                        taylor = Math.pow(x, j) / factorial(j);

                        anterior = sumTaylor;
                        div = 1 / (sumTaylor += taylor);
                        error = ((sumTaylor - anterior) / sumTaylor) * 100;
                    }
                    j++;
                }
             if(cont==1){
                 return div;
             }else{
                 return Math.abs(error);
             }   
    }
    
    Double taylor1(int cifS,int cont) {
        int x = -5;
        double errorAprox = 100;
        int i = 0;
        double t, s = 0, ant;
        while (Math.abs(errorAprox) > (0.5 * Math.pow(10, (2 - cifS)))) {

            if (i % 2 == 0) {
                if (i == 0) {
                    t = Math.pow(x, i) / factorial(i);
                    ant = s;
                    s += t;
                } else {
                    t = Math.pow(x, i) / factorial(i);
                    ant = s;
                    s += t;
                    errorAprox = ((s - ant) / s) * 100;
                }
            } else {
                t = Math.pow(x, i) / factorial(i);
                ant = s;
                s += t;
                errorAprox = ((s - ant) / s) * 100;
            }
            i++;
        }
        if(cont==1){
            return s;
        }else{
           return Math.abs(errorAprox); 
        }
    }

    public static double factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return (n * factorial(n - 1));
        }
    }
}
