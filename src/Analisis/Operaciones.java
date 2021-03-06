
package Analisis;

public class Operaciones {
    
    int Factorial(int n){
     int factorial=1,cont=1;
     while (cont<=n){
         factorial*=cont;
         cont++;
     }     
     return factorial;
    } 
    
    Double GradoLib(int n){
        double grado;
        grado=0.5* Math.pow(10,2- n);
        return grado;
    }
    
    Double Algoritmo(double Es ,int decimal,double n,int cont){
        double Ea=100,resultado=0,resultAnt;
      int iteracion=0;
      while(Math.abs(Ea)>Es){
         switch (iteracion){
             case 0:
                 resultado=1;
                 break;
             case 1:
                 resultAnt=redondearDecimales(resultado, decimal+1);
                 
                 resultado=redondearDecimales(resultado -(Math.pow(n, iteracion*2))/(iteracion*n), decimal+1);
                 
                 Ea=((resultado-resultAnt)/resultado)*100;
                 break;
             default :
                 resultAnt=redondearDecimales(resultado, decimal+1);
                 if(iteracion%2==0){
                     resultado= resultado+(Math.pow(n, iteracion*2))/(Factorial(iteracion*2));
                     resultado=redondearDecimales(resultado, decimal+1);
                 }else{
                     resultado=resultado-(Math.pow(n, iteracion*2))/(Factorial(iteracion*2));
                     resultado=redondearDecimales(resultado, decimal+1);
                 }
                 Ea=((resultado-resultAnt)/resultado)*100;
                 break;
         }
       iteracion++;   
      }
     
    if(cont==1){
        return resultado;
    }else{
        return Ea;
    }
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
            return raiz;
        }else{
            
            return 0.0;
        }
        
    }
    
    Double RaicesMedoto2(int a,int b,int c,int cont,int decimal){
           double raiz=0,raiz1,raiz2,disc;
        if(((b^2)-4*a*c)>=0){
            disc=((b^2)-4*a*c);
           //falta poner lo de la raiz
           raiz=Math.sqrt(disc);
           raiz=redondearDecimales(raiz, decimal);
           if(cont==1){
               raiz1=(-b-raiz)/(2*a);
               raiz1=redondearDecimales(raiz1, decimal);
               return raiz1;
           }else{
               raiz2=(-b+raiz)/(2*a);
               raiz2=redondearDecimales(raiz2, decimal);
               return raiz2;
           }
        }else{
            return 0.0;
        }   
    }
    
    public static double redondearDecimales(double n, int decimal) {
        double parteEntera, resultado;
        resultado = n;
        if(resultado>0){
            parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, decimal);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, decimal))+parteEntera;
        return resultado;
        }else{
            resultado*=-1;
            parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, decimal);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, decimal))+parteEntera;
        return resultado*-1;
        }
        
    }
}
