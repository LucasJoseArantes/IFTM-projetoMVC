package br.edu.iftm.tspi.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iftm.tspi.cadastro.dao.PagamentosDAO;
import br.edu.iftm.tspi.cadastro.domain.Pagamento;
import br.edu.iftm.tspi.cadastro.domain.Pedido;

@Controller
@RequestMapping("/pagamentos/{idPedido}")
public class PagamentoController {
    @Autowired
    private PagamentosDAO pagamentosDAO;


    @GetMapping
    public String listarPedidos(@PathVariable("idPedido") int idPedido, Model model) {
        List<Pagamento> pagamentos = pagamentosDAO.listarPagamento(idPedido);
        model.addAttribute("pagamentos", pagamentos);
        model.addAttribute("idPedido", idPedido);
        return "paginaPagamentos";
    }  

    @PostMapping("/inserir")
    public String inserirContato(@ModelAttribute Pagamento pagamento, Model model) {
        pagamentosDAO.inserirPagamento(pagamento);
        List<Pagamento> pagamentos = pagamentosDAO.listarPagamento(pagamento.getId_pedido());
        model.addAttribute("pagamentos", pagamentos);
        return "paginaPagamentos";
    }

}