package fr.humanbooster.fx.poussettes.coordination;


import fr.humanbooster.fx.poussettes.business.DemandeDePrix;
import fr.humanbooster.fx.poussettes.business.Option;
import fr.humanbooster.fx.poussettes.business.Poussette;
import fr.humanbooster.fx.poussettes.service.DemandeDePrixService;
import fr.humanbooster.fx.poussettes.service.OptionService;
import fr.humanbooster.fx.poussettes.service.PoussetteService;
import fr.humanbooster.fx.poussettes.service.impl.DemandeDePrixServiceImpl;
import fr.humanbooster.fx.poussettes.service.impl.OptionServiceImpl;
import fr.humanbooster.fx.poussettes.service.impl.PoussetteServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "priceRequestBean")
@RequestScoped
public class PriceRequestBean {
    private DemandeDePrixService demandeDePrixService = new DemandeDePrixServiceImpl();
    private PoussetteService poussetteService = new PoussetteServiceImpl();
    private OptionService optionService = new OptionServiceImpl();
    private List<Poussette> poussettes = null;
    private List<Option> options = null;
    public static  DemandeDePrix demandeDePrix = null;
    private String poussetteSelect;

    public PriceRequestBean() {
        poussettes = poussetteService.recupererPoussettes();
        options = optionService.recupererOptions();
        demandeDePrix = new DemandeDePrix();
        demandeDePrix.setDateDemande(new Date());
        poussetteService.recupererPoussette(poussetteSelect);


    }

    public String SendRequest() {
        demandeDePrix = demandeDePrixService.ajouterDemandeDePrix(demandeDePrix.getEmail(), poussetteSelect, demandeDePrix.getDateDebut(), demandeDePrix.getDateFin(), demandeDePrix.getInformationComplementaire());
        demandeDePrix.setOptions(options);
        System.out.println(demandeDePrix);
        return "confirmation";
    }

    public List<Poussette> getPoussettes() {
        return poussettes;
    }

    public DemandeDePrix getDemandeDePrix() {
        return demandeDePrix;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public void setDemandeDePrix(DemandeDePrix demandeDePrix) {
        this.demandeDePrix = demandeDePrix;
    }


    public void setPoussettes(List<Poussette> poussettes) {
        this.poussettes = poussettes;
    }

    public String getPoussetteSelect() {
        return poussetteSelect;
    }

    public void setPoussetteSelect(String poussetteSelect) {
        this.poussetteSelect = poussetteSelect;
    }
}

