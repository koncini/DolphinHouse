package com.dolphinhouse.dolphinhouse.contollers;

import com.dolphinhouse.dolphinhouse.models.domain.Product;
import com.dolphinhouse.dolphinhouse.models.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("catalog")
public class ProductController {

    @Value("${text.productController.catalog}")
    private String catalogText;

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("list", productList);
        model.addAttribute("title", catalogText);
        return "catalog";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product, Model model) {
        productService.addProduct(product);
        return "";
    }

    @PutMapping("/updateProduct/{id}")
    public String updateProduct(@RequestBody Product product ,@PathVariable Long id, Model model) {
        productService.updateProduct(product, id);
        return "";
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id , Model model) {
        productService.deleteProduct(id);
        return "";
    }

}
