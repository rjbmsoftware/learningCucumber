package stepDefinitions;

public class BaseDefinition {

    private String url = "http://localhost/api/v3/";
    private final int port = 80;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }
}
