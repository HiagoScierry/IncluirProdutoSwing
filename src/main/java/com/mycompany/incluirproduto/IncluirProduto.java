/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.incluirproduto;

/**
 *
 * @author hiago
 */
public class IncluirProduto {

    public static void main(String[] args) {
        ProdutoCollection produtos = new ProdutoCollection();
        new IncluirProdutoPresenter(produtos);
    }
}
