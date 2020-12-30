package ejercicioTrainee;


public class SalidaPorConsola {
	
	static Vehiculo[] listadoDeAutos = new Vehiculo[100];
	int indice = 0;
	
	public static void main(String[] args) {
		Auto vehiculo1 = new Auto("Peugeot", "206",200000, 4);
		Moto vehiculo2 = new Moto("Honda", "Titan", 60000, "125cc");
		Auto vehiculo3 = new Auto("Peugeot", "208", 250000, 5);
		Moto vehiculo4 = new Moto("Yamaha", "YBR", 80500.50, "160cc");
		
		SalidaPorConsola concesionaria = new SalidaPorConsola();
		
		//Adding the vehicles to the array
		concesionaria.addNewVehicle(vehiculo1);
		concesionaria.addNewVehicle(vehiculo2);
		concesionaria.addNewVehicle(vehiculo3);
		concesionaria.addNewVehicle(vehiculo4);

		//Getting the car list
		concesionaria.carList();
			
		System.out.println("=============================");	
		concesionaria.compareArrayElements();
		
		
		System.out.println("\n=============================");
		
		System.out.println("Vehículos ordenados por precio de mayor a menor: ");
		
		Vehiculo aux= null;
		//Sorting the array
		for(int i= 0; i < listadoDeAutos.length; i++){
			for(int j= i +1; j < listadoDeAutos.length; j++){
				if(listadoDeAutos[i] != null && listadoDeAutos[j] != null){
					if(listadoDeAutos[i].precio < listadoDeAutos[j].precio){
						aux = listadoDeAutos[i];
						listadoDeAutos[i] = listadoDeAutos[j];
						listadoDeAutos[j] = aux;
					}
					
				}
				
			}
			
		}
		
		// Printing from the highest price to the lowest price
		for(Vehiculo vehiculo : listadoDeAutos){
			if(vehiculo != null){
				System.out.println(vehiculo.marca + " " + vehiculo.modelo);
			}	
		}
		
		
	}
	
	//Method to add new Vehicles
	public void addNewVehicle( Vehiculo nuevo){
		listadoDeAutos[indice] = nuevo;
		indice++;
	}
	
	//Method to get the list with all vehicles details
	public void carList(){
		for (Vehiculo vehiculo : listadoDeAutos){
			if(vehiculo != null){
				vehiculo.getDetalles();
			}
		}
	}
	
	
	public void compareArrayElements(){
		//Asigno el vehículo más caro, más barato y el que contiene Y a referencias de Vehiculo. 
		Vehiculo vehiculoMasCaro = null;
		Vehiculo vehiculoMasBarato = null;
		Vehiculo vehiculoConLetraY = null;
		
		double mayor, menor;
		int n = 0; // indice para asignarle el valor a mayor y menor según posición del arreglo listadoDeAutos
		mayor = menor = listadoDeAutos[n].precio;
		
		for(int i=0; i < listadoDeAutos.length; i++){
			if(listadoDeAutos[i] != null){
				if(listadoDeAutos[i].precio > mayor){
					vehiculoMasCaro = listadoDeAutos[i];
				
				}if(listadoDeAutos[i].precio < menor){
					vehiculoMasBarato = listadoDeAutos[i];
					menor = listadoDeAutos[n + 1].precio;
					
				
				}if(listadoDeAutos[i].modelo.contains("Y")){
					vehiculoConLetraY = listadoDeAutos[i];
				}
			}
			
			
		}
		
		// Impresión en pantalla de las referencias declaradas arriba
		System.out.println("Vehículo más caro: " + vehiculoMasCaro.marca + " " + vehiculoMasCaro.modelo);
		System.out.println("Vehículo más barato: " + vehiculoMasBarato.marca + " " + vehiculoMasBarato.modelo);
		
		System.out.printf("Vehículo que contiene en el modelo la letra 'Y': " +
		vehiculoConLetraY.marca + " " + vehiculoConLetraY.modelo + " $%.2f", vehiculoConLetraY.precio);
	}
	
}
