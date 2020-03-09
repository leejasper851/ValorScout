
import java.io.IOException;
import okhttp3.*;
import org.json.simple.*;
import org.json.simple.parser.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lee_934859
 */
public class ValorScout {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
            .header("X-TBA-Auth-Key", "j62Ln03NS6nIrke6c9YiRvRvDmNLSys92adlRZfoeEm1dcCPZ8OMRq2xDd6KtJDO")
            .url("https://www.thebluealliance.com/api/v3/event/a/teams")
            .build();
        
        JSONArray jsonArr = new JSONArray();
        String jsonStr = "";
        try (Response response = client.newCall(request).execute()) {
            jsonStr = response.body().string();
        }
        System.out.println("\"" + jsonStr + "\"");
        jsonArr = (JSONArray) new JSONParser().parse(jsonStr);
        for (Object obj : jsonArr) {
            JSONObject jsonObj = (JSONObject) obj;
            System.out.println(jsonObj.get("nickname"));
        }
    }
    
}
