
package Analisis;

public class Operaciones {
    
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
    
    String Algoritmo(double Es ,double n){
      String res="";
        double Ea=100,resultado=0,resultAnt;
      int iteracion=0;
      while(Ea>Es){
         switch (iteracion){
             case 0:
                 resultado=1;
                 break;
             case 1:
                 resultAnt=resultado;
                 
                 resultado=resultado -(Math.pow(n, iteracion*2))/(iteracion*n);
                 
                 Ea=((resultado-resultAnt)/resultado)*100;
                 break;
             default :
                 resultAnt=resultado;
                 if(iteracion%2==0){
                     resultado= resultado+(Math.pow(n, iteracion*2))/(Factorial(iteracion*2));
                     
                 }else{
                     resultado=resultado-(Math.pow(n, iteracion*2))/(Factorial(iteracion*2));
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
            return raiz;
        }else{
            
            return 0.0;
        }
        
    }
    
    Double RaicesMedoto2(int a,int b,int c,int cont){
           double raiz=0,raiz1,raiz2,disc;
           String dis;
        if(((b^2)-4*a*c)>=0){
            disc=((b^2)-4*a*c);
            dis=String.format("%1$.2f", Math.sqrt(disc));
           //falta poner lo de la raiz
           raiz=Double.parseDouble(dis);
           System.out.println(raiz);
           if(cont==1){
               raiz1=(-b-raiz)/(2*a);
               return raiz1;
           }else{
               raiz2=(-b+raiz)/(2*a);
               return raiz2;
           }
        }else{
            return 0.0;
        }   
    }
    
    
}
