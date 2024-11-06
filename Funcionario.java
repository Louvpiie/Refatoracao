class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    // Construtor completo
    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    // Construtor com salário padrão
    public Funcionario(String nome, String cargo) {
        this(nome, cargo, 0.0);
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
}
