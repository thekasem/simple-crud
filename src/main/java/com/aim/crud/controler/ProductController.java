package com.aim.crud.controler;

import com.aim.crud.domain.Product;
import com.aim.crud.repository.ProductRepository;
import com.aim.crud.service.ProductServiceImpl;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/product")
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    public List<Product> Products()  {

        return productRepository.findAll();
    }

    @PostMapping
    public  Product insert(@RequestBody Product productFormView) {

        return  productService.save(productFormView);
    }

    @PostMapping(path = "/delete")
    public  void  delete(@RequestBody Product productFormView){
        productRepository.delete(productFormView);
    }
}
