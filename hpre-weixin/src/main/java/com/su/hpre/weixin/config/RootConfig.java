package com.su.hpre.weixin.config;

import java.util.regex.Pattern;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import com.su.hpre.weixin.config.RootConfig.WebPackage;

/**
 * 2017年4月5日 下午10:20:52
 * 
 * @author husu
 */

@Configuration
@Import(DataConfig.class)
@ComponentScan(basePackages = { "spittr" }, excludeFilters = {
		@Filter(type = FilterType.CUSTOM, value = WebPackage.class) })
public class RootConfig {
	public static class WebPackage extends RegexPatternTypeFilter {
		public WebPackage() {
			super(Pattern.compile("spittr\\.web"));
		}
	}
}
