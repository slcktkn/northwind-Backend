package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll() {

		return this.productService.getAll();

	}
	
	@GetMapping("/getProductWithcategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithcategoryDetails() {

		return this.productService.getProductWithcategoryDetails();

	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {

		return this.productService.add(product);
	}
	
	@GetMapping("/getbyproductname")
	public DataResult<Product>getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getbyproductnameandcategory")
	public DataResult<Product>getByProductNameAndCategory(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
		return this.productService.getByProductNameAndCategory(productName,categoryId);	
}
	@GetMapping("/getbyproductnamecontains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	@GetMapping("/getallbypage")
	public DataResult<List<Product>> getAll(int pageNo, int pagesize) {
		return this.productService.getAll(pageNo, pagesize);
	}
	
	@GetMapping("/getallsortedDESC")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}
}
