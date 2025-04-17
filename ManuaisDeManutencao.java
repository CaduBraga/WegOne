import java.util.Date;

public class ManuaisDeManutencao {

        public static ManualDeManutencao[] imprimir() {
                ManualDeManutencao[] manuais = new ManualDeManutencao[10];

                manuais[0] = new ManualDeManutencao(
                                "Manutenção de Motores Elétricos", new Date(), "Carlos Braga",
                                "Este manual descreve os procedimentos para a manutenção de motores elétricos:\n\n" +
                                                "1. **Inspeção Visual**: Verifique a integridade do motor, incluindo a carcaça, fios e conectores.\n"
                                                +
                                                "2. **Lubrificação de Rolamentos**: Aplique graxa nos rolamentos conforme as instruções do fabricante.\n"
                                                +
                                                "3. **Testes de Resistência de Aterramento**: Verifique a resistência de aterramento para evitar riscos de choque.\n"
                                                +
                                                "4. **Troca de Escovas**: Caso o motor tenha escovas, faça a substituição a cada 1.000 horas de uso.\n"
                                                +
                                                "5. **Reparo de Bobinas**: Se o motor apresentar falhas nos enrolamentos, será necessário realizar o reparo ou a substituição das bobinas.");

                manuais[1] = new ManualDeManutencao(
                                "Manutenção de Transformadores", new Date(), "João Silva",
                                "Este manual aborda os procedimentos para a manutenção de transformadores:\n\n" +
                                                "1. **Inspeção Visual**: Verifique vazamentos de óleo e o estado das buchas e conectores.\n"
                                                +
                                                "2. **Verificação do Nível de Óleo**: O nível de óleo deve ser mantido dentro dos limites recomendados. Troque o óleo se necessário.\n"
                                                +
                                                "3. **Testes de Isolamento**: Realize testes de resistência de isolamento entre os enrolamentos e a terra.\n"
                                                +
                                                "4. **Verificação de Temperatura**: Monitore a temperatura do transformador com sensores térmicos para evitar superaquecimento.\n"
                                                +
                                                "5. **Reparo de Buchas**: Caso as buchas do transformador estejam danificadas, substitua-as de acordo com as especificações do fabricante.");

                manuais[2] = new ManualDeManutencao(
                                "Manutenção de Geradores", new Date(), "Maria Oliveira",
                                "Procedimentos para a manutenção de geradores:\n\n" +
                                                "1. **Verificação de Combustível**: Verifique a qualidade e o nível do combustível. Troque-o se necessário.\n"
                                                +
                                                "2. **Inspeção de Componentes Elétricos**: Verifique as conexões e componentes elétricos em busca de sinais de desgaste.\n"
                                                +
                                                "3. **Troca de Filtro de Ar**: Substitua o filtro de ar a cada 500 horas de operação.\n"
                                                +
                                                "4. **Reparo de Bateria**: Teste a carga da bateria e substitua-a caso a voltagem esteja abaixo dos padrões recomendados.\n"
                                                +
                                                "5. **Verificação de Sistema de Arrefecimento**: Verifique e limpe o sistema de arrefecimento para evitar superaquecimento.");

                manuais[3] = new ManualDeManutencao(
                                "Manutenção de Inversores de Frequência", new Date(), "Ana Souza",
                                "Este manual descreve os procedimentos de manutenção para inversores de frequência:\n\n"
                                                +
                                                "1. **Limpeza de Filtros de Ar**: Limpe os filtros de ar periodicamente para evitar o acúmulo de poeira.\n"
                                                +
                                                "2. **Verificação de Tensão de Entrada**: Verifique se a tensão de entrada está dentro da faixa especificada pelo fabricante.\n"
                                                +
                                                "3. **Monitoramento de Temperatura**: Verifique se a temperatura interna do inversor está dentro dos limites recomendados.\n"
                                                +
                                                "4. **Substituição de Fusíveis**: Troque fusíveis queimados ou danificados imediatamente.\n"
                                                +
                                                "5. **Verificação de Códigos de Erro**: Verifique e corrija códigos de erro no display de controle, como falhas de sobrecorrente.");

                manuais[4] = new ManualDeManutencao(
                                "Manutenção de Bombas Industriais", new Date(), "Fernando Lima",
                                "Instruções para a manutenção de bombas industriais:\n\n" +
                                                "1. **Alinhamento de Eixo**: Verifique o alinhamento do eixo motor-bomba utilizando um relógio comparador.\n"
                                                +
                                                "2. **Verificação de Válvulas de Recalque**: Inspecione as válvulas de recalque e substitua-as se estiverem danificadas.\n"
                                                +
                                                "3. **Lubrificação de Mancais**: Aplique graxa ou óleo nos mancais conforme recomendado pelo fabricante.\n"
                                                +
                                                "4. **Inspeção de Selo Mecânico**: Verifique a vedação do selo mecânico para evitar vazamentos.\n"
                                                +
                                                "5. **Teste de Pressão**: Realize testes periódicos de pressão para verificar se a bomba está funcionando corretamente.");

                manuais[5] = new ManualDeManutencao(
                                "Manutenção de Compressores", new Date(), "Paula Mendes",
                                "Procedimentos para manutenção de compressores:\n\n" +
                                                "1. **Verificação de Pressão**: Verifique a pressão de operação do compressor regularmente.\n"
                                                +
                                                "2. **Troca de Óleo**: Troque o óleo do compressor a cada 1000 horas de operação ou conforme especificado pelo fabricante.\n"
                                                +
                                                "3. **Inspeção de Válvulas de Segurança**: Teste as válvulas de segurança periodicamente para garantir o seu funcionamento adequado.\n"
                                                +
                                                "4. **Verificação de Corrosão**: Inspecione as partes metálicas do compressor em busca de sinais de corrosão.\n"
                                                +
                                                "5. **Reparo de Fugas**: Caso seja detectada uma fuga de ar, inspecione as tubulações e substitua as vedações danificadas.");

                manuais[6] = new ManualDeManutencao(
                                "Manutenção de Painéis Elétricos", new Date(), "Ricardo Alves",
                                "Manutenção preventiva e corretiva para painéis elétricos:\n\n" +
                                                "1. **Inspeção de Conexões**: Verifique se as conexões estão bem apertadas para evitar aquecimento excessivo.\n"
                                                +
                                                "2. **Limpeza de Bornes**: Faça a limpeza dos bornes para evitar falhas de contato.\n"
                                                +
                                                "3. **Substituição de Disjuntores**: Substitua disjuntores defeituosos ou com características de disparo inadequadas.\n"
                                                +
                                                "4. **Testes de Continuidade**: Realize testes de continuidade para garantir que o circuito está funcional.\n"
                                                +
                                                "5. **Verificação de Equipamentos de Proteção**: Inspecione os dispositivos de proteção como relés e fusíveis, garantindo que estejam em bom estado de funcionamento.");

                manuais[7] = new ManualDeManutencao(
                                "Manutenção de Sistemas de Ventilação", new Date(), "Juliana Rocha",
                                "Procedimentos para manutenção de sistemas de ventilação:\n\n" +
                                                "1. **Troca de Filtros de Ar**: Substitua os filtros de ar regularmente para garantir eficiência no fluxo de ar.\n"
                                                +
                                                "2. **Inspeção de Ventiladores**: Verifique os ventiladores para garantir que não estejam desalinhados ou com defeito.\n"
                                                +
                                                "3. **Lubrificação de Rolamentos**: Lubrifique os rolamentos dos ventiladores para evitar desgaste excessivo.\n"
                                                +
                                                "4. **Limpeza das Condutas**: Realize a limpeza das condutas de ar periodicamente para evitar o acúmulo de sujeira.\n"
                                                +
                                                "5. **Verificação de Ruídos**: Monitore os níveis de ruído dos ventiladores e corrija desalinhamentos ou falhas nos componentes.");

                manuais[8] = new ManualDeManutencao(
                                "Manutenção de CLPs", new Date(), "Diego Costa",
                                "Instruções de manutenção para CLPs:\n\n" +
                                                "1. **Verificação de Energia**: Verifique a alimentação de energia do CLP, garantindo que a tensão esteja estável.\n"
                                                +
                                                "2. **Backup de Programas**: Faça backups regulares dos programas para evitar perda de dados.\n"
                                                +
                                                "3. **Inspeção de Entradas/Saídas**: Verifique as entradas e saídas digitais e analógicas, procurando por falhas de contato.\n"
                                                +
                                                "4. **Monitoramento de Temperatura**: Meça a temperatura interna do CLP para garantir que não ocorra superaquecimento.\n"
                                                +
                                                "5. **Atualização de Firmware**: Mantenha o firmware do CLP atualizado para corrigir falhas de segurança e melhorar a performance.");

                manuais[9] = new ManualDeManutencao(
                                "Manutenção de Esteiras Transportadoras", new Date(), "Larissa Martins",
                                "Procedimentos para manutenção de esteiras transportadoras:\n\n" +
                                                "1. **Verificação de Correias**: Verifique a tensão e o desgaste das correias periodicamente.\n"
                                                +
                                                "2. **Lubrificação de Rolamentos**: Aplique lubrificante nos rolamentos de apoio e motor.\n"
                                                +
                                                "3. **Ajuste de Velocidade**: Verifique a velocidade da esteira e ajuste conforme necessário.\n"
                                                +
                                                "4. **Inspeção de Rolamentos e Polias**: Verifique o desgaste dos rolamentos e substitua os danificados.\n"
                                                +
                                                "5. **Reparo de Desalinhamentos**: Corrija qualquer desalinhamento das correias para evitar desgaste excessivo.");

                return manuais;
        }
}
