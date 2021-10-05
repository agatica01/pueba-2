package banco;

public class CajaDeAhorro extends Cuenta {

	private final Double COSTO_ADICIONAL = 6.0;
	private int num_extracciones;

	public CajaDeAhorro(Integer cbu, Double saldo) {
		super(cbu, saldo);
		this.num_extracciones = 0;
		setTipoCuenta(TipoCuenta.CAJA_DE_AHORRO);
	}

	@Override
	public Double extraer(Double importeAExtraer) {
		Double importeRetirado = 0.;
		this.num_extracciones++;

		if (this.num_extracciones > 5) {
			importeRetirado = super.extraer(importeAExtraer);
			importeRetirado -= COSTO_ADICIONAL;
		} else {
			importeRetirado = super.extraer(importeAExtraer);
		}
		return importeRetirado;
	}

}
