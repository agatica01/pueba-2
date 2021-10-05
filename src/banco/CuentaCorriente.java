package banco;

public class CuentaCorriente extends Cuenta {

	private Double descubierto;
	private Double dineroAdeudado;

	public CuentaCorriente(Integer cbu, Double saldo) {
		super(cbu, saldo);
		this.descubierto = 150.0;
		this.dineroAdeudado = 0.0;
		setTipoCuenta(TipoCuenta.CORRIENTE);
	}

	@Override
	public Double extraer(Double importeAExtraer) {
		Double importeRetirado = 0.0;
		Double diferencia;

		if (importeAExtraer <= super.getSaldo()) {
			importeRetirado = super.extraer(importeAExtraer);
		}
		else if (importeAExtraer <= (super.getSaldo() + this.descubierto)) {
			diferencia = importeAExtraer - super.getSaldo();
			this.descubierto -= diferencia;
			this.dineroAdeudado += diferencia + (diferencia * 5) / 100;
			super.extraer(super.getSaldo());
			importeRetirado = importeAExtraer;
		}
		return importeRetirado;
	}

	@Override
	public Boolean depositar(Double importe) {
		Boolean seDeposito = false;
		
		if (this.dineroAdeudado != 0.0) {

			if (importe >= this.dineroAdeudado) {
				super.depositar(importe - this.dineroAdeudado);
				this.dineroAdeudado = 0.0;
				this.descubierto = 150.0;
				seDeposito = true;
			}
		}
		else {
			super.depositar(importe);
			seDeposito = true;
		}
		return seDeposito;
	}

	public Double getDescubierto() {
		return descubierto;
	}

	public Double getDineroAdeudado() {
		return dineroAdeudado;
	}

}
