package br.com.fichaforge.apresentacao.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public record ErroCampo(
            String campo,
            String mensagem
    ) {}

    public record ErroResposta(
            int status,
            String erro,
            String mensagem,
            List<ErroCampo> detalhes
    ) {}

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResposta> tratarErroValidacao(
            MethodArgumentNotValidException exception
    ) {
        List<ErroCampo> detalhes = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(erro -> new ErroCampo(
                        erro.getField(),
                        erro.getDefaultMessage()
                ))
                .toList();

        ErroResposta resposta = new ErroResposta(
                HttpStatus.BAD_REQUEST.value(),
                "Erro de validação",
                "Um ou mais campos possuem valores inválidos.",
                detalhes
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(resposta);
    }
}