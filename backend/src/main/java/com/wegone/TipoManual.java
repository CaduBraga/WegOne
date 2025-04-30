package com.wegone;

public enum TipoManual {
    CONDUTA_OPERACIONAL("Manual de conduta operacional"),
    DIAGNOSTICO("Manual de diagnóstico"),
    MANUTENCAO("Manual de manutenção"),
    OPERACAO("Manual de operação"),
    SEGURANCA("Manual de segurança");

    private final String descricao;

    TipoManual(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}