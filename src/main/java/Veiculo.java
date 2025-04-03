
class Veiculo {
    // Atributos
    private String modelo;
    private double valorDiaria;

    // Construtor
    public Veiculo(String modelo, double valorDiaria) {
        this.modelo = modelo;
        setValorDiaria(valorDiaria); // Utiliza o setter para validação
    }

    // GETTERS
    public String getModelo() { return modelo; }
    public double getValorDiaria() { return valorDiaria; }

    // SETTERS
    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("Modelo não pode ser nulo ou vazio");
        }
        this.modelo = modelo;
    }

    public void setValorDiaria(double valorDiaria) {
        if (valorDiaria < 0) {
            throw new IllegalArgumentException("Valor da diária não pode ser negativo");
        }
        this.valorDiaria = valorDiaria;
    }

    // Metodo para calcular o custo total
    public double calcularCusto(int diasAlugados){
        // Caso diasAlugados for negativo retorna erro
        if (diasAlugados < 0) {
            throw new IllegalArgumentException("Número de dias não pode ser negativo");
        }

        // Caso diasAlugados for igual a 0
        if (diasAlugados == 0) {
            return 0; // Retorna 0 se não houver dias de aluguel
        }

        double custoInicial = valorDiaria * diasAlugados;
        double valorDesconto = calcularDesconto(diasAlugados);
        return custoInicial - valorDesconto;
    }

    // Metodo para calcular desconto
    double calcularDesconto(int diasAlugados){
        // Caso diasAlugados for negativo retorna erro
        if (diasAlugados < 0) {
            throw new IllegalArgumentException("Número de dias não pode ser negativo");
        }

        if (diasAlugados >= 7) {
            return valorDiaria * diasAlugados * 0.1; // Aplica 10% de desconto
        }
        return 0;
    }


    // Metodo de exibição
    public void exibirDetalhes(){
        System.out.print("Modelo do veículo: " + modelo + " | Valor da diária: " + valorDiaria);
    }
}
