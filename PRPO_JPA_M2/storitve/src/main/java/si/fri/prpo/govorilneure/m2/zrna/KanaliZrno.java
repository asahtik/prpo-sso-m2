package si.fri.prpo.govorilneure.m2.zrna;

import si.fri.prpo.govorilneure.m2.data.Kanal;
import si.fri.prpo.govorilneure.m2.data.KanaliSeznam;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class KanaliZrno {

    private static final Logger log = Logger.getLogger(KanaliZrno.class.getName());

    @PostConstruct
    private void postConstruct() {
        log.info("Created "+KanaliZrno.class.getName()+" instance!");
    }
    @PreDestroy
    private void preDestroy() {
        log.info("Destroyed "+KanaliZrno.class.getName()+" instance!");
    }

    @Inject
    KanaliSeznam ks;

    public List<Kanal> pridobiVse() {
        return ks.getAll();
    }

    public Kanal pridobiZId(int id) {
        return ks.getById(id);
    }
}
