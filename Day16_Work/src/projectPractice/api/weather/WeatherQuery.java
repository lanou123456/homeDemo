package projectPractice.api.weather;


import net.sf.json.JSONObject;

import java.io.*;
import java.net.URL;


public class WeatherQuery {
    public static void Weather(String city) throws IOException {

        //统一资源定位符，就是一个网址（绝对路径）
        URL url = new URL(" http://api.k780.com/?app=weather.today&weaid="+city+"& appkey=30522&sign=23e66de6ea94d0ac260642a9b714bffe &format=json");

        InputStream in=url.openStream();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }  finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray( );

        String result = new String(String.valueOf(out));

       JSONObject jsonObject = JSONObject.fromObject(result);

        WeaterData book = (WeaterData) JSONObject.toBean(jsonObject,WeaterData.class);
        System.out.println(book.getResult().toString());
        }
}

