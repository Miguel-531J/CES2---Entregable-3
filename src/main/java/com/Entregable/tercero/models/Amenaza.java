package com.Entregable.tercero.models;

import java.util.Stack;
import java.util.function.Function;


public class Amenaza {
    private final String name;
    private final Enum categoria;
    private final Enum tipo;
    private final Stack<Integer> conteo;

    public Amenaza(){
        this("", null, null, new Stack<>());
    }
    public Amenaza(String name, Categoria categoria, EnumAmenaza tipo, Stack<Integer> conteo) {
        super();
        this.name = name;
        this.categoria = categoria;
        this.tipo = tipo;
        this.conteo = conteo;
    }
    public String getName() {
        return name;
    }

    public Enum getCategoria() {
        return categoria;
    }

    public Enum getTipo() {
        return tipo;
    }

    public Stack<Integer> getConteo() {
        return conteo;
    }

    public void addStack(Integer num){
        this.conteo.push(num);
    }

    public Integer verTotales(Function<Amenaza, Integer> sumConteo){
        return sumConteo.apply(this);
    }

    @Override
    public String toString() {
        return "Amenaza{" +
                "name='" + name + '\'' +
                ", categoria='" + categoria + '\'' +
                ", tipo='" + tipo + '\'' +
                ", conteo=" + conteo +
                '}';
    }
}
