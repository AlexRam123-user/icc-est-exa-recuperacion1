package Controllers;

import Models.Persona;

/**
 * Controlador para manejar la lógica de operaciones sobre arrays de Carross.
 * 
 * 
 * Generar los metdoos necesarions para ordenar un array de personas por edad en
 * orden descendente
 * y para la busqueda binaria de una persona por edad.
 * 
 */
public class PersonaController {

    public void ordenarPorEdad(Persona[] personas) {
        int n = personas.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (personas[j].edad > personas[maxIdx].edad) {
                    maxIdx = j;
                }
            }
            Persona temp = personas[maxIdx];
            personas[maxIdx] = personas[i];
            personas[i] = temp;
        }
    }

    public int buscarPorEdad(Persona[] personas, int edadBuscada) {
        int inicio = 0;
        int fin = personas.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (personas[medio].edad == edadBuscada) {
                return medio;
            } else if (personas[medio].edad < edadBuscada) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }
        return -1;
    }

    public void ordenarPorNombre(Persona[] personas) {
        int n = personas.length;
        for (int i = 1; i < n; i++) {
            Persona actual = personas[i];
            int j = i - 1;
            while (j >= 0 && personas[j].nombre.compareTo(actual.nombre) > 0) {
                personas[j + 1] = personas[j];
                j--;
            }
            personas[j + 1] = actual;
        }
    }

    public int buscarPorNombre(Persona[] personas, String nombreBuscado) {
        int inicio = 0;
        int fin = personas.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = personas[medio].nombre.compareTo(nombreBuscado);
            if (comparacion == 0) {
                return medio;
            } else if (comparacion > 0) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }
        return -1;
    }
}