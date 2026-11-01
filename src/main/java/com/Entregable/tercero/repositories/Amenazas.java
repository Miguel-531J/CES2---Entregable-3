package com.Entregable.tercero.repositories;

import com.Entregable.tercero.models.Amenaza;
import com.Entregable.tercero.models.Categoria;
import com.Entregable.tercero.models.EnumAmenaza;


import java.util.List;
import java.util.Stack;
import java.util.ListIterator;
import java.util.ArrayDeque;

public class Amenazas {

    public final Stack<Amenaza> malwares = new Stack<>();

    public Amenazas() {
                malwares.push(new Amenaza("Ransomware.LockBit", Categoria.MEDIA, EnumAmenaza.MALWARE, crearStack(2, 2, 3, 4)));
                malwares.push(new Amenaza("Adware.PopUpSpy", Categoria.MEDIA, EnumAmenaza.MALWARE, crearStack(1, 2, 4, 8)));
                malwares.push(new Amenaza("virus_filter.exe", Categoria.MEDIA, EnumAmenaza.MALWARE, crearStack(2, 2, 2, 2)));
                malwares.push(new Amenaza("DATA.stealer", Categoria.MEDIA, EnumAmenaza.MALWARE, crearStack(3, 4, 5, 3)));
                malwares.push(new Amenaza("cryptominer.exe", Categoria.MEDIA, EnumAmenaza.MALWARE, crearStack(1, 1, 1, 1)));
    }

    public Stack<Amenaza> getMalwares() {
        return malwares;
    }

    public ListIterator<Amenaza> getListIterator() {
        return malwares.listIterator();
    }

    private static Stack<Integer> crearStack(Integer... numeros){
        Stack<Integer> stack = new Stack<>();
        for(Integer num : numeros){
            stack.push(num);
        }
        return stack;
    }
}
