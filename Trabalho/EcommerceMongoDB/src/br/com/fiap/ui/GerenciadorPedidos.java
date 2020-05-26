package br.com.fiap.ui;

import br.com.fiap.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GerenciadorPedidos  extends  GerenciadorBase {
    @Autowired
    private PedidoRepository pedidoRepository;

    public GerenciadorPedidos() { super(); };

}
