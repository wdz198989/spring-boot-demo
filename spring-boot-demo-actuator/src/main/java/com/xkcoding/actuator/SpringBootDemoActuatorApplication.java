package com.xkcoding.actuator;

import cn.hutool.core.util.StrUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @package: com.xkcoding.actuator
 * @description: 启动类
 * @author: yangkai.shen
 * @date: Created in 2018/9/29 2:27 PM
 * @copyright: Copyright (c)2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@SpringBootApplication
@RestController
public class SpringBootDemoActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoActuatorApplication.class, args);
	}

  /**
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
}
