package com.rich.common.knife4j.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xepxe
 * @date 2022/9/1 13:40
 * @desc
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
@ConfigurationProperties(prefix = "knife4j")
public class Knife4jProperty {
  /**
   * 组名
   */
  String groupName;
  /**
   * 标题
   */
  String title;
  /**
   * 描述
   */
  String description;
  /**
   * 版本号
   */
  String version;
  /**
   * 联系人姓名
   */
  String contactName;
  /**
   * 联系人地址
   */
  String contactUrl;
  /**
   * 联系人邮箱
   */
  String contactEmail;

}
