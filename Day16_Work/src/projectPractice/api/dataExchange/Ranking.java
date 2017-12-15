package projectPractice.api.dataExchange;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.dom4j.DocumentException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class Ranking {

    public static  void Rank() throws IOException, DocumentException {

        URL url =new URL("http://192.168.20.194:8080/day16/ten");
        InputStream in=url.openStream();
        ByteArrayOutputStream out=new ByteArrayOutputStream();

            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);

        }
            if (in != null) {
                in.close();

        }
        byte b[]=out.toByteArray( );
       String str = new String(b);

        JSONArray jsonArray = JSONArray.fromObject(str);
        for (int i = 0; i <jsonArray.size() ; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            System.out.println("名字："+jsonObject.get("nickname")+"分数："+jsonObject.get("score"));

        }



//
//        JSONObject jsonObject = JSONObject.fromObject(out);
//        RankData rankData = (RankData) JSONObject.toBean(jsonObject,RankData.class);
//        System.out.println(new String(String.valueOf(rankData)));
    }
}
