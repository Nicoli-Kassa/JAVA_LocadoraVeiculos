# Projeto: Locadora de Veículos

### Nicoli Amy Kassa | RM 559104

### 🎯 Objetivo

O objetivo deste projeto é colocar em prática os métodos de encapsulamento, herança e testes unitários, aprendidos nas aulas de **DOMAIN DRIVEN DESIGN – JAVA** ministradas pelo professor Salatiel Marinho, na FIAP.

## 📝 Descrição do projeto

Neste projeto, desenvolvi a classe Veiculo, que representa um veículo da locadora, e a subclasse Carro, que herda suas propriedades e comportamentos. O projeto conta com métodos para calcular o custo do aluguel com base na quantidade de dias, aplicando descontos para locações de 7 dias ou mais e penalidades em caso de atraso na devolução. Além disso, foram implementados testes unitários utilizando JUnit para validar os métodos.

### 🛠️ Métodos

- ```calcularCusto()``` -> Calcula o valor inicial, apenas com o desconto, sem considerar a multa caso haja 
- ```calcularDesconto()``` -> Calcula o valor desconto, caso haja
- ```calcularMulta()``` -> Calcula o valor da multa, caso haja
- ```calcularCustoTotal()``` -> Calcula o valor final, considerando a multa, caso haja

### Tecnologias Utilizadas

- IntelliJ IDEA
- Java
- JUnit para testes unitários

### Como Executar o Projeto

1. Clone este repositório:
``` 
git clone https://github.com/seu-usuario/JAVA_LocadoraVeiculos.git
```

2. Abra o projeto em uma IDE compatível (Eclipse, IntelliJ IDEA, VS Code, etc.).
3. Compile e execute o arquivo principal (Main.java).
4. Rode os testes unitários para verificar os métodos.
