package be.weve.testgenerator.business;

public class DomainClass {

    private String path;
    private boolean converted;

    public DomainClass() {
        converted = false;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isConverted() {
        return converted;
    }

    public void setConverted(boolean converted) {
        this.converted = converted;
    }
}
