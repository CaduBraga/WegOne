package com.wegone;

public enum TipoManual {
    MANUAL_DE_CONDUTA_OPERACIONAL("Manual de conduta operacional"),
    MANUAL_DE_DIAGNOSTICOS("Manual de diagnósticos"),
    MANUAL_DE_MANTENCAO("Manual de manutenção"),
    MANUAL_DE_OPERACAO("Manual de operação"),
    MANUAL_DE_SEGURANCA("Manual de segurança");

    private final String descricao;

    TipoManual(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoManual fromDescricao(String descricao) {
        for (TipoManual t : values()) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Descrição inválida: " + descricao);
    }
}