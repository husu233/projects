package com.su.hpre.alipay.config;

import java.util.regex.Pattern;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import com.su.hpre.alipay.config.RootConfig.WebPackage;


@Configuration
@Import(DataConfig.class)
@ComponentScan(basePackages={"com.su.hpre.alipay"}, 
    excludeFilters={
        @Filter(type=FilterType.CUSTOM, value=WebPackage.class)
    })
public class RootConfig {
  public static class WebPackage extends RegexPatternTypeFilter {
    public WebPackage() {
      super(Pattern.compile("com\\.su\\.hpre\\.alipay\\.controller"));
    }    
  }
}
