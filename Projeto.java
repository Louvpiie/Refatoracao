import java.time.LocalDate;

class Projeto {
    private String nome;
    private LocalDate prazo;
    private Funcionario responsavel;

    // Construtor completo
    public Projeto(String nome, LocalDate prazo, Funcionario responsavel) {
        this.nome = nome;
        this.prazo = prazo;
        this.responsavel = responsavel;
    }

    // Construtor sem responsável
    public Projeto(String nome, LocalDate prazo) {
        this(nome, prazo, null);
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getPrazo() { return prazo; }
    public void setPrazo(LocalDate prazo) { this.prazo = prazo; }

    public Funcionario getResponsavel() { return responsavel; }
    public void setResponsavel(Funcionario responsavel) { this.responsavel = responsavel; }
    public void removeResponsavel() { this.responsavel = null; }

    // Valida se o prazo do projeto é no futuro
    public boolean prazoValido() { return !this.prazo.isBefore(LocalDate.now()); }
}