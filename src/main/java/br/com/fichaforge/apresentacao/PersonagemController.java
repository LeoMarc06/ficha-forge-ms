package br.com.fichaforge.apresentacao;

import br.com.fichaforge.apresentacao.dto.CriarPersonagemRequest;
import br.com.fichaforge.apresentacao.dto.PersonagemResponse;
import br.com.fichaforge.dominio.personagem.Personagem;
import br.com.fichaforge.servico.PersonagemServico;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    private PersonagemServico servico = new PersonagemServico();

    @GetMapping
    public ResponseEntity<List<Personagem>> busca() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> busca(@PathVariable(name = "id") Long id) {
        Personagem personagem = servico.busca(id);
        return ResponseEntity.ok(PersonagemResponse.from(personagem));
    }

    @PostMapping
    public ResponseEntity<PersonagemResponse> cria(@Valid @RequestBody CriarPersonagemRequest request) {
        var personagem = request.toModel();
        Personagem personagemCriado = servico.cria(personagem);
        return ResponseEntity.ok(PersonagemResponse.from(personagemCriado));
    }

    @PatchMapping("/renomeia/{id}/novo-nome/{novo-nome}")
    public ResponseEntity<PersonagemResponse> renomeia( @PathVariable("id") Long id , @PathVariable("novo-nome") String nomeNome) {
        Personagem personagemEncontrado = servico.busca(id);
        personagemEncontrado.renomeia(nomeNome);

        return ResponseEntity.ok(PersonagemResponse.from(personagemEncontrado));
    }


    public ResponseEntity<?> cria(List<Personagem> personagens) {
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> atualiza(List<Object> personagens) {
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> atualiza(Object personagem) {
        return ResponseEntity.ok().build();
    }

}