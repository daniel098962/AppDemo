package type.many.extend.pakage.appdemo.utils;

import type.many.extend.pakage.appdemo.data.AppProperties;

/**
 * Created by User on 2020/5/4.
 */

public class IpSumImageFactory {

    public static class ImageUrlReplace {
        //替換可顯示的圖片URL
        public static String replaceUrl(String url) {

            String ipSumImageUrl = "";
            //若有找到對應的URL字串
            if (url.indexOf(AppProperties.PLACEHOLDER_IMAGE_URL) != -1) {

                String slashColorCode = url.substring(url.lastIndexOf(AppProperties.SLASH));
                //將斜線色碼 改為逗號色碼 ex /000000 -> ,000000
                String commaColorCode = slashColorCode.replaceFirst(AppProperties.SLASH, AppProperties.COMMA);

                //正常長度應為7 小於7補齊
                if (commaColorCode.length() < 7) {

                    int gap = 7 - commaColorCode.length();

                    for (int i = 0; i < gap; i++) {

                        commaColorCode = commaColorCode.concat("0");
                    }
                }

                //將URL 替換 可顯示之網站URL 並替換成逗號+色碼
                ipSumImageUrl = url.replaceFirst(AppProperties.PLACEHOLDER_IMAGE_URL, AppProperties.IPSUNIMAGE_URL);
                ipSumImageUrl = ipSumImageUrl.replace(slashColorCode, commaColorCode);
            }

            return ipSumImageUrl;
        }
    }
}
