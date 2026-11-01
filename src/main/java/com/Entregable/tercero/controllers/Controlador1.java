package com.Entregable.tercero.controllers;

import com.Entregable.tercero.models.*;
import com.Entregable.tercero.repositories.Amenazas;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.function.Function;

@org.springframework.stereotype.Controller
public class Controlador1 {

    Amenazas repoAmenazas = new Amenazas();
    PanoramaAme panorama = new PanoramaAme("Malwares", Categoria.MEDIA, EnumAmenaza.MALWARE, null);

    Function<Amenaza, Integer> sumConteo = amenaza -> {
        if (amenaza.getConteo() == null) {
            return 0;
        }
        return amenaza.getConteo().stream()
                .mapToInt(Integer::intValue)
                .sum();
    };

    private List<String> resultado = new ArrayList();
    @GetMapping("/peticionAmenazas1")
    public String peticionAmenazas1(Model model) {
        resultado.clear();

        resultado.add("Punto1");
        repoAmenazas.getMalwares().forEach(panorama::addAmenaza);

        resultado.add("=== AMENAZAS EN EL PANORAMA ===");

        ListIterator<Amenaza> iterator = repoAmenazas.getListIterator();

        Iterator<Amenaza> dequeIterator = panorama.getPanoAmenazas().iterator();

        resultado.add("--- Recorrido del STACK ---");
        while (iterator.hasNext()) {
            int index = iterator.nextIndex();
            Amenaza am = iterator.next();
            resultado.add("Nombre: " + am.getName() +
                    " | Categoría: " + am.getCategoria() +
                    " | Tipo: " + am.getTipo() +
                    " | Conteo: " + am.getConteo());
        }
        resultado.add("--- Recorrido del DEQUE ---");
        while (dequeIterator.hasNext()){
            Amenaza am = dequeIterator.next();
            resultado.add("Nombre: " + am.getName() +
            " | Categoría: " + am.getCategoria() +
                    " | Tipo: " + am.getTipo() +
                    " | Conteo: " + am.getConteo());
        }

        model.addAttribute("resultado", resultado);
        return "vista1";
    }

    @GetMapping("/peticionAmenazas2")
    public String peticionAmenazas2(Model model) {
        resultado.clear();

        resultado.add("Punto2");
        panorama.getPanoAmenazas().stream()
                .filter(amenaza -> amenaza.getCategoria() == Categoria.MEDIA)
                .forEach(amenaza -> resultado.add("Nombre: " + amenaza.getName() +
                        " | Categoría: " + amenaza.getCategoria() +
                        " | Tipo: " + amenaza.getTipo() +
                        " | Conteo: " + amenaza.getConteo()));

        model.addAttribute("resultado", resultado);
        return "vista1";
    }

    @GetMapping("/peticionAmenazas3")
    public String peticionAmenazas3(Model model) {
        resultado.clear();

        resultado.add("Punto3");
        resultado.add("=== SUMA DE CONTEOS POR AMENAZA (Function) ===");
        repoAmenazas.getMalwares().forEach(amenaza -> {
            Integer sumas = sumConteo.apply(amenaza);
            resultado.add("Amenaza" + amenaza.getName() +
                          "Conteo" + amenaza.getConteo() +
                          "Suma total" + sumas);
        });

        model.addAttribute("resultado", resultado);
        return "vista1";
    }

    @GetMapping("/peticionAmenazas4")
    public String peticionAmenazas4(Model model) {
        resultado.clear();

        resultado.add("Punto4");
        Amenaza amenaza1 = repoAmenazas.getMalwares().peek();
        Integer total = amenaza1.verTotales(sumConteo);
        resultado.add("la amenaza " + amenaza1.getName() + "tiene un conteo total de: " + total);


        model.addAttribute("resultado", resultado);
        return "vista1";
    }
}
