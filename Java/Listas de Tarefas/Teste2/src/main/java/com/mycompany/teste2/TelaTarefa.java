package com.mycompany.teste2;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class TelaTarefa extends javax.swing.JFrame {

    private ControleTarefas controleTarefas;
    private DefaultListModel<Tarefa> modeloListaTarefas;
    private DefaultListModel<Tarefa> modeloListaConcluidas;

    public TelaTarefa() {
        controleTarefas = new ControleTarefas();
        modeloListaTarefas = new DefaultListModel<>();
        modeloListaConcluidas = new DefaultListModel<>();
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTarefa = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnJaFiz = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Preciso fazer:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnJaFiz.setText("Já fiz");
        btnJaFiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJaFizActionPerformed(evt);
            }
        });
        
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });


        jLabel2.setText("List to do:");

        jLabel3.setText("Done:");

        jList1.setModel(modeloListaTarefas);
        jScrollPane1.setViewportView(jList1);

        jList2.setModel(modeloListaConcluidas);
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnJaFiz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemover))
                        
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnJaFiz)
                    .addComponent(btnRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        String descricao = txtTarefa.getText();
        if (!descricao.isEmpty()) {
            Tarefa novaTarefa = new Tarefa(descricao, "A Fazer");
            controleTarefas.salvarTarefa(novaTarefa);
            modeloListaTarefas.addElement(novaTarefa);
            txtTarefa.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Digite uma tarefa antes de salvar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnJaFizActionPerformed(java.awt.event.ActionEvent evt) {
        Tarefa tarefaSelecionada = jList1.getSelectedValue();
        if (tarefaSelecionada != null) {
            controleTarefas.removerTarefa(tarefaSelecionada);
            modeloListaTarefas.removeElement(tarefaSelecionada);
            modeloListaConcluidas.addElement(tarefaSelecionada); // Move para a lista de tarefas concluídas
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para marcar como feita.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {
    Tarefa tarefaSelecionada = jList1.getSelectedValue();
    if (tarefaSelecionada != null) {
        controleTarefas.removerTarefa(tarefaSelecionada);
        modeloListaTarefas.removeElement(tarefaSelecionada);
    } else {
        tarefaSelecionada = jList2.getSelectedValue();
        if (tarefaSelecionada != null) {
            controleTarefas.removerTarefa(tarefaSelecionada);
            modeloListaConcluidas.removeElement(tarefaSelecionada);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para remover.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTarefa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnJaFiz;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<Tarefa> jList1;
    private javax.swing.JList<Tarefa> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtTarefa;
    // End of variables declaration
}
