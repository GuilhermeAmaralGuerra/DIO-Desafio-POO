import java.util.*;

public class Dev implements Comparable<Dev>{
    private String nome;
    private double xp;

    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String nome) {
        this.nome = nome;
    }

    @Override
    public int compareTo(Dev dev) {
        return Double.compare(dev.xp, this.xp);
    }

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {

        this.xp = this.conteudosConcluidos
                    .stream()
                    .mapToDouble(Conteudo::calcularXp)
                    .sum();

        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public void Status(){
        System.out.println("Status do Dev: " + this.nome);
        System.out.println("-------------------");
        System.out.println("Conteúdos Inscritos:" + this.conteudosInscritos);
        System.out.println("-------------------");
        System.out.println("Conteúdos Concluídos:" + this.conteudosConcluidos);
        System.out.println("-------------------");
        System.out.println("XP:" + this.calcularTotalXp());
        System.out.println("-------------------");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

}
