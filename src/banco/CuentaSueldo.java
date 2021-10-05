package banco;

public class CuentaSueldo extends Cuenta {

	public CuentaSueldo(Integer cbu, Double saldo) {
		super(cbu, saldo);
		setTipoCuenta(TipoCuenta.SUELDO);
	}
	

}
