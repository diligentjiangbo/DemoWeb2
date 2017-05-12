package bo.jiang.demo.web2.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author shumpert.jiang
 * @date 2017/5/11 0011 16:01
 * 字符串工具类
 */
public final class StringUtil {

  /**
   * 判断字符串是否为空
   */
  public static boolean isEmpty(String str) {
    if (str != null) {
      str = str.trim();
    }
    return StringUtils.isEmpty(str);
  }

  /**
   * 判断字符串是否非空
   */
  public static boolean isNotEmpty(String str) {
    return !isEmpty(str);
  }

}
