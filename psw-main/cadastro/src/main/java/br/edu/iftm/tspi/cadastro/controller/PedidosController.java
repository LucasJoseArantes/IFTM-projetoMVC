package br.edu.iftm.tspi.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iftm.tspi.cadastro.dao.PedidoDAO;
import br.edu.iftm.tspi.cadastro.domain.Pedido;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {
    @Autowired
    private PedidoDAO pedidoDAO;

    @GetMapping
    public String listarPedidos(Model model) {
        List<Pedido> pedidos = pedidoDAO.listarPedidos();
        model.addAttribute("pedidos", pedidos);
        return "paginaPedidos";
    }

    @PostMapping("/inserir")
    public String inserirContato(@ModelAttribute Pedido pedido, Model model) {
        pedidoDAO.inserirPedido(pedido);
        List<Pedido> pedidos = pedidoDAO.listarPedidos();
        model.addAttribute("pedidos", pedidos);
        return "paginaPedidos";
    }

    // @GetMapping("/editar/{email}")
    // public String exibirFormularioEdicao(@PathVariable int idPedido, Model model) {
    //     Pedido pedido = pedidoDAO.buscarPedidosPorId(idPedido);
    //     model.addAttribute("pedido", pedido);
    //     return "paginaEdicao";
    // }

    // @PostMapping("/atualizar/{email}")
    // public String atualizarPedido(@PathVariable String email, @ModelAttribute Pedido pedido, Model model) {
    //     pedidoDAO.atualizarPedido(pedido);
    //     List<Pedido> pedidos = pedidoDAO.listarPedidos();
    //     model.addAttribute("pedidos", pedidos);
    //     return "paginaListagem";
    // }

    // @PostMapping("/excluir/{email}")
    // public String excluirPedido(@PathVariable String email, Model model) {
    //     pedidoDAO.excluirPedido(email);
    //     List<Pedido> pedidos = pedidoDAO.listarPedidos();
    //     model.addAttribute("pedidos", pedidos);
    //     return "paginaListagem";
    // }

    // @GetMapping("/pesquisar")
    // public String pesquisarContatosPorNome(@RequestParam String nome, Model model) {
    //     List<Contato> contatos = contatoDAO.buscarContatosPorNome(nome);
    //     model.addAttribute("contatos", contatos);
    //     return "paginaListagem";
    // }
}



