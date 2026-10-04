package padroescomportamentais.observer;

import java.util.Observable;

public class Vaga extends Observable {

    private String nome;
    private String descricao;
    private String requisitos;
    private float salario;

    public Vaga(String nome,String descricao, String requisitos, float salario) {
        this.nome = nome;
        this.descricao = descricao;
        this.requisitos = requisitos;
        this.salario = salario;
    }

    public void lancarVaga() {
        setChanged();
        notifyObservers();
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Vaga{" +
                "nome=" + nome +
                ", descrição=" + descricao +
                ", requisitos=" + requisitos + '\'' +
                ", salário=" + salario + '\'' +
                '}';
    }
}
