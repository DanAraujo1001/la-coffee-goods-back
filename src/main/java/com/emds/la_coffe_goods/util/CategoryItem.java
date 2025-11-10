package com.emds.la_coffe_goods.util;
import lombok.Getter;

@Getter
public enum CategoryItem {

    BEBIDA(1, "Bebida"),
    GRAO(2, "Grão de café"),
    SOBREMESA(3, "Sobrema"),
    SALGADO(4, "Salgado");

    private final Integer id;
    private final String category;

    CategoryItem(Integer id, String category){
        this.id = id;
        this.category = category;
    }

}
