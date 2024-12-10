/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.incluirproduto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hiago
 */
public class IncluirProdutoPresenter {

    private Produto produto;
    private final IncluirProdutoView view;
    private final ProdutoCollection produtos;

    public IncluirProdutoPresenter(ProdutoCollection produtos) {
        this.produtos = produtos;
        this.view = new IncluirProdutoView();

        configuraView();
        view.setVisible(true);
    }

    private void configuraView() {
        this.view.getButtonSalvar().addActionListener((ActionEvent e) -> {
            try {
                salvar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        view.getButtonCancelar().addActionListener((ActionEvent e) -> {
            cancelar();
        });
        
        view.getButtonPrintCollection().addActionListener((ActionEvent e) -> {
            sout();
        });
    }

    private void salvar() throws Exception {
        String nome = view.getNomeProduto().getText();
        if (nome == null || nome.isEmpty()) {
            throw new Exception("Nome do produto é obrigatório");
        }
        double precoCusto = Double.parseDouble(view.getPrecoCusto().getText());
        if (precoCusto <= 0) {
            throw new Exception("Preço de custo deve ser maior que zero");
        }
        double percentualLucro = Double.parseDouble(view.getPercentualVenda().getText());
        if (percentualLucro <= 0) {
            throw new Exception("Percentual de lucro deve ser maior que zero");
        }
        double precoVenda = Double.parseDouble(view.getPrecoVenda().getText());
        if (precoVenda <= 0) {
            throw new Exception("Preço de venda deve ser maior que zero");
        }
        produto = new Produto(nome, precoCusto, percentualLucro, precoVenda);

        produtos.incluir(produto);

        JOptionPane.showMessageDialog(view, "Produto incluído com sucesso!");
    }

    private void cancelar() {
        view.dispose();
    }

    private void sout(){
        for (Produto produto1 : this.produtos.getProdutos()) {
            System.err.println("Produto data -> " + produto1.getNome() + " | " + produto1.getPrecoCusto() + " | " + produto1.getPercentualLucro() + " | " + produto1.getPrecoVenda());
        }

    }
}