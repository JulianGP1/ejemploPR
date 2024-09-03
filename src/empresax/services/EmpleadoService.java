package empresax.services;
import empresax.modelss.Empleado;
import java.util.Scanner;

public class EmpleadoService {
    private Scanner sc;
    private Empleado empleado;
    private Empleado[] listaEmpleados;

    public EmpleadoService() {
        sc = new Scanner(System.in);
        createListEmpleados();
    }

    private void createListEmpleados(){
        System.out.println("Ingrese la cantidad de empleados");
        int cantidad = sc.nextInt();
        listaEmpleados = new Empleado[cantidad];

    }
    public void menu(){
        int opcion;
        do{
            System.out.println("::MENU::");
            System.out.println("1 - CREAR EMPLEADO");
            System.out.println("2 - MODIFICAR EMPLEADO");
            System.out.println("3 - BUSCAR EMPLEADO");
            System.out.println("4 - LISTAR EMPLEADOS");
            System.out.println("0 - SALIR");
            System.out.println("Ingrese una opcion del menu");
            opcion = sc.nextInt();
            switch(opcion){
                case 1: crearEmpleado();
                break;
                case 2: modificarEmpleado();
                break;
                case 3: imprimirempleado();
                break;
                case 4: listarEmpleado();
                break;
                default: 
                    opcion = 0;
                    System.out.println("Gracias por usar este menu");
            }
        }while(opcion != 0);
    }

    private void crearEmpleado() {
        System.out.println("***CREAR EMPLEADOS**");
        for(int i = 0; i < listaEmpleados.length; i++){
            System.out.println("::CREAR EMPLEADO::");
            System.out.println("Ingrese el documento del empleado");
            String documento = sc.next();
            System.out.println("Ingrese el nombre del empleado");
            String nombre = sc.next();
            System.out.println("Ingrese las horas trabajadas");
            int horas  = sc.nextInt();
            System.out.println("Ingrese el valor de la hora");
            double valor = sc.nextDouble();
            listaEmpleados[i] = new Empleado(documento, nombre, horas, valor, calcularSueldo(horas,valor));
        }
        
    }

    private void modificarEmpleado() {
       int posicion=buscarEmpleado();
        if (posicion>=0){
            empleado =listaEmpleados[posicion];
            System.out.println("::MODIFICAR EMPLEADO::");
            System.out.println("Ingrese el nombre del empleado");
            String nombre = sc.next();
            empleado.setNombreEmpleado(nombre);
            System.out.println("Ingrese las horas trabajadas");
            int horas  = sc.nextInt();
            empleado.setHorasTrabajadas(horas);
            System.out.println("Ingrese el valor de la hora");
            double valor = sc.nextDouble();
            empleado.setValorHora(valor);
            empleado.setSueldo(calcularSueldo(horas,valor));
            listaEmpleados[posicion]=empleado;
        }
    }


    private int buscarEmpleado() {
        System.out.println("***Buscar empleado***");
        System.out.println("ingrese numero de documento:");
        String documento=sc.next();
        for (int i = 0; i < documento.length(); i++) {
            if (listaEmpleados[i].getDocumento().equalsIgnoreCase(documento)){
                return i;
            }
        }
        return -1;
    }
    private void imprimirempleado(){
        int posicion=buscarEmpleado();
        if (posicion>=0){}
        System.out.println("el empleado es: "+" "+empleado.getNombreEmpleado());
    }
    private void listarEmpleado() {
        System.out.println("listar empleados");
        for (int i = 0; i < listaEmpleados.length; i++) {
            System.out.println(listaEmpleados[i].getDocumento() + " | "+
                    listaEmpleados[i].getNombreEmpleado()
             +" "+ listaEmpleados[i].getSueldo());
        }
    }
    private double calcularSueldo(int horas,double valor) {
return horas*valor;
    }

}
