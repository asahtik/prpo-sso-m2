package si.fri.prpo.govorilneure.m2.data;

public class Kanal {
    private static int id_inc = 1;

    private String ime, url, opis;
    private int id;

    public Kanal(String ime) {
        this.id = id_inc++;
        this.ime = ime;
    }

    public Kanal(String ime, String url) {
        this.id = id_inc++;
        this.ime = ime;
        this.url = url;
    }

    public Kanal(String ime, String url, String opis) {
        this.id = id_inc++;
        this.ime = ime;
        this.url = url;
        this.opis = opis;
    }

    public int getId() {
        return id;
    }

    public static int getNo() {
        return id_inc;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
