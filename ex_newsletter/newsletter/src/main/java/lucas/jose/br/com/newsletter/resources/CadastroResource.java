package lucas.jose.br.com.newsletter.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lucas.jose.br.com.newsletter.dto.CadastroDto;

@Controller
public class CadastroResource {

    private List<CadastroDto> cadastros = new ArrayList<>();

    @PostMapping("cadastroPost")
    public String doPost(CadastroDto dto, Model model) {
        cadastros.add(dto);
        return doGet(model);
    }

    @RequestMapping("cadastroGet")
    public String doGet(Model model) {
        model.addAttribute("cadastros", cadastros);
        return "lista";
    }

    @RequestMapping("cadastroDelete")
    public String doDelete(Model model, String name) {

        for (CadastroDto cadastro : cadastros) {
            if (cadastro.getName().equals(name)) {
                cadastros.remove(cadastro);
                break;
            }
        }

        return doGet(model);
    }

    @RequestMapping("cadastroUpdate")
    public String editForm(CadastroDto dto, String name, Model model) {
        // Primeiro, encontre o cadastro a ser atualizado
        CadastroDto cadastroParaAtualizar = null;
        for (CadastroDto cadastro : cadastros) {
            if (cadastro.getName().equals(name)) {
                cadastroParaAtualizar = cadastro;
                break;
            }
        }
    
        // Se encontrou o cadastro, remova-o da lista
        if (cadastroParaAtualizar != null) {
            cadastros.remove(cadastroParaAtualizar);
    
            // Atualize os valores do cadastro com os valores do DTO
            cadastroParaAtualizar.setName(dto.getNameModel());
            cadastroParaAtualizar.setEmail(dto.getEmailModel());
            cadastroParaAtualizar.setNumber(dto.getNumberModel());
    
            // Adicione o cadastro atualizado de volta à lista
            cadastros.add(cadastroParaAtualizar);
        }
    
        return doGet(model);
    }
    

}
