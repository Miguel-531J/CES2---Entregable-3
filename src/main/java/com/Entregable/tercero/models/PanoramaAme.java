package com.Entregable.tercero.models;
import com.Entregable.tercero.models.Amenaza;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PanoramaAme {
    private final String name;
    private final Enum PanoCategoria;
    private final Enum PanoTipo;
    private final Deque<Amenaza> PanoAmenazas;

    public PanoramaAme(){
        this("", null, null, new ArrayDeque<>());
    }

    public PanoramaAme(String name, Categoria panoCategoria, EnumAmenaza panoTipo, Deque<Amenaza> panoAmenazas) {
        this.name = name;
        this.PanoCategoria = panoCategoria;
        this.PanoTipo = panoTipo;
        this.PanoAmenazas = (panoAmenazas != null) ? panoAmenazas : new ArrayDeque<>();
    }
    public String getName() {
        return name;
    }
    public Enum getPanoCategoria() {
        return PanoCategoria;
    }
    public Enum getPanoTipo() {
        return PanoTipo;
    }
    public Deque<Amenaza> getPanoAmenazas() {
        return PanoAmenazas;
    }
    public void addAmenaza(Amenaza amenaza){
        this.PanoAmenazas.add(amenaza);
    }
    public void cargarAmenazas(Stack<Amenaza> amenazas) {
        if (amenazas != null) {
            amenazas.forEach(this::addAmenaza);
        }
    }

}
