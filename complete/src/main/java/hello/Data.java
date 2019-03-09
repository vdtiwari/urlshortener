package hello;

public class Data {

    private final long id;
    private final String content;
    //-2,147,483,648 .. 2,147,483,647
    private  int hash;

    public Data(long id, String content) {
        this.id = id;
        this.content = content;
        this.hash=this.hashCode();
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getHash(){ return this.hash; }
}
