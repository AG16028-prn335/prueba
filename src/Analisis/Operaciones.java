
package Analisis;

import javax.swing.JOptionPane;

public class Operaciones {
    
    String Validacion(int a, int b, int c){
        String cadena;
        switch (a) {
            case 1:
                cadena="x²";
            break;
            case -1:
                cadena="-x²";
            break;
            default:
                cadena=a+"x²";
            break;
        }
        switch(b){
            case 1:
                cadena+="+ x";
            break;
            case -1:
                cadena+="- x";
            break;
            default :
            if(b<0){cadena+= " "+b+"x";
            }else{cadena+= " + "+b+"x";
            }
            break;
        }
        if(c<0){cadena+= " "+c;
        }else{cadena+= " + "+c;
        }
   
        return cadena;
    }
    
    int Factorial(int n){
     int factorial=1,cont=1;
     while (cont<=n){
         factorial+=cont*factorial;
         cont++;
     }     
     return factorial;
    } 
    
    Double GradoLib(int n){
        double grado;
        grado=(0.5*(10^(2-n)));
        return grado;
    }
    
    String Algoritmo(double Es, int decima,double n){
      String res="";
        double Ea=100,resultado=0,resultAnt;
      int iteracion=0;
      while(Ea>Es){
         switch (iteracion){
             case 0:
                 resultado=redondearNumero(1, decima);
                 break;
             case 1:
                 resultAnt=redondearNumero(resultado, decima);
                 
                 resultado= redondearNumero(resultado -(Math.pow(n, iteracion*2))/(iteracion*n), decima);
                 
                 Ea= redondearNumero(((resultado-resultAnt)/resultado)*100, decima);
                 break;
             default :
                 resultAnt=resultado;
                 if(iteracion%2==0){
                     resultado= redondearNumero(resultado+(Math.pow(n, iteracion*2))/(Factorial(iteracion*2)), decima);
                     
                 }else{
                     resultado= redondearNumero(resultado-(Math.pow(n, iteracion*2))/(Factorial(iteracion*2)), decima);
                 }
                 Ea=redondearNumero(((resultado-resultAnt)/resultado)*100, decima);
                 break;
         }
       iteracion++;   
      }
      res+=resultado;
      return res;
  }
    Double RaicesMetodo1(int a,int b,int c,int cont){
        double raiz=0,disc;
        if(((b^2)-4*a*c)>=0){
            disc=((b^2)-4*a*c);
           //falta poner lo de la raiz
            if(cont==1){
                raiz= (2*c)/(-b+Math.sqrt(disc));
            }else{
                 raiz= (2*c)/(-b-Math.sqrt(disc));
            } 
            System.out.println(""+raiz);
            return raiz;
        }else{
            
            return 0.0;
        }
        
    }
    
    public double redondearNumero(double numero, int cifras) {
        boolean positivo = false;
        double parteEntera = 0, aux;
        int i = 0;

        if (numero > 0.0) {
            parteEntera = Math.floor(numero);
            numero -= parteEntera;
            positivo = true;
        } else if (numero < 0.0) {
            numero *= -1;
            parteEntera = Math.floor(numero);
            numero -= parteEntera;
            positivo = false;
        }

        if (numero == 0.0 && positivo) {
            return parteEntera;
        } else if (numero == 0.0) {
            return parteEntera * -1;
        }

        do {
            aux = numero * Math.pow(10, cifras + i);
            i++;
        } while (Math.floor(aux) == 0);
        i--;
        numero *= Math.pow(10, cifras + i);
        numero = Math.round(numero);
        numero /= Math.pow(10, cifras + i);

        if (positivo == true) {
            return numero + parteEntera;
        } else {
            return (numero + parteEntera) * -1;
        }
    }
}
