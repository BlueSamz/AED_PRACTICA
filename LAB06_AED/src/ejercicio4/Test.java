package ejercicio4;

public class Test {
    public static void main(String[] args) {
        System.out.println(Aplication.symbolBalancing("()()()[()]()")); 
        System.out.println(Aplication.symbolBalancing("((()))[]"));     
        System.out.println(Aplication.symbolBalancing("([])[]("));      
        System.out.println(Aplication.symbolBalancing("([{)]}"));       
        System.out.println(Aplication.symbolBalancing("["));            
        System.out.println(Aplication.symbolBalancing("[][][]{{{}}}")); 
    }
}
