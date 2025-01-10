import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Maps {
    public Object createMap(String stts) throws Exception {
        Map<String, String> status = new HashMap<String, String>();
        status.put("afk", "you have been inactive on group, please keep at least 5 days directly interacting with us.");
        status.put("active", "since you'd been active, you will be receiving a new key game: AKFJ2-KDKOD-C927F.");
        status.put("deactivate", "you do not have access.");
        Object result = status.get(stts);
        if (result == null) {
            throw new Exception(String.format("%s not found in options: [active, afk, deactivate]", stts));
        }
        return result;

        /*Iterator iterator = status.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Object value = status.get(key);
            if (key == stts) {
                return value;
            }
        }*/
    }
}
