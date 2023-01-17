package Exercise;

import actions.runner;

public class mainrun {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        boolean blnDatos = true;
        System.out.println("..:: Proceso en ejecución  ::..");
        System.out.println("");

        if (blnDatos){
            runner.getRun();

        }else {
            System.out.println("Error, vuelva a ingresar.");
        }
        System.out.println("");
        System.out.println("..:: Fin del proceso ::..");
    }
}
