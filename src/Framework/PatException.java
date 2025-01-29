package Framework;

public class PatException extends Exception {
    public PatException(String e, String clase, String metodo) {
        System.out.println("ERROR PARA LOG " + clase +"."+ metodo +" : "+ e );
    }

    @Override 
    public String getMessage(){
        return "No se pudo realizar la accion...";
    }    
}
