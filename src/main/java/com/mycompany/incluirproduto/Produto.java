/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.incluirproduto;

/**
 *
 * @author hiago
 */
public class Produto {
    private String nome;
    private double precoCusto;
    private double percentualLucro;
    private double precoVenda;

    public Produto(String nome, double precoCusto, double percentualLucro, double precoVenda1) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.percentualLucro = percentualLucro;
        this.precoVenda = calcularPrecoVenda();
    }
    
    public double calcularPrecoVenda() {
        return precoCusto + (precoCusto * percentualLucro / 100);
    }
    
    // Getters
    
    public String getNome(){
        return this.nome;
    }
    
    public double getPrecoCusto(){
        return this.precoCusto;
    }
    
    public double getPercentualLucro(){
        return this.percentualLucro;
    }
    
    public double getPrecoVenda(){
        return this.precoVenda;
    }

}
