import java.util.Set;
import java.util.TreeSet;

public class Ranking {

    private Set<Dev> ranking = new TreeSet<>();

    public void setRanking(Set<Dev> ranking) {
        this.ranking = ranking;
    }

    public Set<Dev> getRanking() {
        return ranking;
    }

    public void adicionarDevs(Dev dev){
        ranking.add(dev);
    }

    public void mostrarRanking(){
        System.out.println("-- Ranking de XP --");
        int posicaoRanking = 0;

        for (Dev dev : ranking) {
            System.out.println(++posicaoRanking + " - " + dev.getNome() + " - " + dev.calcularTotalXp() + " XP");
        }

    }

}
