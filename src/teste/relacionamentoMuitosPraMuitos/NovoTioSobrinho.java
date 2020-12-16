package teste.relacionamentoMuitosPraMuitos;

import infra.DAO;
import modelo.relacionamentoMuitosPraMuitos.Sobrinho;
import modelo.relacionamentoMuitosPraMuitos.Tio;

public class NovoTioSobrinho {

    public static void main(String[] args) {
        Tio tio1 = new Tio("João");
        Tio tia2 = new Tio("Maria");

        Sobrinho sobrinho1 = new Sobrinho("Davi");
        Sobrinho sobrinha2 = new Sobrinho("Ana");

        tio1.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tio1);

        tio1.getSobrinhos().add(sobrinha2);
        sobrinha2.getTios().add(tio1);

        tia2.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tia2);

        tia2.getSobrinhos().add(sobrinha2);
        sobrinha2.getTios().add(tia2);

        DAO<Object> dao = new DAO<>();
        
        dao.abrirTransacao()
                .incluirTransacao(tio1)
                .incluirTransacao(tia2)
                .incluirTransacao(sobrinho1)
                .incluirTransacao(sobrinha2)
                .fecharTransacao()
                .fechar();

    }
}
