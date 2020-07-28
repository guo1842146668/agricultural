package com.puyan.shengren.agricultural;

import com.alibaba.fastjson.JSONObject;
import com.puyan.shengren.agricultural.Tool.CalculateUtil;
import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootTest
class AgriculturalApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    static void test1() throws MalformedURLException {
        Path outputFile = Paths.get("build/swagger");
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                . withMarkupLanguage(MarkupLanguage.MARKDOWN)
                . withOutputLanguage(Language.ZH)
                . withPathsGroupedBy(GroupBy.TAGS)
                . withGeneratedExamples()
                . withoutInlineSchema().build();
        Swagger2MarkupConverter converter =
                Swagger2MarkupConverter.from(new URL( "http://localhost:8080/v2/api-docs"))
                        . withConfig(config).build() ;
        converter. toFile(outputFile);
    }
    @Test
    static void test4() throws MalformedURLException {
        //    输出Ascii格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs"))
                .withConfig(config)
                .build()
                .toFolder(Paths.get("src/docs/asciidoc/generated/all"));
    }

    static  void test2(){
        System.out.println(new BigInteger(291 + "", 10).toString(16));
    }

    static double  test3(){
        CalculateUtil  calculateUtil=new CalculateUtil();
       return calculateUtil.getDistance(116.413384,39.910925, 112.459421,34.624263);
    }


   public static void main(String[] args) throws MalformedURLException {
       //test1();
        test4();
    }

    public static void getCityFromLngAndlat()
    {
//通过修改这里的location（经纬度）参数，即可得到相应经纬度的详细信息
        String url2 = "http://api.map.baidu.com/geocoder/v3/?ak=2AZzQQerSCIM1XYsUvWGMW2SPmXccC90&location=22.75424,112.76535&output=json&pois=1 ";
        URL myURL2 = null;
        URLConnection httpsConn2 = null;
        try {
            myURL2 = new URL(url2);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStreamReader insr2 = null;
        BufferedReader br2 = null;
        try {
            httpsConn2 = (URLConnection) myURL2.openConnection();// 不使用代理
            if (httpsConn2 != null) {
                insr2 = new InputStreamReader( httpsConn2.getInputStream(), "UTF-8");
                br2 = new BufferedReader(insr2);
                String data2 = br2.readLine();
                try
                {
                    //解析得到的json格式数据
                    JSONObject dataJson = new JSONObject(Boolean.parseBoolean(data2));
                    JSONObject result = dataJson.getJSONObject("result");
                    JSONObject addressComponent = result.getJSONObject("addressComponent");
                    String city = addressComponent.getString("city");

                    System.out.println("city = " + city);


                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }




}
