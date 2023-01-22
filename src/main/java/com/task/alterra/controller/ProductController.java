package com.task.alterra.controller;

import com.task.alterra.entity.ProductEntity;
import com.task.alterra.entity.ResponseMessage;
import com.task.alterra.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "Create Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a Product",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductEntity.class)) })})
    @PostMapping("")
    public ProductEntity createProduct(@RequestBody ProductEntity productEntity){
        return productService.createProduct(productEntity);
    }

    @Operation(summary = "Get All Products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get the Products")})
    @GetMapping("")
    public List<ProductEntity> getAllProducts(){
        return productService.getAllProducts();
    }

    @Operation(summary = "Update Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the Product",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductEntity.class)) })})
    @PutMapping("")
    public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductEntity productEntity) {
        return new ResponseEntity<>(productService.updateProduct(productEntity), HttpStatus.OK);
    }

    @Operation(summary = "Delete Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the Product",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content) })
    @DeleteMapping("/{productId}")
    public ResponseEntity<ResponseMessage> deleteProduct(@PathVariable Integer productId){
        return new ResponseEntity<>(productService.deleteProduct(productId), HttpStatus.OK);
    }
}
