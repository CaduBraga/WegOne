//Antes isso estava dentro da classe principal, mas decidimos separa para ficar mais organizado

import java.util.Date;

public class ManuaisIniciais {

    public static ManualDeOperacao[] imprimir() {
        ManualDeOperacao[] manuais = new ManualDeOperacao[10];

        manuais[0] = new ManualDeOperacao(
                "Manual de Operação de Motores Elétricos", new Date(), "Carlos Braga",
                "Este manual descreve os procedimentos corretos para a operação de motores elétricos:\n\n" +
                        "1. **Partida Direta**: Ligue o motor diretamente na rede elétrica, utilizando contatores adequados. Garanta que a corrente de partida não exceda os limites permitidos pela instalação elétrica.\n"
                        +
                        "2. **Partida Estrela-Triângulo**: Utilize esse método para reduzir a corrente de partida em motores de alta potência. A comutação deve ocorrer após 5 a 10 segundos, conforme a carga.\n"
                        +
                        "3. **Leitura da Placa de Identificação**: Verifique dados como potência, tensão, corrente, fator de serviço e tipo de conexão.\n"
                        +
                        "4. **Controle de Temperatura**: Use sensores térmicos para monitorar o aquecimento dos enrolamentos e do corpo do motor.\n"
                        +
                        "5. **Manutenção Preventiva**: Inclui inspeção de rolamentos, reaperto de conexões e lubrificação periódica.");

        manuais[1] = new ManualDeOperacao(
                "Manual de Operação de Transformadores", new Date(), "João Silva",
                "Instruções completas para a operação de transformadores:\n\n" +
                        "1. **Inspeção Visual**: Verifique integridade dos buchas, nível de óleo, presença de vazamentos e estado do isolamento.\n"
                        +
                        "2. **Verificação do Nível de Óleo**: Mantenha o óleo isolante dentro da faixa recomendada. A troca deve ser feita se houver contaminação ou degradação.\n"
                        +
                        "3. **Procedimento de Energização**: Certifique-se de que todos os disjuntores estejam abertos, conecte aterramento temporário e siga a sequência correta de energização.\n"
                        +
                        "4. **Cuidados com Sobreaquecimento**: Utilize sensores ou relés térmicos. O sobreaquecimento pode reduzir drasticamente a vida útil do equipamento.\n"
                        +
                        "5. **Testes de Rotina**: Inclui ensaios de relação de transformação, resistência ôhmica e isolamento.");

        manuais[2] = new ManualDeOperacao(
                "Manual de Operação de Geradores", new Date(), "Maria Oliveira",
                "Guia completo para operação segura de geradores:\n\n" +
                        "1. **Verificação Pré-Partida**: Verifique o nível de óleo lubrificante, combustível, água de arrefecimento e o estado dos filtros.\n"
                        +
                        "2. **Partida**: Aqueça o motor se necessário. Após a partida, monitore tensões e frequências.\n"
                        +
                        "3. **Sincronização com a Rede**: Use sincronoscópio ou sistemas automáticos. Corrija defasagens antes de conectar à rede elétrica.\n"
                        +
                        "4. **Operação em Carga**: Evite operar abaixo de 30% da carga nominal por longos períodos. Isso reduz eficiência e pode causar carbonização.\n"
                        +
                        "5. **Desligamento**: Reduza gradualmente a carga e aguarde resfriamento do motor antes de desligar.");

        manuais[3] = new ManualDeOperacao(
                "Manual de Operação de Inversores de Frequência", new Date(), "Ana Souza",
                "Manual técnico para uso e configuração de inversores:\n\n" +
                        "1. **Configuração Inicial**: Defina parâmetros como frequência nominal, rampa de aceleração/desaceleração e tipo de controle (V/f ou vetorial).\n"
                        +
                        "2. **Partida e Parada**: Use sinais digitais ou botões físicos. Garanta que o motor esteja livre antes de ligar.\n"
                        +
                        "3. **Monitoramento de Falhas**: Verifique códigos de erro como sobrecorrente, sobretensão ou subfrequência.\n"
                        +
                        "4. **Operação Remota**: Integre com CLPs via Modbus ou outros protocolos industriais.\n" +
                        "5. **Manutenção**: Faça limpeza periódica, inspecione os ventiladores e atualize o firmware se necessário.");

        manuais[4] = new ManualDeOperacao(
                "Manual de Operação de Bombas Industriais", new Date(), "Fernando Lima",
                "Procedimentos para operação correta de bombas:\n\n" +
                        "1. **Alinhamento do Conjunto Motor-Bomba**: Use relógio comparador para verificar desalinhamento axial e radial.\n"
                        +
                        "2. **Escorvamento**: Remova o ar da tubulação antes da partida para evitar cavitação.\n" +
                        "3. **Partida**: Ligue o motor com válvulas de recalque parcialmente fechadas.\n" +
                        "4. **Monitoramento**: Verifique pressão de sucção, vibração e ruídos.\n" +
                        "5. **Manutenção**: Lubrifique mancais, substitua selos mecânicos com vazamentos e revise acoplamentos.");

        manuais[5] = new ManualDeOperacao(
                "Manual de Operação de Compressores", new Date(), "Paula Mendes",
                "Guia técnico de operação de compressores:\n\n" +
                        "1. **Verificações Antes da Partida**: Confirme nível de óleo, tensão das correias e funcionamento das válvulas de segurança.\n"
                        +
                        "2. **Partida a Frio**: Utilize válvula de alívio para reduzir pressão no arranque.\n" +
                        "3. **Operação**: Mantenha pressão dentro do limite de trabalho. Observe variações anormais de temperatura.\n"
                        +
                        "4. **Drenagem do Reservatório**: Remova água acumulada diariamente para evitar corrosão.\n" +
                        "5. **Manutenção**: Troque filtros regularmente, monitore ruídos e faça testes de eficiência energética.");

        manuais[6] = new ManualDeOperacao(
                "Manual de Operação de Painéis Elétricos", new Date(), "Ricardo Alves",
                "Procedimentos para operação segura de painéis:\n\n" +
                        "1. **Identificação de Componentes**: Familiarize-se com disjuntores, contatores, relés térmicos e barramentos.\n"
                        +
                        "2. **Energização Segura**: Siga a sequência correta: aterramento, verificação de tensões e sinalização de área.\n"
                        +
                        "3. **Uso de EPIs**: Inclui luvas isolantes, viseira, vestimenta adequada e calçado com proteção contra arco elétrico.\n"
                        +
                        "4. **Monitoramento**: Use termovisores para detectar pontos de aquecimento.\n" +
                        "5. **Inspeções Periódicas**: Faça reaperto de conexões, limpeza de bornes e testes de continuidade.");

        manuais[7] = new ManualDeOperacao(
                "Manual de Operação de Sistemas de Ventilação", new Date(), "Juliana Rocha",
                "Guia de uso eficiente de ventilação industrial:\n\n" +
                        "1. **Verificação de Filtros**: Troque filtros entupidos regularmente para garantir fluxo de ar adequado.\n"
                        +
                        "2. **Ajuste de Dampers**: Regule a distribuição do ar conforme a demanda de cada setor.\n" +
                        "3. **Medição de Vazão**: Use anemômetros e tubos de Pitot para aferição correta.\n" +
                        "4. **Manutenção de Ventiladores**: Lubrifique mancais, inspecione pás e corrija desalinhamentos.\n"
                        +
                        "5. **Controle de Ruído**: Instale silenciadores e mantenha o sistema limpo para evitar ruídos excessivos.");

        manuais[8] = new ManualDeOperacao(
                "Manual de Operação de CLPs", new Date(), "Diego Costa",
                "Operação e programação de controladores lógicos programáveis:\n\n" +
                        "1. **Download de Programas**: Utilize software apropriado (ex: TIA Portal, Studio 5000) via cabo USB ou rede.\n"
                        +
                        "2. **Monitoramento Online**: Observe estados das entradas e saídas em tempo real para diagnóstico.\n"
                        +
                        "3. **Criação de Lógicas**: Utilize blocos Ladder, STL ou FBD conforme a aplicação.\n" +
                        "4. **Detecção de Falhas**: Leia códigos de erro na interface HMI ou via supervisório.\n" +
                        "5. **Segurança**: Proteja o acesso com senhas e backups regulares do programa.");

        manuais[9] = new ManualDeOperacao(
                "Manual de Operação de Esteiras Transportadoras", new Date(), "Larissa Martins",
                "Procedimentos operacionais para esteiras:\n\n" +
                        "1. **Ajuste de Tensão**: Regule as tensões das correias para garantir operação suave.\n" +
                        "2. **Inspeção de Rolamentos**: Verifique periodicamente o desgaste e a lubrificação.\n" +
                        "3. **Monitoramento de Velocidade**: Utilize sensores de velocidade e ajuste conforme a carga.\n"
                        +
                        "4. **Manutenção Preventiva**: Limpeza periódica de roletes e correias.\n" +
                        "5. **Parada Emergencial**: Verifique se todos os dispositivos de parada estão funcionando corretamente.");

        return manuais;
    }
}