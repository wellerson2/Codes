package com.mycompany.teste;

/**
 *
 * @author user
 */

import java.util.ArrayList;

public class ControleTarefas {
    private ArrayList<Tarefa> listaTarefas;

    public ControleTarefas() {
        listaTarefas = new ArrayList<>();
    }

    public ArrayList<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public void setListaTarefas(ArrayList<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public boolean salvarTarefa(Tarefa tarefa) {
        return listaTarefas.add(tarefa);
    }

    public boolean removerTarefa(Tarefa tarefa) {
        return listaTarefas.remove(tarefa);
    }
}
