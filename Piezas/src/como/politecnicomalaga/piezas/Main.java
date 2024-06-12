package como.politecnicomalaga.piezas;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	
	public static boolean writeText(String fileName, String data, boolean sobreescribe) {
		FileWriter fo = null;
		PrintWriter pw = null;
		boolean resultado = false;	
		try {
			if (sobreescribe) { //true
				fo = new FileWriter(fileName); 
			} else { //False
				fo = new FileWriter(fileName,true); 
			}
			//fo = new FileWriter(fileName); //Abrimos el fichero, modo append false
			pw = new PrintWriter(fo); //Creamos el ayudante
			
			pw.print(data);

			pw.flush();

			fo.close();
			fo = null;
			resultado = true;

		}catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("No se pudo abrir el fichero");		
		}
		finally {
			if (fo != null) {
				try {
					fo.close();
				} catch (IOException ioe) {
					System.out.println(ioe.getMessage());
				}

			}
		}
		return resultado;
	}

	public static String readText(String fileName) { 
	
		String resultado = "";
		FileReader fi = null;
		Scanner sc = null;
		try {
			fi = new FileReader(fileName);
	        sc = new Scanner(fi);
			
			while (sc.hasNext()) {
	            resultado += sc.nextLine() + "\n";	
			}
			fi.close();
			fi = null;
	
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (fi != null) {
				try {
					fi.close();
				} catch (IOException ioe) {
					System.out.println(ioe.getMessage());
				}
			}
		}
		return resultado;
	}
	
	
	
	
	public static void main(String args[]) {
		
		
		Map <Integer, SparePart> misPiezas;
		misPiezas = new HashMap<>();
		
		
		
		Scanner sc = new Scanner(System.in);
		int resp=0;
		boolean loop = true;
		String ruta;
		int codigoPieza;
		
		while(loop==true) {
			System.out.println("Piezas mecánicas");	
			System.out.println("--------------------");
			System.out.println("1. Cargar un archivo json");
			System.out.println("2. Mostrar pieza por pantalla");
			System.out.println("3. Guardar pieza en json");
			System.out.println("4. Salir");
			
			try {
				resp=Integer.valueOf(sc.nextLine());
			}catch(NumberFormatException n) {
				System.out.println("Opción no válida");
			}finally {
				if(resp<1 || resp>4) {
					System.out.println("Opción no válida");
				}
			}
			switch(resp) {
			case 1:
				System.out.println("Introduzca que tipo de pieza va a cargar:");
				System.out.println("1. Componente");
				System.out.println("2. Pieza suelta");
				
				try {
					resp=Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("Opción no válida");
					break;
				}finally {
					if(resp<1 || resp>2) {
						System.out.println("Opción no válida");
						break;
					}
				} 
				if(resp==1) {
					System.out.println("Introduzca la ruta del archivo json a cargar");
					ruta = sc.nextLine();
					
					if(!ruta.isBlank()) {
						Gson gson = new Gson();
						String leerComponente = readText(ruta);
						
						Component compAgregado = gson.fromJson(leerComponente, Component.class);
						if(compAgregado!=null) {
							misPiezas.put(compAgregado.getCode(), compAgregado);
							System.out.println("Componente agregado correctamente");
						}
					}else {
						System.out.println("No se pudo cargar el archivo");
					}
				}else {
					System.out.println("Introduzca la ruta del archivo json a cargar");
					ruta = sc.nextLine();
					
					if(!ruta.isBlank()) {
						Gson gson = new Gson();
						String leerComponente = readText(ruta);
						SparePart piezaAgregada = gson.fromJson(leerComponente, SparePart.class);
						if(piezaAgregada!=null) {
							misPiezas.put(piezaAgregada.getCode(), piezaAgregada);
							System.out.println("Pieza agregada correctamente");	
						}
					}else {
						System.out.println("No se pudo cargar el archivo");
					}
				}
				break;
			case 2:
				System.out.println("Introduzca el código de la pieza a mostrar");
				try {
					codigoPieza = Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("Formato de código no válido");
					break;
				}
				SparePart pieza = misPiezas.get(codigoPieza);
                if (pieza != null) {
                    System.out.println("Pieza: " + pieza);
                } else {
                    System.out.println("No existe ninguna pieza con ese código.");
                }
                break;
				
				
			case 3:
				System.out.println("Introduzca el código de la pieza a guardar:");
                try {
                    codigoPieza = Integer.valueOf(sc.nextLine());
                } catch (NumberFormatException n) {
                    System.out.println("Formato de código no válido");
                    break;
                }

                pieza = misPiezas.get(codigoPieza);
                if (pieza != null) {
                    System.out.println("Introduzca la ruta del archivo json a guardar:");
                    ruta = sc.nextLine();
                    Gson gson = new Gson();
                    String json = gson.toJson(pieza);
                    writeText(ruta+".json", json, true);
                    System.out.println("Pieza guardada correctamente.");
                } else {
                    System.out.println("No existe ninguna pieza con ese código.");
                }
                break;
			case 4:
				System.out.println("Adios");
				loop=false;
			}
			
			
		}
		
	}
}
