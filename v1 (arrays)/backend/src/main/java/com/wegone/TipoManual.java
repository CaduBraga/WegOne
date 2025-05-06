package com.wegone;

public enum TipoManual {
    CONDUTA_OPERACIONAL("manual-type-operational"),
    DIAGNOSTICO("manual-type-diagnostic"),
    MANUTENCAO("manual-type-maintenance"),
    OPERACAO("manual-type-operation"),
    SEGURANCA("manual-type-safety");

    private final String chaveMensagem;

    TipoManual(String chaveMensagem) {
        this.chaveMensagem = chaveMensagem;
    }

    public String getDescricaoTraduzida() {
        return WegOne.obterMensagem(this.chaveMensagem);
    } // usado para traduzir os valores do enum
}