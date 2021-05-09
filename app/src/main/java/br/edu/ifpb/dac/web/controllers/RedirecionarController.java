package br.edu.ifpb.dac.web.controllers;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;


@Named
@RequestScoped
public class RedirecionarController implements Serializable {


    public String listarIntegrantePorData() {
        return "listarPorData.xhtml";
    }

    public String buscarBandaLocal() {
        return "getBandaLocal.xhtml";
    }

    public String nextIndex() {
        return "nextIndex.xhtml";
    }
    public String porCpf() {
        return "getPorCpf.xhtml";
    }
    public String buscarBandaIntegrantes(){
        return "listarBandaIntegrante.xhtml";
    }

}
