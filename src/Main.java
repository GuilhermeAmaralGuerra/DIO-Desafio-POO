import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso("curso Java", "descrição curso java", 8);
        Curso curso3 = new Curso("curso Java", "descrição curso java", 8);
        Curso curso2 = new Curso("curso JS", "descrição curso JS",4);

        Mentoria mentoria = new Mentoria("Mentoria de java", "Descrição mentoria java", LocalDate.now());

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Descrição BootCamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(curso3);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        devCamila.progredir();
        devCamila.progredir();
        devCamila.Status();

        Dev devJoao = new Dev("João");
        devJoao.inscreverBootcamp(bootcamp);
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        devJoao.Status();

        Ranking ranking = new Ranking();

        ranking.adicionarDevs(devJoao);
        ranking.adicionarDevs(devCamila);

        ranking.mostrarRanking();

    }

}
