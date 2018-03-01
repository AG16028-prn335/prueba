
package Analisis;

import java.math.BigDecimal;
import java.util.function.LongToDoubleFunction;
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
    
    String Algoritmo(double Es, double n){
      String res="";
        double Ea=100,resultado=0,resultAnt;
      int iteracion=0;
      while(Ea<=Es){
         switch (iteracion){
             case 0:
                 resultado=1;
                 Ea=100;
                 break;
             case 1:
                 resultAnt=resultado;
                 resultado= resultado -(Math.pow(n, iteracion*2))/(iteracion*n);
                 Ea= ((resultado-resultAnt)/resultado)*100;
                 break;
             default :
                 resultAnt=resultado;
                 if(iteracion%2==0){
                     resultado= resultado+(Math.pow(n, iteracion*2))/(Factorial(iteracion*2));
                     
                 }else{
                     resultado= resultado-(Math.pow(n, iteracion*2))/(Factorial(iteracion*2));
                 }
                 Ea=((resultado-resultAnt)/resultado)*100;
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
        }else{
            JOptionPane.showMessageDialog(null, "Tiene Raices Imaginarias");
        }
        return raiz;
    }
}
