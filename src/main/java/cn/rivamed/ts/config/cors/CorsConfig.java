package cn.rivamed.ts.config.cors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
* <p>标题: CorsConfig.java</p>
* <p>业务描述:跨域配置类 </p>
* <p>公司:北京瑞华康源科技有限公司</p>
* <p>版权:rivamed-2018</p>
* @author 李飞
* @date 2018年8月21日
* @version V1.0
*/
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		// super.addCorsMappings(registry);
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowCredentials(true)
			.allowedMethods("GET", "POST", "DELETE", "PUT")
			.maxAge(3600);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		//设置日期格式
		ObjectMapper objectMapper = new ObjectMapper();
    	SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd");
    	objectMapper.setDateFormat(smt);
		mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
		//设置中文编码格式
		List<MediaType> list = new ArrayList<MediaType>();
		list.add(MediaType.APPLICATION_JSON_UTF8);
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
		converters.add(mappingJackson2HttpMessageConverter);
		super.configureMessageConverters(converters);
	}


}
