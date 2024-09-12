package dev.kefir213.restapi.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResponseEntity<Product> create(
            @RequestBody @Valid ProductRequest request
    ){
        return ResponseEntity.ok(service.saveProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{ProductId}")
    public ResponseEntity<Product> getProductById(
            @PathVariable("ProductId") UUID productId
    ){
        return ResponseEntity.ok(service.findById(productId));
    }
    @PutMapping("/{ProductId}")
    public ResponseEntity<Product> changeProduct(
            @RequestBody @Valid ProductRequest request,
            @PathVariable("ProductId") UUID id
    ){
        return ResponseEntity.ok(service.patch(request, id));
    }

    @DeleteMapping("/{ProductId}")
    public ResponseEntity<?> deleteProduct(
            @PathVariable("ProductId") UUID productId
    ){
        service.delete(productId);
        return ResponseEntity.accepted().build();
    }
}
