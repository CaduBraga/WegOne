import java.util.Date;

public class ManuaisDeSeguranca {

        public static ManualDeSeguranca[] imprimir() {
                ManualDeSeguranca[] manuais = new ManualDeSeguranca[10];

                manuais[0] = new ManualDeSeguranca(
                                "Procedimento de Segurança para Instalação de Equipamentos Elétricos", new Date(),
                                "Carlos Braga",
                                "Este manual descreve os procedimentos de segurança para a instalação de equipamentos elétricos:\n\n"
                                                +
                                                "1. **Desligamento da Energia**: Antes de iniciar qualquer instalação, certifique-se de que a energia está desligada e que o circuito foi adequadamente desenergizado.\n"
                                                +
                                                "2. **Utilização de EPIs**: Use Equipamentos de Proteção Individual (EPIs) adequados, como luvas isolantes, calçado de segurança, e capacete com proteção contra choque elétrico.\n"
                                                +
                                                "3. **Verificação de Isolamento**: Certifique-se de que o isolamento dos cabos e conexões esteja em boas condições antes de realizar a instalação.\n"
                                                +
                                                "4. **Aterramento**: Garanta que o equipamento esteja adequadamente aterrado para evitar riscos de choque elétrico.\n"
                                                +
                                                "5. **Testes de Segurança**: Após a instalação, realize testes para garantir que não há fuga de corrente e que a instalação está segura.");

                manuais[1] = new ManualDeSeguranca(
                                "Procedimento de Segurança para Operações com Risco de Choque Elétrico", new Date(),
                                "João Silva",
                                "Este manual fornece orientações de segurança para a realização de operações com risco de choque elétrico:\n\n"
                                                +
                                                "1. **Bloqueio e Etiquetagem**: Utilize sistemas de bloqueio e etiquetagem para garantir que os circuitos estejam desenergizados enquanto o trabalho estiver em andamento.\n"
                                                +
                                                "2. **Inspeção de Equipamentos de Proteção**: Verifique periodicamente a integridade dos EPIs e equipamentos de segurança, como luvas isolantes e calçados de segurança.\n"
                                                +
                                                "3. **Treinamento de Funcionários**: Garanta que todos os funcionários sejam treinados em práticas de segurança elétrica, incluindo primeiros socorros em caso de choque.\n"
                                                +
                                                "4. **Uso de Ferramentas Isoladas**: Utilize ferramentas com isolamento adequado para evitar risco de choque durante a manutenção de sistemas elétricos.\n"
                                                +
                                                "5. **Procedimento de Resgate**: Tenha um plano de ação para resgatar alguém que tenha sofrido choque elétrico, incluindo o uso de equipamento de resgate e procedimentos de primeiros socorros.");

                manuais[2] = new ManualDeSeguranca(
                                "Procedimento de Segurança para Trabalhos em Altura", new Date(), "Maria Oliveira",
                                "Este manual descreve as práticas de segurança para trabalhos em altura:\n\n" +
                                                "1. **Equipamento de Proteção contra Queda**: Utilize cinto de segurança com talabarte, capacete, e outros EPIs necessários.\n"
                                                +
                                                "2. **Verificação das Estruturas**: Antes de iniciar o trabalho, inspecione as estruturas que serão utilizadas (andaimes, escadas, etc.) para garantir que estejam em boas condições.\n"
                                                +
                                                "3. **Treinamento e Capacitação**: Todos os trabalhadores devem ser capacitados em técnicas de segurança para trabalhos em altura.\n"
                                                +
                                                "4. **Procedimento de Evacuação**: Tenha um plano de evacuação de emergência no caso de acidentes durante o trabalho em altura.\n"
                                                +
                                                "5. **Monitoramento de Condições Climáticas**: Evite realizar trabalhos em altura durante condições climáticas adversas, como ventos fortes ou chuvas.");

                manuais[3] = new ManualDeSeguranca(
                                "Procedimento de Segurança para Manutenção de Equipamentos Elétricos", new Date(),
                                "Ana Souza",
                                "Este manual fornece as orientações de segurança para manutenção de equipamentos elétricos:\n\n"
                                                +
                                                "1. **Desligamento de Energia**: Sempre desligue a energia antes de realizar qualquer tipo de manutenção em equipamentos elétricos.\n"
                                                +
                                                "2. **Verificação de Tensão e Corrente**: Antes de manusear qualquer parte do equipamento, utilize um multímetro para garantir que não há presença de tensão.\n"
                                                +
                                                "3. **Isolamento de Circuitos**: Utilize dispositivos de bloqueio e etiquetagem para garantir que os circuitos permaneçam desenergizados.\n"
                                                +
                                                "4. **Uso de EPIs Específicos**: Utilize luvas e ferramentas isoladas, além de roupas adequadas para evitar qualquer tipo de choque ou queimadura elétrica.\n"
                                                +
                                                "5. **Testes Após Manutenção**: Após a manutenção, execute testes para verificar se o equipamento está funcionando corretamente e se todas as proteções estão operando.");

                manuais[4] = new ManualDeSeguranca(
                                "Procedimento de Segurança para Inspeção de Equipamentos Elétricos", new Date(),
                                "Fernando Lima",
                                "Este manual orienta sobre como realizar inspeções de segurança em equipamentos elétricos:\n\n"
                                                +
                                                "1. **Verificação de Riscos Visuais**: Inspecione visualmente os equipamentos para verificar sinais de desgaste, aquecimento excessivo ou danos nos fios.\n"
                                                +
                                                "2. **Medição de Tensão e Corrente**: Utilize instrumentos de medição para garantir que os valores de tensão e corrente estejam dentro das especificações.\n"
                                                +
                                                "3. **Análise de Equipamentos de Proteção**: Verifique os dispositivos de proteção, como disjuntores e fusíveis, para garantir que estejam em bom estado de funcionamento.\n"
                                                +
                                                "4. **Verificação de Aterramento**: Certifique-se de que todos os equipamentos estão devidamente aterrados para evitar riscos de choque elétrico.\n"
                                                +
                                                "5. **Relatórios de Inspeção**: Elabore relatórios detalhados sobre as condições dos equipamentos inspecionados, com recomendações para ações corretivas, se necessário.");

                manuais[5] = new ManualDeSeguranca(
                                "Procedimento de Segurança para Trabalhos com Máquinas e Equipamentos Perigosos",
                                new Date(),
                                "Paula Mendes",
                                "Este manual descreve os procedimentos de segurança para trabalhar com máquinas e equipamentos perigosos:\n\n"
                                                +
                                                "1. **Desligamento e Bloqueio de Máquinas**: Antes de iniciar qualquer manutenção, garanta que as máquinas estejam desligadas e com sistemas de bloqueio aplicados.\n"
                                                +
                                                "2. **Treinamento de Operadores**: Todos os operadores devem ser treinados e certificados para operar as máquinas e equipamentos de forma segura.\n"
                                                +
                                                "3. **Uso de EPIs**: Utilize protetores auriculares, óculos de segurança e vestimentas adequadas para prevenir lesões.\n"
                                                +
                                                "4. **Procedimentos de Emergência**: Tenha sempre procedimentos de emergência estabelecidos, incluindo a localização de paradas de emergência.\n"
                                                +
                                                "5. **Inspeção de Máquinas**: Realize inspeções regulares nas máquinas para verificar se há peças danificadas ou defeituosas que possam comprometer a segurança.");

                manuais[6] = new ManualDeSeguranca(
                                "Procedimento de Segurança para Armazenamento de Materiais Perigosos", new Date(),
                                "Ricardo Alves",
                                "Este manual orienta sobre os cuidados necessários para o armazenamento de materiais perigosos:\n\n"
                                                +
                                                "1. **Armazenamento em Áreas Seguras**: Mantenha materiais perigosos em locais isolados e adequados para evitar riscos à saúde e ao meio ambiente.\n"
                                                +
                                                "2. **Etiquetagem e Identificação**: Todos os materiais devem ser etiquetados adequadamente, com símbolos de risco e informações sobre o manuseio seguro.\n"
                                                +
                                                "3. **Equipamentos de Proteção**: Utilize EPIs adequados ao manusear materiais perigosos, como luvas, máscaras e aventais.\n"
                                                +
                                                "4. **Ventilação Adequada**: As áreas de armazenamento devem ser bem ventiladas para evitar a acumulação de vapores tóxicos ou inflamáveis.\n"
                                                +
                                                "5. **Plano de Emergência**: Tenha um plano de ação em caso de derramamento ou acidente envolvendo materiais perigosos.");

                manuais[7] = new ManualDeSeguranca(
                                "Procedimento de Segurança em Sistemas de Iluminação de Emergência", new Date(),
                                "Juliana Rocha",
                                "Este manual descreve as práticas de segurança para o uso e manutenção de sistemas de iluminação de emergência:\n\n"
                                                +
                                                "1. **Verificação de Funcionalidade**: Teste regularmente as luzes de emergência para garantir que estão funcionando adequadamente.\n"
                                                +
                                                "2. **Manutenção de Baterias**: Verifique o estado das baterias, substituindo-as quando necessário para evitar falhas no sistema.\n"
                                                +
                                                "3. **Procedimentos de Emergência**: Em caso de falha no sistema de iluminação, siga o procedimento de emergência para reativação.\n"
                                                +
                                                "4. **Inspeção Visual**: Realize inspeções visuais nos dispositivos de iluminação para verificar se há falhas, danos ou sujeira nos equipamentos.\n"
                                                +
                                                "5. **Documentação de Manutenção**: Registre todas as atividades de manutenção e testes realizados no sistema de iluminação de emergência.");

                manuais[8] = new ManualDeSeguranca(
                                "Procedimento de Segurança para Trabalhos com Substâncias Químicas", new Date(),
                                "Diego Costa",
                                "Este manual orienta sobre a segurança no manuseio de substâncias químicas:\n\n" +
                                                "1. **Utilização de EPIs Específicos**: Use luvas, máscaras e vestimentas adequadas ao manusear substâncias químicas.\n"
                                                +
                                                "2. **Armazenamento Adequado**: Armazene as substâncias químicas em locais adequados, conforme as instruções do fabricante e normas de segurança.\n"
                                                +
                                                "3. **Ventilação Adequada**: Trabalhe em áreas bem ventiladas para evitar a inalação de vapores ou gases tóxicos.\n"
                                                +
                                                "4. **Plano de Emergência**: Tenha sempre um plano de ação para casos de vazamento ou acidente químico.\n"
                                                +
                                                "5. **Treinamento de Funcionários**: Capacite os funcionários sobre os riscos e procedimentos de segurança relacionados às substâncias químicas que manipulam.");

                manuais[9] = new ManualDeSeguranca(
                                "Procedimento de Segurança para Uso de Equipamentos de Proteção Individual", new Date(),
                                "Larissa Martins",
                                "Este manual descreve os cuidados necessários ao usar Equipamentos de Proteção Individual (EPIs):\n\n"
                                                +
                                                "1. **Seleção de EPIs Adequados**: Escolha os EPIs de acordo com os riscos presentes no ambiente de trabalho.\n"
                                                +
                                                "2. **Treinamento no Uso**: Todos os funcionários devem ser treinados sobre como utilizar corretamente os EPIs.\n"
                                                +
                                                "3. **Verificação de Condições**: Antes de usar os EPIs, verifique se estão em boas condições de uso.\n"
                                                +
                                                "4. **Manutenção e Substituição**: Realize manutenção periódica nos EPIs e substitua-os quando estiverem desgastados ou danificados.\n"
                                                +
                                                "5. **Documentação**: Mantenha registros sobre os EPIs fornecidos aos funcionários e treinamentos realizados.");

                return manuais;
        }
}