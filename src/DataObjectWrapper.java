import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DataObjectWrapper {
    private Map<String, Object> map = new HashMap<String, Object>();


    public DataObjectWrapper(){

    }

    public void add(String key, Object value){
        map.put(key,value);
    }

    public <T extends Object> T get(String key) {
        return (T) map.get(key);
    }

    public String objToString(){
        String mapAsString = map.keySet().stream()
                .map(key -> key + "=" + map.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
        return mapAsString;

    }

}
