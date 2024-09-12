package dev.kefir213.restapi.product;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toEntity(ProductRequest request){
        if(request==null){
            return null;
        }
        return new Product(null, request.title(), request.description());
    }
}
