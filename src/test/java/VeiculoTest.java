// Importa o metodo assertEquals para verificar se os resultados esperados são iguais aos obtidos
import static org.junit.jupiter.api.Assertions.assertEquals;

// Importa o metodo assertThrows para verificar se um código lança uma exceção esperada
import static org.junit.jupiter.api.Assertions.assertThrows;

// Importa o metodo assertTrue para verificar se uma condição booleana é verdadeira
import static org.junit.jupiter.api.Assertions.assertTrue;

// Importa a anotação @Test do JUnit para indicar que um metodo é um teste
import org.junit.jupiter.api.Test;

public class VeiculoTest {

    @Test // Indica que este metodo é um teste unitario
    void testCalcularCustoSemDesconto(){
        Veiculo veiculo = new Veiculo("Gol", 100);
        double custo = veiculo.calcularCusto(5);
        // Resultado esperado: 100 * 5 = 500
        assertEquals(500.0, custo, 0.01 );
    }

    @Test
    public void testCalcularCustoComDesconto() {
        Veiculo veiculo = new Veiculo("Gol", 100.0);
        double custo = veiculo.calcularCusto(7);
        // 7 dias a R$ 100 = R$ 700, menos 10% de desconto (R$ 70) = R$ 630
        assertEquals(630.0, custo, 0.01);
    }

    @Test
    void testCalcularDesconto(){
        Veiculo veiculo = new Veiculo("Gol", 100);

        // Sem desconto para carros alugados por menos de 7 dias
        assertEquals(0.0, veiculo.calcularDesconto(6), 0.01 );

        // Com desconto para carros alugados por 7 dias ou mais
        assertEquals(70.0, veiculo.calcularDesconto(7), 0.01 );
        assertEquals(100.0, veiculo.calcularDesconto(10), 0.01 );
    }

    @Test
    void testCalcularMulta(){
        Carro carro = new Carro("Gol", 100, 5, 3);
        double multa = carro.calcularMulta();
        assertEquals(30, multa, 0.01);
    }

    @Test
    void testCalcularCustoTotalSemMulta(){
        Carro carro = new Carro("Gol", 100, 5, 0);
        double custo = carro.calcularCustoTotal();
        // Resultado esperado: 100 * 5 = 500
        assertEquals(500.0, custo, 0.01 );
    }

    @Test
    void testCalcularCustoTotalComMulta(){
        Carro carro = new Carro("Gol", 100, 5, 2);
        double custo = carro.calcularCustoTotal();
        // Resultado esperado: 100 * 5 = 500, mais a multa = 520
        assertEquals(520.0, custo, 0.01 );
    }

    // TESTES DOS CASOS EXTREMOS

    @Test
    public void testCalcularCustoZeroDias(){
        Veiculo veiculo = new Veiculo("Gol", 100);
        double custo = veiculo.calcularCusto(0);
        // 0 dias deve resultar em custo zero
        assertEquals(0.0, custo, 0.01);
    }

    @Test
    public void testCalcularCustoDiasNegativos() {
        Veiculo veiculo = new Veiculo("Gol", 100.0);

        // Verificar se lança exceção para dias negativos
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            veiculo.calcularCusto(-5);
        });

        // Verifica se a mensagem de exceção é apropriada
        assertTrue(exception.getMessage().contains("não pode ser negativo"));
    }

    @Test
    public void testValorDiariaNegativo() {
        // Verifica se lança exceção ao criar veículo com diária negativa
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Veiculo("Gol", -100.0);
        });

        // Verifica se a mensagem de exceção é apropriada
        assertTrue(exception.getMessage().contains("não pode ser negativo"));
    }

    @Test
    public void testSetValorDiariaNegativo() {
        Veiculo veiculo = new Veiculo("Gol", 100.0);

        // Verifica se lança exceção ao tentar definir diária negativa
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            veiculo.setValorDiaria(-50.0);
        });

        // Verifica se a mensagem de exceção é apropriada
        assertTrue(exception.getMessage().contains("não pode ser negativo"));
    }
}
