package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import banco.Banco;
import banco.CajaDeAhorro;
import banco.Cliente;
import banco.Cuenta;
import banco.CuentaCorriente;
import banco.CuentaSueldo;
import banco.TipoCuenta;

public class TestBanco {

	@Test
	public void queSePuedaAgregarUnCliente() {
		Banco banco = new Banco();

		Cliente cliente = new Cliente("Martin", 42283532);
		assertTrue(banco.agregarCliente(cliente));
	}

	@Test
	public void queSePuedaAgregarUnaCuenta() {
		Banco banco = new Banco();

		Cuenta cuenta = new Cuenta(0002420, 100000.0);
		assertTrue(banco.agregarCuenta(cuenta));
	}

	@Test
	public void queSePuedaSaberElTipoDeCuenta() {
		CuentaSueldo cuenta1 = new CuentaSueldo(0002420, 100000.0);
		assertEquals(TipoCuenta.SUELDO, cuenta1.getTipoCuenta());

		CajaDeAhorro cuenta2 = new CajaDeAhorro(0002420, 100000.0);
		assertEquals(TipoCuenta.CAJA_DE_AHORRO, cuenta2.getTipoCuenta());

		CuentaCorriente cuenta3 = new CuentaCorriente(0002420, 100000.0);
		assertEquals(TipoCuenta.CORRIENTE, cuenta3.getTipoCuenta());
	}

	@Test
	public void queSePuedanMostrarLosDatosDelCliente() {
		Cliente cliente = new Cliente("Martin", 42283532);
		assertNotNull(cliente.mostrarDatos());
	}

	@Test
	public void queNoSePuedaRetirarPlantaCuandoMeDescuentanElCostoAdicionalYQuieroRetirarMasDelSaldoActual() {
		CajaDeAhorro cuentaPrueb = new CajaDeAhorro(2468, 100.0);
		Double valorEspera = 44.0;
		cuentaPrueb.extraer(10.0);
		cuentaPrueb.extraer(10.0);
		cuentaPrueb.extraer(10.0);
		cuentaPrueb.extraer(10.0);
		cuentaPrueb.extraer(10.0);
		cuentaPrueb.extraer(6.0);
		assertEquals(valorEspera, cuentaPrueb.getSaldo());
	}

}
