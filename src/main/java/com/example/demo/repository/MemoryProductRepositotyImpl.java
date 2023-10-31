package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //얘네를 리파지토리라고 알려주고 나중에 주입시킬 것임
//인터페이스는 인스턴스화 할 수 없기에
//구현체를 인스턴스화 할수 있으므로 이것을 컴포넌트화 한다.

public class MemoryProductRepositotyImpl implements ProductRepository{
    //postRepository를 구현한 구현체
    //우선은 Map에 데이터를 저장할 것
    //구현체 만들고 조립해줘해서 생성자에 주입시켜야 함.

    private static Map<Integer, Product> productMap= new HashMap<>();
    private static int seq =0;

    public MemoryProductRepositotyImpl() {
        //시작할때마다 디폴트 데이터 값들
        Product product = Product.builder()
                            .productName("제품명1")
                            .maker("오리")
                            .price(15000)
                            .qty(100)
                            .build();
        insert(product);
        product = Product.builder()
                .productName("제품명2")
                .maker("오리")
                .price(10000)
                .qty(1000)
                .build();
        insert(product);
    }

    @Override
    public List<Product> findall() {

        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(int productId) {
        return productMap.get(productId);
    }

    @Override
    public Product insert(Product product) {

        int newProductId = ++seq;
        product.setProductId(newProductId);

        Product put = productMap.put(newProductId, product);
        return put;
    }

    @Override
    public Product deleteProduct(int productId) {

        Product removed = productMap.remove(productId);
        return removed;
    }

    @Override
    public Product updateProduct(int productId,Product product) {
        Product product1 = productMap.get(productId);

        if(findById(productId)!=null){
            product1.setQty(product.getQty());
            productMap.put(productId,product1);
        }
        return product;
    }

}
