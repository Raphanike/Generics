import java.util.ArrayList;
import java.util.List;

// Classe abstrata Carro
abstract class Carro {
    String modelo;
    int ano;

    // Construtor
    public Carro(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    // Método abstrato
    public abstract void exibirDetalhes();
}

// Classe concreta Fusca, que herda de Carro
class Fusca extends Carro {
    public Fusca(int ano) {
        super("Fusca", ano);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Modelo: " + modelo + ", Ano: " + ano + " - Um clássico do Brasil!");
    }
}

// Classe concreta Gol, que herda de Carro
class Gol extends Carro {
    public Gol(int ano) {
        super("Gol", ano);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Modelo: " + modelo + ", Ano: " + ano + " - Carro popular!");
    }
}

// Classe genérica que recebe um tipo T (que herda de Carro)
class ListaGenericaCarros<T extends Carro> {
    private List<T> carros;

    // Construtor
    public ListaGenericaCarros() {
        this.carros = new ArrayList<>();
    }

    // Método para adicionar um carro à lista
    public void adicionarCarro(T carro) {
        carros.add(carro);
    }

    // Método para exibir os detalhes de todos os carros na lista
    public void exibirCarros() {
        for (T carro : carros) {
            carro.exibirDetalhes();
        }
    }
}

public class TesteListaCarrosGenerica {
    public static void main(String[] args) {
        // Criando uma lista genérica de carros
        ListaGenericaCarros<Carro> listaCarros = new ListaGenericaCarros<>();

        // Adicionando instâncias de Fusca e Gol à lista
        listaCarros.adicionarCarro(new Fusca(1978));
        listaCarros.adicionarCarro(new Gol(2010));
        listaCarros.adicionarCarro(new Gol(2015));

        // Exibindo os detalhes de todos os carros na lista
        listaCarros.exibirCarros();
    }
}
