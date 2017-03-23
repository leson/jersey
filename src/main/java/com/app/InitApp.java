package com.app;

import org.glassfish.jersey.server.ResourceConfig;

import com.colobu.fastjson.FastJsonProvider;

public class InitApp extends ResourceConfig {
	public InitApp() {

		// 扫描服务类所在的包路径
		packages("com.example");
		// 注册JSON转换器
		register(FastJsonProvider.class);

	}
}