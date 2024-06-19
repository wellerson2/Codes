package com.mycompany.teste2;

public class Tarefa {
    private String descricao;
    private String status;

    public Tarefa(String descricao, String status) {
        this.descricao = descricao;
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    // Método toString() para exibir a descrição da tarefa
    @Override
    public String toString() {
        return descricao;
    }
}
