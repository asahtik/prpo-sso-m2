package si.fri.prpo.govorilneure.m2.data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class KanaliSeznam {
    private List<Kanal> kanali = new LinkedList<Kanal>();

    @PostConstruct
    private void init() {
        kanali.add(new Kanal("Zoom"));
        kanali.add(new Kanal("Microsoft Teams"));
        kanali.add(new Kanal("BBB"));
    }

    public Kanal getById(int id) {
        for(Kanal i : kanali) {
            if(i.getId() == id) return i;
        }
        return null;
    }

    public List<Kanal> getAll() {
        return kanali;
    }

    public List<Kanal> add(Kanal n) {
        kanali.add(n);
        return kanali;
    }

    public void remove(Kanal r) {
        kanali.remove(r);
    }

    @Override
    public String toString() {
        String ret = "";
        for(Kanal i : kanali) {
            ret+=i.getIme() + ",";
        }
        return ret.substring(0, ret.length()-1); // -2?
    }
}
