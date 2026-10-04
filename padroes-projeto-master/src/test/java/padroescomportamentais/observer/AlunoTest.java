package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidatoTest {

    @Test
    void deveNotificarUmCandidato() {
        Vaga vaga = new Vaga(
                "DESENVOLVEDOR FRONT-END JÚNIOR",
                "Desenvolvimento e manutenção de interfaces web, criação de componentes e correção de problemas",
                "HTML e CSS - JavaScript - Git e GitHub - Noções de APIs REST - React",
                3500
        );

        Candidato candidato = new Candidato("Gabriele Almeida");

        candidato.lancarVaga(vaga);
        vaga.lancarVaga();

        assertEquals(
                "Gabriele Almeida, vaga lançada para: DESENVOLVEDOR FRONT-END JÚNIOR",
                candidato.getUltimaNotificacao()
        );
    }

    @Test
    void deveNotificarCandidatos() {
        Vaga vaga = new Vaga(
                "DESENVOLVEDOR JAVA JÚNIOR",
                "Desenvolvimento e manutenção de aplicações utilizando Java e Spring Boot",
                "Java - Spring Boot - SQL - APIs REST - Git",
                4800
        );

        Candidato candidato1 = new Candidato("Gabriele Almeida");
        Candidato candidato2 = new Candidato("João Silva");

        candidato1.lancarVaga(vaga);
        candidato2.lancarVaga(vaga);

        vaga.lancarVaga();

        assertEquals(
                "Gabriele Almeida, vaga lançada para: DESENVOLVEDOR JAVA JÚNIOR",
                candidato1.getUltimaNotificacao()
        );

        assertEquals(
                "João Silva, vaga lançada para: DESENVOLVEDOR JAVA JÚNIOR",
                candidato2.getUltimaNotificacao()
        );
    }

    @Test
    void naoDeveNotificarCandidato() {
        Vaga vaga = new Vaga(
                "DESENVOLVEDOR PYTHON",
                "Desenvolvimento de aplicações e APIs utilizando Python",
                "Python - Flask ou Django - SQL - APIs REST - Git",
                5000
        );

        Candidato candidato = new Candidato("Gabriele Almeida");

        vaga.lancarVaga();

        assertNull(candidato.getUltimaNotificacao());
    }

    @Test
    void deveNotificarSomenteCandidatoDaVaga() {
        Vaga vagaFrontEnd = new Vaga(
                "DESENVOLVEDOR FRONT-END JÚNIOR",
                "Desenvolvimento de interfaces web",
                "HTML - CSS - JavaScript - React",
                3500
        );

        Vaga vagaPython = new Vaga(
                "DESENVOLVEDOR PYTHON",
                "Desenvolvimento de aplicações utilizando Python",
                "Python - Django - Flask - SQL",
                5000
        );

        Candidato candidato1 = new Candidato("Gabriele Almeida");
        Candidato candidato2 = new Candidato("João Silva");

        candidato1.lancarVaga(vagaFrontEnd);
        candidato2.lancarVaga(vagaPython);

        vagaFrontEnd.lancarVaga();

        assertEquals(
                "Gabriele Almeida, vaga lançada para: DESENVOLVEDOR FRONT-END JÚNIOR",
                candidato1.getUltimaNotificacao()
        );

        assertNull(candidato2.getUltimaNotificacao());
    }
}