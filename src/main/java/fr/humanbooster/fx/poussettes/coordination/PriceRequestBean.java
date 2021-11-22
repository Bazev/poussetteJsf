package fr.humanbooster.fx.poussettes.coordination;


import fr.humanbooster.fx.poussettes.service.DemandeDePrixService;
import fr.humanbooster.fx.poussettes.service.PoussetteService;
import fr.humanbooster.fx.poussettes.service.impl.DemandeDePrixServiceImpl;
import fr.humanbooster.fx.poussettes.service.impl.PoussetteServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "priceRequest")
@RequestScoped
public class PriceRequestBean {
    private DemandeDePrixService demandeDePrixService = new DemandeDePrixServiceImpl();
    private PoussetteService poussetteService = new PoussetteServiceImpl();

    public PriceRequestBean() {

    }
}

