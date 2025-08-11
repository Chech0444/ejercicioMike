import java.util.Scanner;

public class CuentaBancaria {
    String titular;
    Integer numeroCuenta;
    Integer saldo;

    public CuentaBancaria(String titular, Integer numeroCuenta, Integer saldo){
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public void mostrarDatos(){
        System.out.println("\nTitular: " + titular);
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Saldo: " + saldo);
    }

    public void depositarDinero(Integer cantidad){
        saldo += cantidad;
        System.out.println("\nSe ha depositado: " + cantidad);
        System.out.println("El saldo ahora es de: " + saldo);
    }

    public void retirarDinero(Integer cantidad){
        saldo -= cantidad;
        System.out.println("\nSe retiro: " + cantidad);
        System.out.println("El saldo restante es: " + saldo);
    }
    
    public void transferirDinero(CuentaBancaria cuenta, Integer cantidad){
        cuenta.saldo += cantidad;
        saldo -= cantidad;
        System.out.println("\nLa cuenta " + titular + " le transfirio " + cantidad + " a " + cuenta.titular);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CuentaBancaria cuenta = new CuentaBancaria("Prueba", 42342, 100000);
        CuentaBancaria cuentaDos = new CuentaBancaria("PruebaDos", 6463, 90000);
        while(true){

            System.out.println("\n1. Mostrar datos");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Transferir dinero");
            System.out.println("5. Salir");
            System.out.print("\nSeleccione: ");
            int opcion = scanner.nextInt();

            if(opcion == 1){
                cuenta.mostrarDatos();
                cuentaDos.mostrarDatos();
            } else if (opcion == 2){
                System.out.print("Ingrese la cantidad a depositar: ");
                int cantidad = scanner.nextInt();
                cuenta.depositarDinero(cantidad);
            } else if (opcion == 3){
                System.out.print("Ingrese la cantidad a retirar: ");
                int cantidad = scanner.nextInt();
                cuenta.retirarDinero(cantidad);
            } else if (opcion == 4){
                System.out.print("Ingrese la cantidad a transferir: ");
                int cantidad = scanner.nextInt();
                cuenta.transferirDinero(cuentaDos, cantidad);  
            } else if (opcion == 5) {
                System.exit(0);
            } else {
                System.out.print("Opcion incorrecta");
            }
        }
    }
}