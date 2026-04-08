import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Cuenta {
    private String codCuenta;
    private double saldo;
    private String nombreCuentaHabiente;
    private String fechaCreacion;
    private int cantDepositosRealizados;
    private int cantRetirosExitososRealizados;
    private static int cantCuentasCreadas = 0;

    public Cuenta(String nombreCuentaHabiente, double pSaldo) {
        this.nombreCuentaHabiente = nombreCuentaHabiente;
        this.saldo = pSaldo;
        this.cantDepositosRealizados = 0;
        this.cantRetirosExitososRealizados = 0;
        cantCuentasCreadas++;
        this.codCuenta = "cta-" + cantCuentasCreadas;
        this.fechaCreacion = generarFecha();
    }

    public Cuenta(double pSaldo) {
        this.nombreCuentaHabiente = "Sin asignar";
        this.saldo = pSaldo;
        this.cantDepositosRealizados = 0;
        this.cantRetirosExitososRealizados = 0;
        cantCuentasCreadas++;
        this.codCuenta = "cta-" + cantCuentasCreadas;
        this.fechaCreacion = generarFecha();
    }

    private String generarFecha() {
        Date fecha = new Date(System.currentTimeMillis());
        DateFormat formato = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        return formato.format(fecha);
    }

    public void setNombreCuentaHabiente(String pNombreCuentaHabiente) {
        this.nombreCuentaHabiente = pNombreCuentaHabiente;
    }

    public String getCodCuenta() {
        return codCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            this.cantDepositosRealizados++;
        }
        return this.saldo;
    }

    public double retirar(double monto) {
        if (validarRetiro(monto)) {
            this.saldo -= monto;
            this.cantRetirosExitososRealizados++;
        }
        return this.saldo;
    }

    private boolean validarRetiro(double monto) {
        return monto > 0 && monto <= this.saldo;
    }

    public static int getCantCuentasCreadas() {
        return cantCuentasCreadas;
    }

    public String toString() {
        return "Código: " + codCuenta + 
               " | Cliente: " + nombreCuentaHabiente + 
               " | Saldo: " + saldo + 
               " | Depósitos: " + cantDepositosRealizados + 
               " | Retiros exitosos: " + cantRetirosExitososRealizados + 
               " | Fecha creación: " + fechaCreacion;
    }
}