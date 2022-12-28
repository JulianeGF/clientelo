package br.com.alura.clientelo.infra.security.tokenDto;

public class TokenDto {

    private String token;

    private String tipo;

    private final String mensagem;

    public TokenDto(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
        this.mensagem = "OK";
    }

    public TokenDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

}
