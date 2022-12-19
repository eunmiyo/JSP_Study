package ch08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map; //상위클래스

//HashMap<>()은 저장공간 순서없이 저장되서
//순서에 맞게 저장하려면 LinkedHashMap<>() 사용!

//DB역할, 데이터베이스없이 샘플데이터를 제공하기 위한 클래스
public class ProductService {
	Map<String, Product> products = new HashMap<>();
	
	public ProductService() {
		Product p = new Product("101", "아이폰12", "애플", 1200000, "2020.12.12");
		//상품리스트를 넣기위해 사용
		//put(key,value)
		products.put("101", p);
		
		p = new Product("102", "삼전우주폰", "삼성전자", 1300000, "2021.2.2");
		products.put("102", p);
		
		p = new Product("103", "엘스듀얼폰", "엘스전자", 1500000, "2021.3.2");
		products.put("103", p);
	}
	
	//모든 상품 데이터를 가져오는 메소드(select * from)
	public List<Product> findAll(){
		//values()는 map이 가지고 있는 value를 Collection 형태로 반환한다.
		//map의 value값만 가져온다!
		return new ArrayList<>(products.values());
	}
	
	//id로 원하는 상품을 가져오는 메소드(select * from where id="102")
	public Product find(String id) {
		return products.get(id);
	}
	
}
