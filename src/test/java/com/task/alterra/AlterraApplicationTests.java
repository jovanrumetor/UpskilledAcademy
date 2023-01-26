package com.task.alterra;

import com.task.alterra.controller.ProductController;
import com.task.alterra.entity.ProductEntity;
import com.task.alterra.entity.ResponseMessage;
import com.task.alterra.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;


@SpringBootTest(classes={ProductController.class})
public class AlterraApplicationTests {

	@Mock
	private ProductService productService;

	@InjectMocks
	private ProductController productController;

	@Test
	@ExtendWith(OutputCaptureExtension.class)
	public void getProductsNoException_WillReturnCorrectResponse(CapturedOutput output) {
		// given
		List<ProductEntity> productList = new ArrayList<ProductEntity>();
		productList.add(new ProductEntity(1, "Soap", "Clean Body", 5, 500));
		productList.add(new ProductEntity(1, "Bean", "Nuts", 50, 50));
		given(productService.getAllProducts()).willReturn(productList);

		// when
		ResponseEntity<List<ProductEntity>> actualResponse = productController.getAllProducts();

		//
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals(productList, actualResponse.getBody());
		then(productService).should(times(1)).getAllProducts();
		assertThat(output).contains("[JOVAN] /getProducts is called");

	}

	@Test
	@ExtendWith(OutputCaptureExtension.class)
	public void addProductNoException_WillReturnCorrectResponse(CapturedOutput output) {
		//given
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName("Soap");
		productEntity.setDescription("Clean Body");
		productEntity.setStock(5);
		productEntity.setPrice(500);
		ProductEntity expectedProduct = new ProductEntity
				(1, productEntity.getName(), productEntity.getDescription(), productEntity.getStock(), productEntity.getPrice());
		given(productService.createProduct(productEntity)).willReturn(expectedProduct);

		//when
		ResponseEntity<ProductEntity> actualResponse = productController.createProduct(productEntity);

		//then
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals(expectedProduct, actualResponse.getBody());
		then(productService).should(times(1)).createProduct(productEntity);
		assertThat(output).contains("[JOVAN] /CreateProduct is called");
	}


	@Test
	@ExtendWith(OutputCaptureExtension.class)
	public void deleteProductException_WillReturnCorrectResponse(CapturedOutput output) {
		// given
		Random random = new Random();
		int id = random.nextInt();
		ProductEntity productEntity = new ProductEntity(id, "Soap", "Clean Body", 20, 500);
		ResponseMessage responseMessage = new ResponseMessage("Product Deleted");
		given(productService.deleteProduct(id)).willReturn(responseMessage);

		// when
		ResponseEntity<ResponseMessage> actualResponse = productController.deleteProduct(id);

		// then
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals(responseMessage, actualResponse.getBody());
		then(productService).should(times(1)).deleteProduct(id);
		assertThat(output).contains("[JOVAN] /DeleteProduct/{productId} is called");
	}

	@Test
	void contextLoads() {
	}

}
