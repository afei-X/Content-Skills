package com.afei.config.db;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;


@EnableConfigurationProperties(DbDomain.class)
@ConfigurationProperties(prefix = "mengWangBalance")
@Component
public class DbDomain {

   private String atMobile;

   public String getAtMobile() {
      return atMobile;
   }

   public void setAtMobile(String atMobile) {
      this.atMobile = atMobile;
   }
}

