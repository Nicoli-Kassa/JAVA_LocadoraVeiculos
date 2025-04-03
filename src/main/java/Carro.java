class Carro extends Veiculo {
    // Atributos
    private int diasAlugados;
    private int diasAtrasados;

    // Construtor
    public Carro(String modelo, double valorDiaria, int diasAlugados, int diasAtrasados){
        super(modelo, valorDiaria);
        this.diasAlugados = diasAlugados;
        this.diasAtrasados = diasAtrasados;
    }

    // GETTERS
    public int getDiasAlugados() { return diasAlugados; }
    public int getDiasAtrasados() { return  diasAtrasados; }

    // SETTERS
    public void setDiasAlugados(int diasAlugados){ this.diasAlugados = diasAlugados; }
    public void setDiasAtrasados(int diasAtrasados) { this.diasAtrasados = diasAtrasados; }

    // Metodo para calcular multa
    double calcularMulta(){
        if (diasAtrasados > 0){
            // Multa de 10% por cada dia atrasado
            return (getValorDiaria() * 0.10) * diasAtrasados;
        }
        return 0;
    }

    // Metodo para calcular o custo total considerando a multa
    public double calcularCustoTotal(){
        double custoInicial = super.calcularCusto(diasAlugados); // Utiliza o metodo da classe pai para calcular o custo inicial
        double multa = calcularMulta();
        return custoInicial + multa;
    }

    // Metodo para exibir os detalhes
    public void exibirDetalhesCarro(){
        exibirDetalhes();
        System.out.println(" | Dias alugados: " + diasAlugados +
                " | Dias atrasados: " + diasAtrasados +
                " | Desconto: " + (diasAlugados >= 7 ? "Sim" : "Não") +
                " | Multa: " + calcularMulta() +
                " | Total: " + calcularCustoTotal());
    }

}
