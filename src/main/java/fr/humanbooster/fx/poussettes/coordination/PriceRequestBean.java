package fr.humanbooster.fx.poussettes.coordination;


import fr.humanbooster.fx.poussettes.business.DemandeDePrix;
import fr.humanbooster.fx.poussettes.business.Poussette;
import fr.humanbooster.fx.poussettes.service.DemandeDePrixService;
import fr.humanbooster.fx.poussettes.service.PoussetteService;
import fr.humanbooster.fx.poussettes.service.impl.DemandeDePrixServiceImpl;
import fr.humanbooster.fx.poussettes.service.impl.PoussetteServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "priceRequest")
@RequestScoped
public class PriceRequestBean {
    private DemandeDePrixService demandeDePrixService = new DemandeDePrixServiceImpl();
    private PoussetteService poussetteService = new PoussetteServiceImpl();
    private List<Poussette> poussetteList = null;
    private DemandeDePrix demandeDePrix = null;

    public PriceRequestBean() {
        poussetteList = poussetteService.recupererPoussettes();
    }

    public String SendRequest() {
        demandeDePrix = demandeDePrixService.ajouterDemandeDePrix(demandeDePrix.getEmail(), demandeDePrix.getPoussetteSelectionnee(), demandeDePrix.getDateDebut(), demandeDePrix.getDateFin(), demandeDePrix.getInformationComplementaire())
    }
}

