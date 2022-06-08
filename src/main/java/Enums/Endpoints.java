package Enums;

import lombok.Getter;

public enum Endpoints {
    PRODUCTS("/products") ,
    STORES("/stores") ,
    CATEGORIES("/categories");

    @Getter
    private final String url;

    Endpoints(String url)
    {
        this.url = url;
    }
}
