package br.edu.ifpb.dac.main;

import br.edu.ifpb.dac.domain.*;
import br.edu.ifpb.dac.service.BandaService;
import br.edu.ifpb.dac.service.IntegranteService;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        LocalDate localDate= LocalDate.of(2015, 07, 22);
        CPF cpf = new CPF("05584381308");
        CPF cpf2 = new CPF("05584381310");
        Integrante integrante = new Integrante("Jose carlos", localDate,cpf);
        Integrante integrante2 = new Integrante("Katia carlos", localDate,cpf2);




        Banda banda =  new Banda();

        Gerente gerente = new Gerente("Lucas Carlos",banda,"lucascarlos@hotmail.com",cpf);

        banda.setGerente(gerente);
        banda.getIntegrantes().add(integrante);
        banda.getIntegrantes().add(integrante2);
        banda.setLocalDeOrigem("umari");
        banda.setNomeFantasia("Forro Moral");
        gerente.setBanda(banda);


        BandaService bandaService = new BandaService();
        bandaService.salvar(banda);


        System.out.println("Ver se gravou");


        System.out.println(bandaService.bandaByLocalDeOrigem("umari"));

        IntegranteService integranteService =  new IntegranteService();
        System.out.println(integranteService.integrantePorNascimento());
        System.out.println(integranteService.integranteComCPF("05584381310"));


    }
}
