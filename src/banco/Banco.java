package banco;

public class Banco {
	
	private Cliente cliente[];
	private Cuenta cuenta[];
	
	public Banco() {
		this.cliente = new Cliente[10];
		this.cuenta = new Cuenta[10];
	}
	
	public Boolean agregarCliente(Cliente cliente) {
		
		for (int i = 0; i < this.cliente.length; i++) {
			
			if(this.cliente[i] == null) {
				this.cliente[i] = cliente;
				return true;
			}
		}
		return false;
	}
	
	public Boolean agregarCuenta(Cuenta cuenta) {
		
		for (int i = 0; i < this.cuenta.length; i++) {
			
			if(this.cuenta[i] == null) {
				this.cuenta[i] = cuenta;
				return true;
			}
		}
		return false;
	}

	public Cliente[] getCliente() {
		return cliente;
	}

	public Cuenta[] getCuenta() {
		return cuenta;
	}

}
