package com.xkcoding.helloworld;

import cn.hutool.core.util.StrUtil;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * SpringBoot启动类
 * </p>
 *
 * @package: com.xkcoding.helloworld
 * @description: SpringBoot启动类
 * @author: yangkai.shen
 * @date: Created in 2018/9/28 2:49 PM
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: yangkai.shen
 */
@SpringBootApplication
//@RestController
public class SpringBootDemoHelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoHelloworldApplication.class, args);
	}

	/**rr
	 * Hello，World
	 *
	 * @param who 参数，非必须
	 * @return Hello, ${who}
	 */
	@GetMapping("/hello")
	public String sayHello(@RequestParam(required = false, name = "who") String who) {
		if (StrUtil.isBlank(who)) {
			who = "World";
		}
		return StrUtil.format("Hello, {}!", who);
	}

/*	@RequestMapping(value = "/Curry")
  public void Curry(){
    System.out.println("库里上场打球了！！");
  }*/

  /**
   *   注入bean（不注入，貌似也可以实现）
   * @param applicationName
   * @return
   */
 /* @Bean
  MeterRegistryCustomizer<MeterRegistry> configurer(
    @Value("${spring.application.name}") String applicationName) {
    return (registry) -> registry.config().commonTags("application", applicationName);
  }*/
}

