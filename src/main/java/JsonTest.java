import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Arrays;

public class JsonTest {
    JSONObject object;

    public JsonTest() {
        this.object = new JSONObject();
    }

    public void add(String hash,ArrayList<Integer> list){
        object.put(hash,list);
        object.put(hash, Arrays.asList(1,9,3));
        object.put("2", Arrays.asList(1,9,3));
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("JSONExample.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pw.write(object.toJSONString());
        pw.flush();
        pw.close();
    }
}
