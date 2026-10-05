package br.com.fichaforge.apresentacao.handler;

import br.com.fichaforge.apresentacao.exception.RecursoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RecursoNaoEncontradoHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroResposta> handleRecursoNaoEncontrado(
            RecursoNaoEncontradoException ex
    ) {
        ErroResposta resposta = new ErroResposta(
                HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado",
                ex.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(resposta);
    }

    public record ErroResposta(
            int status,
            String erro,
            String mensagem
    ) {
    }
}