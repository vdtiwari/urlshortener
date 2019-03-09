package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MyController {

    private final AtomicLong counter = new AtomicLong();
    private final static HashMap<Integer, String> AllURLs = new HashMap<>();

    @RequestMapping("/shorten")
    public int getitem(@RequestParam Map<String, String> queryParameters) {
        Data g = new Data(counter.incrementAndGet(),
                queryParameters.get("url"));
        AllURLs.put(g.getHash(), g.getContent());
        return g.getHash();

    }

    @RequestMapping("/geturlfromhash")
    public String geturl(@RequestParam Map<String, String> queryParameters) {
        String query = queryParameters.get("hash");
        String url = AllURLs.get(new Integer(query));
        return url;

    }
}
