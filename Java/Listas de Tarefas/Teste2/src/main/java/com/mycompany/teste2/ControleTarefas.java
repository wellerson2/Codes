package com.mycompany.teste2;

import java.util.ArrayList;

public class ControleTarefas {
    private ArrayList<Tarefa> listaTarefas;

    public ControleTarefas() {
        listaTarefas = new ArrayList<>();
    }

    public void salvarTarefa(Tarefa tarefa) {
        listaTarefas.add(tarefa);
    }

    public void removerTarefa(Tarefa tarefa) {
        listaTarefas.remove(tarefa);
    }

    public void removerTarefaPorDescricao(String descricao) {
        Tarefa tarefa = buscarTarefaPorDescricao(descricao);
        if (tarefa != null) {
            listaTarefas.remove(tarefa);
        }
    }

    public Tarefa buscarTarefaPorDescricao(String descricao) {
        for (Tarefa tarefa : listaTarefas) {
            if (tarefa.getDescricao().equals(descricao)) {
                return tarefa;
            }
        }
        return null; // Retorna null se a tarefa não for encontrada
    }
}
