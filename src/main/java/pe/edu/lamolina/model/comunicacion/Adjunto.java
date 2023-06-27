package pe.edu.lamolina.model.comunicacion;

import java.io.Serializable;

public class Adjunto implements Serializable {

    private String filename;
    private String url;
    private String mime;
    private Boolean uploaded;

    public Adjunto() {
    }

    public Adjunto(String filename, String url, String mime, Boolean uploaded) {
        this.filename = filename;
        this.url = url;
        this.mime = mime;
        this.uploaded = uploaded;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public Boolean getUploaded() {
        if (uploaded == null) {
            return false;
        }
        return uploaded;
    }

    public void setUploaded(Boolean uploaded) {
        this.uploaded = uploaded;
    }

}
