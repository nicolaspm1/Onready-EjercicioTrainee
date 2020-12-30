package ejercicioTrainee;

public class Auto extends Vehiculo {
	private int puertas;
	
	public Auto(String marca, String modelo, double precio, int puertas){
		super(marca, modelo, precio);
		this.puertas = puertas;
	}
	
	
	public void setPuertas(int p){
		puertas = p;
	}
	
	
	public int getPuertas(){
		return puertas;
	}
	
	@Override
	public void getDetalles(){
		System.out.printf("Marca: " + marca +
				" // Modelo: %s // Puertas: %d // Precio: $%.2f \n", modelo, puertas, precio);
	}
}
