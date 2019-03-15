package dao;

import com.sun.org.apache.xpath.internal.operations.Mod;
import model.ProductModel;
import model.ProductModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductDAO {
    private final HashMap<String, ProductModel> productModelHashMap = new HashMap<>();

    public ProductDAO() {
        ProductModel Model1 = new ProductModel("Knife", 24.99);
        ProductModel Model2 = new ProductModel("Nike Shoe", 120.00);
        ProductModel Model3 = new ProductModel("Glasses", 15.99);

        productModelHashMap.put(Model1.getName(), Model1);
        productModelHashMap.put(Model2.getName(), Model2);
        productModelHashMap.put(Model3.getName(), Model3);
    }

    public ProductModel addProduct(ProductModel ProductModel) {
        productModelHashMap.put(ProductModel.getName(), ProductModel);
        return ProductModel;
    }

    public ProductModel getProduct(String name) {
        ProductModel ProductModel = productModelHashMap.get(name);

        if (name.equals(ProductModel.getName())) {
            return ProductModel;
        }

        return null;
    }

    public List<ProductModel> getAllProducts() {
        return new ArrayList<>(productModelHashMap.values());
    }
}
