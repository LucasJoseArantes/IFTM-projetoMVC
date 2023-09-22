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

    @RequestMapping("cadastroResourceUpdate")
    public String doUpdate(
        Model model,
        String oldName,
        String newName,
        String oldEmail,
        String newEmail,
        String oldTel,
        String newTel
    ) {
        for (CadastroDto cadastro : cadastros) {
            if (cadastro.getName().equals(oldName)) {
                cadastro.setName(newName); // Atualiza o nome com o novo valor
                cadastro.setEmail(newEmail); // Atualiza o email com o novo valor
                cadastro.setNumber(newTel); // Atualiza o telefone com o novo valor
                break; // Sai do loop assim que o registro é encontrado e atualizado
            }
        }
    
        // model.addAttribute("cadastros", cadastros);
        // return "lista";
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
}
