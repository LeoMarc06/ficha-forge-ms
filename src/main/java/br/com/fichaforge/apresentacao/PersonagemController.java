package br.com.fichaforge.apresentacao;

import br.com.fichaforge.apresentacao.exception.RecursoNaoEncontradoException;
import br.com.fichaforge.dominio.personagem.Personagem;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Validated
@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @GetMapping
    public ResponseEntity<List<Personagem>> busca() {
        Personagem p1 = mock("Jonatha");
        Personagem p2 = mock("Marcelo");
        Personagem p3 = mock("Edileuza");
        Personagem p4 = mock("Cicilio");

        return ResponseEntity.ok(Arrays.asList(p1,p2,p3,p4));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> busca(@PathVariable(name = "id") Long id) {
        if(id == 1)
            throw new RecursoNaoEncontradoException("ID não encontrado", new IllegalAccessException("dde Bo"));

        return ResponseEntity.ok(new Personagem(id, "Jonathan"));
    }

    public ResponseEntity<?> cria(Personagem personagem) {
        return ResponseEntity.ok(personagem);
    }

    public ResponseEntity<?> cria(List<Object> personagens) {
        return ResponseEntity.ok(personagens);
    }

    public ResponseEntity<?> atualiza(List<Object> personagens) {
        return ResponseEntity.ok(personagens);
    }

    public ResponseEntity<?> atualiza(Object personagem) {
        return ResponseEntity.ok(personagem);
    }

    private Personagem mock(String nome) {
        return new Personagem(new Random().nextLong(), nome);
    }


}