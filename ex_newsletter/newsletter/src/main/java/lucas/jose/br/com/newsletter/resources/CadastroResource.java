package lucas.jose.br.com.newsletter.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    

}
