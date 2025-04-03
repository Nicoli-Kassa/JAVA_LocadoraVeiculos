public class Main {
    public static void main(String[] args){
        Carro carro1 = new Carro("Corolla", 179.94 , 5, 0);
        carro1.exibirDetalhesCarro();

        Carro carro2 = new Carro("Civic", 389.99, 5, 2);
        carro2.exibirDetalhesCarro();

        Carro carro3 = new Carro("Mustang", 1955.45, 9, 0);
        carro3.exibirDetalhesCarro();

        Carro carro4 = new Carro("SUV", 233.54, 7, 0);
        carro4.exibirDetalhesCarro();
    }
}
