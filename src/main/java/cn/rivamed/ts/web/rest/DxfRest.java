package cn.rivamed.ts.web.rest;




import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Api/dxf/dxfCtr")
public class DxfRest {
	
	
	
	
	@RequestMapping("getGojsPath")
	public String getGojsPathFromDxf() {
		return "hello";
	
		
	}
	
	@PostMapping(value="getGojsPath",consumes="application/json")
	public  String getGojsPathFromDxfRest() {
		
		return this.getGojsPathFromDxf();
	}
}
