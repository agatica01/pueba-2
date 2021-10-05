package banco;

public class Cuenta {

	private Integer cbu;
	private Double saldo;
	private TipoCuenta tipoCuenta;
	
	public Cuenta(Integer cbu, Double saldo) {
		this.cbu = cbu;
		this.saldo = saldo;
	}
	
	public Boolean depositar(Double importe) {
		this.saldo += importe;
		return true;
	}

	public Double extraer(Double importeAExtraer) {
		Double importeRetirado = 0.;
		
		if(importeAExtraer <= this.saldo) {
			this.saldo -= importeAExtraer;
			importeRetirado = importeAExtraer;
		}
		return importeRetirado;
	}
	
	public Double getSaldo() {
		return saldo;
	}

	public Integer getCbu() {
		return cbu;
	}

	public void setCbu(Integer cbu) {
		this.cbu = cbu;
	}
	
	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

}
