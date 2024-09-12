package dev.kefir213.restapi.product;

import dev.kefir213.restapi.exceptions.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    public Product saveProduct(ProductRequest request){
        return repository.save(mapper.toEntity(request));
    }
    public Product patch(ProductRequest request, UUID id) {
        Product toPatch = repository.findById(id).orElseThrow(()->new ProductNotFoundException(String.format("No product found with provided id: %s", request.id())));
        updateProduct(toPatch,request);
        return repository.save(toPatch);
    }

    public void delete(UUID productId) {
        repository.deleteById(productId);
    }

    private void updateProduct(
            Product toPatch, ProductRequest request
    ){
        if(StringUtils.isNotBlank(request.title())){
            toPatch.setTitle(request.title());
        }
        if(StringUtils.isNotBlank(request.description())){
            toPatch.setDescription(request.description());
        }
    }
    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(UUID productId) {
        return repository.findById(productId).orElseThrow(()->new ProductNotFoundException(String.format("No product found with provided id: %s", productId)));
    }
}
