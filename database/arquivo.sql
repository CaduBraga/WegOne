CREATE DATABASE  IF NOT EXISTS `wegone` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `wegone`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: wegone
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `manuais`
--

DROP TABLE IF EXISTS `manuais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manuais` (
  `id_manual` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) DEFAULT NULL,
  `autor` varchar(100) DEFAULT NULL,
  `texto` text,
  `dataDePublicacao` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tipoManual` enum('Manual de conduta operacional','Manual de diagnósticos','Manual de manutenção','Manual de operação','Manual de segurança') DEFAULT NULL,
  PRIMARY KEY (`id_manual`),
  UNIQUE KEY `titulo` (`titulo`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manuais`
--

LOCK TABLES `manuais` WRITE;
/*!40000 ALTER TABLE `manuais` DISABLE KEYS */;
INSERT INTO `manuais` VALUES (1,'Manutenção de Motores Elétricos','Carlos Braga','Este manual descreve os procedimentos para a manutenção de motores elétricos:\n\n1. **Inspeção Visual**: Verifique a integridade do motor, incluindo a carcaça, fios e conectores.\n2. **Lubrificação de Rolamentos**: Aplique graxa nos rolamentos conforme as instruções do fabricante.\n3. **Testes de Resistência de Aterramento**: Verifique a resistência de aterramento para evitar riscos de choque.\n4. **Troca de Escovas**: Caso o motor tenha escovas, faça a substituição a cada 1.000 horas de uso.\n5. **Reparo de Bobinas**: Se o motor apresentar falhas nos enrolamentos, será necessário realizar o reparo ou a substituição das bobinas.','2025-04-28 23:11:58','Manual de manutenção'),(2,'Manutenção de Transformadores','João Silva','Este manual aborda os procedimentos para a manutenção de transformadores:\n\n1. **Inspeção Visual**: Verifique vazamentos de óleo e o estado das buchas e conectores.\n2. **Verificação do Nível de Óleo**: O nível de óleo deve ser mantido dentro dos limites recomendados. Troque o óleo se necessário.\n3. **Testes de Isolamento**: Realize testes de resistência de isolamento entre os enrolamentos e a terra.\n4. **Verificação de Temperatura**: Monitore a temperatura do transformador com sensores térmicos para evitar superaquecimento.\n5. **Reparo de Buchas**: Caso as buchas do transformador estejam danificadas, substitua-as de acordo com as especificações do fabricante.','2025-04-28 23:11:58','Manual de manutenção'),(3,'Manutenção de Geradores','Maria Oliveira','Procedimentos para a manutenção de geradores:\n\n1. **Verificação de Combustível**: Verifique a qualidade e o nível do combustível. Troque-o se necessário.\n2. **Inspeção de Componentes Elétricos**: Verifique as conexões e componentes elétricos em busca de sinais de desgaste.\n3. **Troca de Filtro de Ar**: Substitua o filtro de ar a cada 500 horas de operação.\n4. **Reparo de Bateria**: Teste a carga da bateria e substitua-a caso a voltagem esteja abaixo dos padrões recomendados.\n5. **Verificação de Sistema de Arrefecimento**: Verifique e limpe o sistema de arrefecimento para evitar superaquecimento.','2025-04-28 23:11:58','Manual de manutenção'),(4,'Manutenção de Inversores de Frequência','Ana Souza','Este manual descreve os procedimentos de manutenção para inversores de frequência:\n\n1. **Limpeza de Filtros de Ar**: Limpe os filtros de ar periodicamente para evitar o acúmulo de poeira.\n2. **Verificação de Tensão de Entrada**: Verifique se a tensão de entrada está dentro da faixa especificada pelo fabricante.\n3. **Monitoramento de Temperatura**: Verifique se a temperatura interna do inversor está dentro dos limites recomendados.\n4. **Substituição de Fusíveis**: Troque fusíveis queimados ou danificados imediatamente.\n5. **Verificação de Códigos de Erro**: Verifique e corrija códigos de erro no display de controle, como falhas de sobrecorrente.','2025-04-28 23:11:58','Manual de manutenção'),(5,'Manutenção de Bombas Industriais','Fernando Lima','Instruções para a manutenção de bombas industriais:\n\n1. **Alinhamento de Eixo**: Verifique o alinhamento do eixo motor-bomba utilizando um relógio comparador.\n2. **Verificação de Válvulas de Recalque**: Inspecione as válvulas de recalque e substitua-as se estiverem danificadas.\n3. **Lubrificação de Mancais**: Aplique graxa ou óleo nos mancais conforme recomendado pelo fabricante.\n4. **Inspeção de Selo Mecânico**: Verifique a vedação do selo mecânico para evitar vazamentos.\n5. **Teste de Pressão**: Realize testes periódicos de pressão para verificar se a bomba está funcionando corretamente.','2025-04-28 23:11:58','Manual de manutenção'),(6,'Manutenção de Compressores','Paula Mendes','Procedimentos para manutenção de compressores:\n\n1. **Verificação de Pressão**: Verifique a pressão de operacional do compressor e ajuste conforme necessário.\n2. **Troca de Óleo**: Substitua o óleo do compressor a cada 1.000 horas de operação ou conforme as recomendações do fabricante.\n3. **Limpeza de Filtros**: Limpe ou troque os filtros de ar regularmente para garantir a eficiência do compressor.\n4. **Inspeção de Mangueiras**: Verifique as mangueiras em busca de desgastes ou vazamentos e substitua-as se necessário.\n5. **Teste de Válvulas de Segurança**: Realize testes nas válvulas de segurança para garantir que estejam funcionando corretamente.','2025-04-28 23:11:58','Manual de manutenção'),(7,'Manutenção de Painéis Elétricos','Ricardo Alves','Este manual fornece diretrizes para a manutenção de painéis elétricos:\n\n1. **Inspeção Visual**: Verifique a integridade dos componentes e conexões no painel.\n2. **Limpeza de Contatos**: Limpe os contatos elétricos para evitar falhas de conexão.\n3. **Verificação de Fusíveis**: Inspecione e substitua fusíveis queimados ou danificados.\n4. **Teste de Isolamento**: Realize testes de isolamento para garantir a segurança elétrica.\n5. **Atualização de Diagramas**: Mantenha os diagramas elétricos atualizados conforme alterações no sistema.','2025-04-28 23:11:58','Manual de manutenção'),(8,'Manutenção de Sistemas de Ventilação','Juliana Rocha','Instruções para a manutenção de sistemas de ventilação:\n\n1. **Limpeza de Dutos**: Realize a limpeza dos dutos de ventilação para evitar acúmulo de sujeira.\n2. **Verificação de Ventiladores**: Inspecione os ventiladores em busca de ruídos anormais e desgaste.\n3. **Troca de Filtros**: Substitua os filtros de ar a cada 3 meses ou conforme necessário.\n4. **Teste de Fluxo de Ar**: Verifique o fluxo de ar em diferentes pontos do sistema para garantir eficiência.\n5. **Inspeção de Sensores**: Verifique o funcionamento dos sensores de temperatura e umidade.','2025-04-28 23:11:58','Manual de manutenção'),(9,'Manutenção de CLPs','Diego Costa','Este manual aborda a manutenção de Controladores Lógicos Programáveis (CLPs):\n\n1. **Verificação de Conexões**: Inspecione as conexões elétricas e de comunicação do CLP.\n2. **Atualização de Firmware**: Mantenha o firmware do CLP atualizado para garantir a segurança e funcionalidade.\n3. **Backup de Programas**: Realize backups regulares dos programas e configurações do CLP.\n4. **Teste de Entradas e Saídas**: Verifique o funcionamento das entradas e saídas digitais e analógicas.\n5. **Inspeção de Fonte de Alimentação**: Verifique a fonte de alimentação do CLP para garantir que esteja operando dentro dos parâmetros especificados.','2025-04-28 23:11:58','Manual de manutenção'),(10,'Manutenção de Esteiras Transportadoras','Larissa Martins','Diretrizes para a manutenção de esteiras transportadoras:\n\n1. **Verificação de Tensionamento**: Ajuste o tensionamento da correia conforme necessário para evitar escorregamentos.\n2. **Inspeção de Rolos**: Verifique os rolos de suporte e de retorno em busca de desgastes ou danos.\n3. **Lubrificação de Mancais**: Aplique lubrificante nos mancais de acordo com as especificações do fabricante.\n4. **Limpeza de Correias**: Mantenha as correias limpas para evitar acúmulo de materiais que possam causar falhas.\n5. **Teste de Sensores de Segurança**: Verifique o funcionamento dos sensores de segurança para garantir a operação segura da esteira.','2025-04-28 23:11:58','Manual de manutenção'),(11,'Manual de Operação de Motores Elétricos','Carlos Braga','Este manual descreve os procedimentos corretos para a operação de motores elétricos:\n\n1. **Partida Direta**: Ligue o motor diretamente na rede elétrica, utilizando contatores adequados. Garanta que a corrente de partida não exceda os limites permitidos pela instalação elétrica.\n2. **Partida Estrela-Triângulo**: Utilize esse método para reduzir a corrente de partida em motores de alta potência. A comutação deve ocorrer após 5 a 10 segundos, conforme a carga.\n3. **Leitura da Placa de Identificação**: Verifique dados como potência, tensão, corrente, fator de serviço e tipo de conexão.\n4. **Controle de Temperatura**: Use sensores térmicos para monitorar o aquecimento dos enrolamentos e do corpo do motor.\n5. **Manutenção Preventiva**: Inclui inspeção de rolamentos, reaperto de conexões e lubrificação periódica.','2025-04-28 23:11:58','Manual de operação'),(12,'Manual de Operação de Transformadores','João Silva','Instruções completas para a operação de transformadores:\n\n1. **Inspeção Visual**: Verifique integridade dos buchas, nível de óleo, presença de vazamentos e estado do isolamento.\n2. **Verificação do Nível de Óleo**: Mantenha o óleo isolante dentro da faixa recomendada. A troca deve ser feita se houver contaminação ou degradação.\n3. **Procedimento de Energização**: Certifique-se de que todos os disjuntores estejam abertos, conecte aterramento temporário e siga a sequência correta de energização.\n4. **Cuidados com Sobreaquecimento**: Utilize sensores ou relés térmicos. O sobreaquecimento pode reduzir drasticamente a vida útil do equipamento.\n5. **Testes de Rotina**: Inclui ensaios de relação de transformação, resistência ôhmica e isolamento.','2025-04-28 23:11:58','Manual de operação'),(13,'Manual de Operação de Geradores','Maria Oliveira','Guia completo para operação segura de geradores:\n\n1. **Verificação Pré-Partida**: Verifique o nível de óleo lubrificante, combustível, água de arrefecimento e o estado dos filtros.\n2. **Partida**: Aqueça o motor se necessário. Após a partida, monitore tensões e frequências.\n3. **Sincronização com a Rede**: Use sincronoscópio ou sistemas automáticos. Corrija defasagens antes de conectar à rede elétrica.\n4. **Operação em Carga**: Evite operar abaixo de 30% da carga nominal por longos períodos. Isso reduz eficiência e pode causar carbonização.\n5. **Desligamento**: Reduza gradualmente a carga e aguarde resfriamento do motor antes de desligar.','2025-04-28 23:11:58','Manual de operação'),(14,'Manual de Operação de Inversores de Frequência','Ana Souza','Manual técnico para uso e configuração de inversores:\n\n1. **Configuração Inicial**: Defina parâmetros como frequência nominal, rampa de aceleração/desaceleração e tipo de controle (V/f ou vetorial).\n2. **Partida e Parada**: Use sinais digitais ou botões físicos. Garanta que o motor esteja livre antes de ligar.\n3. **Monitoramento de Falhas**: Verifique códigos de erro como sobrecorrente, sobretensão ou subfrequência.\n4. **Operação Remota**: Integre com CLPs via Modbus ou outros protocolos industriais.\n5. **Manutenção**: Faça limpeza periódica, inspecione os ventiladores e atualize o firmware se necessário.','2025-04-28 23:11:58','Manual de operação'),(15,'Manual de Operação de Bombas Industriais','Fernando Lima','Procedimentos para operação correta de bombas:\n\n1. **Alinhamento do Conjunto Motor-Bomba**: Use relógio comparador para verificar desalinhamento axial e radial.\n2. **Escorvamento**: Remova o ar da tubulação antes da partida para evitar cavitação.\n3. **Partida**: Ligue o motor com válvulas de recalque parcialmente fechadas.\n4. **Monitoramento**: Verifique pressão de sucção, vibração e ruídos.\n5. **Manutenção**: Lubrifique mancais, substitua selos mecânicos com vazamentos e revise acoplamentos.','2025-04-28 23:11:58','Manual de operação'),(16,'Manual de Operação de Compressores','Paula Mendes','Guia técnico de operação de compressores:\n\n1. **Verificações Antes da Partida**: Confirme nível de óleo, tensão das correias e funcionamento das válvulas de segurança.\n2. **Partida a Frio**: Utilize válvula de alívio para reduzir pressão no arranque.\n3. **Operação**: Mantenha pressão dentro do limite de trabalho. Observe variações anormais de temperatura.\n4. **Drenagem do Reservatório**: Remova água acumulada diariamente para evitar corrosão.\n5. **Manutenção**: Troque filtros regularmente, monitore ruídos e faça testes de eficiência energética.','2025-04-28 23:11:58','Manual de operação'),(17,'Manual de Operação de Painéis Elétricos','Ricardo Alves','Procedimentos para operação segura de painéis:\n\n1. **Identificação de Componentes**: Familiarize-se com disjuntores, contatores, relés térmicos e barramentos.\n2. **Energização Segura**: Siga a sequência correta: aterramento, verificação de tensões e sinalização de área.\n3. **Uso de EPIs**: Inclui luvas isolantes, viseira, vestimenta adequada e calçado com proteção contra arco elétrico.\n4. **Monitoramento**: Use termovisores para detectar pontos de aquecimento.\n5. **Inspeções Periódicas**: Faça reaperto de conexões, limpeza de bornes e testes de continuidade.','2025-04-28 23:11:58','Manual de operação'),(18,'Manual de Operação de Sistemas de Ventilação','Juliana Rocha','Guia de uso eficiente de ventilação industrial:\n\n1. **Verificação de Filtros**: Troque filtros entupidos regularmente para garantir fluxo de ar adequado.\n2. **Ajuste de Dampers**: Regule a distribuição do ar conforme a demanda de cada setor.\n3. **Medição de Vazão**: Use anemômetros e tubos de Pitot para aferição correta.\n4. **Manutenção de Ventiladores**: Lubrifique mancais, inspecione pás e corrija desalinhamentos.\n5. **Controle de Ruído**: Instale silenciadores e mantenha o sistema limpo para evitar ruídos excessivos.','2025-04-28 23:11:58','Manual de operação'),(19,'Manual de Operação de CLPs','Diego Costa','Operação e programação de controladores lógicos programáveis:\n\n1. **Download de Programas**: Utilize software apropriado (ex: TIA Portal, Studio 5000) via cabo USB ou rede.\n2. **Monitoramento Online**: Observe estados das entradas e saídas em tempo real para diagnóstico.\n3. **Criação de Lógicas**: Utilize blocos Ladder, STL ou FBD conforme a aplicação.\n4. **Detecção de Falhas**: Leia códigos de erro na interface HMI ou via supervisório.\n5. **Segurança**: Proteja o acesso com senhas e backups regulares do programa.','2025-04-28 23:11:58','Manual de operação'),(20,'Manual de Operação de Esteiras Transportadoras','Larissa Martins','Procedimentos operacionais para esteiras:\n\n1. **Ajuste de Tensão**: Regule as tensões das correias para garantir operação suave.\n2. **Inspeção de Rolamentos**: Verifique periodicamente o desgaste e a lubrificação.\n3. **Monitoramento de Velocidade**: Utilize sensores de velocidade e ajuste conforme a carga.\n4. **Manutenção Preventiva**: Limpeza periódica de roletes e correias.\n5. **Parada Emergencial**: Verifique se todos os dispositivos de parada estão funcionando corretamente.','2025-04-28 23:11:58','Manual de operação'),(21,'Procedimento de Segurança para Instalação de Equipamentos Elétricos','Carlos Braga','Este manual descreve os procedimentos de segurança para a instalação de equipamentos elétricos:\n\n1. **Desligamento da Energia**: Antes de iniciar qualquer instalação, certifique-se de que a energia está desligada e que o circuito foi adequadamente desenergizado.\n2. **Utilização de EPIs**: Use Equipamentos de Proteção Individual (EPIs) adequados, como luvas isolantes, calçado de segurança, e capacete com proteção contra choque elétrico.\n3. **Verificação de Isolamento**: Certifique-se de que o isolamento dos cabos e conexões esteja em boas condições antes de realizar a instalação.\n4. **Aterramento**: Garanta que o equipamento esteja adequadamente aterrado para evitar riscos de choque elétrico.\n5. **Testes de Segurança**: Após a instalação, realize testes para garantir que não há fuga de corrente e que a instalação está segura.','2025-04-28 23:11:58','Manual de segurança'),(22,'Procedimento de Segurança para Operações com Risco de Choque Elétrico','João Silva','Este manual fornece orientações de segurança para a realização de operações com risco de choque elétrico:\n\n1. **Bloqueio e Etiquetagem**: Utilize sistemas de bloqueio e etiquetagem para garantir que os circuitos estejam desenergizados enquanto o trabalho estiver em andamento.\n2. **Inspeção de Equipamentos de Proteção**: Verifique periodicamente a integridade dos EPIs e equipamentos de segurança, como luvas isolantes e calçados de segurança.\n3. **Treinamento de Funcionários**: Garanta que todos os funcionários sejam treinados em práticas de segurança elétrica, incluindo primeiros socorros em caso de choque.\n4. **Uso de Ferramentas Isoladas**: Utilize ferramentas com isolamento adequado para evitar risco de choque durante a manutenção de sistemas elétricos.\n5. **Procedimento de Resgate**: Tenha um plano de ação para resgatar alguém que tenha sofrido choque elétrico, incluindo o uso de equipamento de resgate e procedimentos de primeiros socorros.','2025-04-28 23:11:58','Manual de segurança'),(23,'Procedimento de Segurança para Trabalhos em Altura','Maria Oliveira','Este manual descreve as práticas de segurança para trabalhos em altura:\n\n1. **Equipamento de Proteção contra Queda**: Utilize cinto de segurança com talabarte, capacete, e outros EPIs necessários.\n2. **Verificação das Estruturas**: Antes de iniciar o trabalho, inspecione as estruturas que serão utilizadas (andaimes, escadas, etc.) para garantir que estejam em boas condições.\n3. **Treinamento e Capacitação**: Todos os trabalhadores devem ser capacitados em técnicas de segurança para trabalhos em altura.\n4. **Procedimento de Evacuação**: Tenha um plano de evacuação de emergência no caso de acidentes durante o trabalho em altura.\n5. **Monitoramento de Condições Climáticas**: Evite realizar trabalhos em altura durante condições climáticas adversas, como ventos fortes ou chuvas.','2025-04-28 23:11:58','Manual de segurança'),(24,'Procedimento de Segurança para Manutenção de Equipamentos Elétricos','Ana Souza','Este manual fornece as orientações de segurança para manutenção de equipamentos elétricos:\n\n1. **Desligamento de Energia**: Sempre desligue a energia antes de realizar qualquer tipo de manutenção em equipamentos elétricos.\n2. **Verificação de Tensão e Corrente**: Antes de manusear qualquer parte do equipamento, utilize um multímetro para garantir que não há presença de tensão.\n3. **Isolamento de Circuitos**: Utilize dispositivos de bloqueio e etiquetagem para garantir que os circuitos permaneçam desenergizados.\n4. **Uso de EPIs Específicos**: Utilize luvas e ferramentas isoladas, além de roupas adequadas para evitar qualquer tipo de choque ou queimadura elétrica.\n5. **Testes Após Manutenção**: Após a manutenção, execute testes para verificar se o equipamento está funcionando corretamente e se todas as proteções estão operando.','2025-04-28 23:11:58','Manual de segurança'),(25,'Procedimento de Segurança para Inspeção de Equipamentos Elétricos','Fernando Lima','Este manual orienta sobre como realizar inspeções de segurança em equipamentos elétricos:\n\n1. **Verificação de Riscos Visuais**: Inspec ione visualmente os equipamentos para verificar sinais de desgaste, aquecimento excessivo ou danos nos fios.\n2. **Medição de Tensão e Corrente**: Utilize instrumentos de medição para garantir que os valores de tensão e corrente estejam dentro das especificações.\n3. **Análise de Equipamentos de Proteção**: Verifique os dispositivos de proteção, como disjuntores e fusíveis, para garantir que estejam em bom estado de funcionamento.\n4. **Verificação de Aterramento**: Certifique-se de que todos os equipamentos estão devidamente aterrados para evitar riscos de choque elétrico.\n5. **Relatórios de Inspeção**: Elabore relatórios detalhados sobre as condições dos equipamentos inspecionados, com recomendações para ações corretivas, se necessário.','2025-04-28 23:11:58','Manual de segurança'),(26,'Procedimento de Segurança para Trabalhos com Máquinas e Equipamentos Perigosos','Paula Mendes','Este manual descreve os procedimentos de segurança para trabalhar com máquinas e equipamentos perigosos:\n\n1. **Desligamento e Bloqueio de Máquinas**: Antes de iniciar qualquer manutenção, garanta que as máquinas estejam desligadas e com sistemas de bloqueio aplicados.\n2. **Treinamento de Operadores**: Todos os operadores devem ser treinados e certificados para operar as máquinas e equipamentos de forma segura.\n3. **Uso de EPIs**: Utilize protetores auriculares, óculos de segurança e vestimentas adequadas para prevenir lesões.\n4. **Procedimentos de Emergência**: Tenha sempre procedimentos de emergência estabelecidos, incluindo a localização de paradas de emergência.\n5. **Inspeção de Máquinas**: Realize inspeções regulares nas máquinas para verificar se há peças danificadas ou defeituosas que possam comprometer a segurança.','2025-04-28 23:11:58','Manual de segurança'),(27,'Procedimento de Segurança para Armazenamento de Materiais Perigosos','Ricardo Alves','Este manual orienta sobre os cuidados necessários para o armazenamento de materiais perigosos:\n\n1. **Armazenamento em Áreas Seguras**: Mantenha materiais perigosos em locais isolados e adequados para evitar riscos à saúde e ao meio ambiente.\n2. **Etiquetagem e Identificação**: Todos os materiais devem ser etiquetados adequadamente, com símbolos de risco e informações sobre o manuseio seguro.\n3. **Equipamentos de Proteção**: Utilize EPIs adequados ao manusear materiais perigosos, como luvas, máscaras e aventais.\n4. **Ventilação Adequada**: As áreas de armazenamento devem ser bem ventiladas para evitar a acumulação de vapores tóxicos ou inflamáveis.\n5. **Plano de Emergência**: Tenha um plano de ação em caso de derramamento ou acidente envolvendo materiais perigosos.','2025-04-28 23:11:58','Manual de segurança'),(28,'Procedimento de Segurança em Sistemas de Iluminação de Emergência','Juliana Rocha','Este manual descreve as práticas de segurança para o uso e manutenção de sistemas de iluminação de emergência:\n\n1. **Verificação de Funcionalidade**: Teste regularmente as luzes de emergência para garantir que estão funcionando adequadamente.\n2. **Manutenção de Baterias**: Verifique o estado das baterias, substituindo-as quando necessário para evitar falhas no sistema.\n3. **Procedimentos de Emergência**: Em caso de falha no sistema de iluminação, siga o procedimento de emergência para reativação.\n4. **Inspeção Visual**: Realize inspeções visuais nos dispositivos de iluminação para verificar se há falhas, danos ou sujeira nos equipamentos.\n5. **Documentação de Manutenção**: Registre todas as atividades de manutenção e testes realizados no sistema de iluminação de emergência.','2025-04-28 23:11:58','Manual de segurança'),(29,'Procedimento de Segurança para Trabalhos com Substâncias Químicas','Diego Costa','Este manual orienta sobre a segurança no manuseio de substâncias químicas:\n\n1. **Utilização de EPIs Específicos**: Use luvas, máscaras e vestimentas adequadas ao manusear substâncias químicas.\n2. **Armazenamento Adequado**: Armazene as substâncias químicas em locais adequados, conforme as instruções do fabricante e normas de segurança.\n3. **Ventilação Adequada**: Trabalhe em áreas bem ventiladas para evitar a inalação de vapores ou gases tóxicos.\n4. **Plano de Emergência**: Tenha sempre um plano de ação para casos de vazamento ou acidente químico.\n5. **Treinamento de Funcionários**: Capacite os funcionários sobre os riscos e procedimentos de segurança relacionados às substâncias químicas que manipulam.','2025-04-28 23:11:58','Manual de segurança'),(30,'Procedimento de Segurança para Uso de Equipamentos de Proteção Individual','Larissa Martins','Este manual descreve os cuidados necessários ao usar Equipamentos de Proteção Individual (EPIs):\n\n1. **Seleção de EPIs Adequados**: Escolha os EPIs de acordo com os riscos presentes no ambiente de trabalho.\n2. **Treinamento no Uso**: Todos os funcionários devem ser treinados sobre como utilizar corretamente os EPIs.\n3. **Verificação de Condições**: Antes de usar os EPIs, verifique se estão em boas condições de uso.\n4. **Manutenção e Substituição**: Realize manutenção periódica nos EPIs e substitua-os quando estiverem desgastados ou danificados.\n5. **Documentação**: Mantenha registros sobre os EPIs fornecidos aos funcionários e treinamentos realizados.','2025-04-28 23:11:58','Manual de segurança'),(31,'Conduta no Setor de Montagem','Ana Paula','Orientações sobre a conduta no setor de montagem:\n\n1. **Uso de Equipamentos de Proteção Individual (EPIs)**: Todos os colaboradores devem utilizar EPIs adequados, como capacetes, luvas e óculos de proteção.\n2. **Organização do Espaço de Trabalho**: Mantenha a área de montagem limpa e organizada para evitar acidentes.\n3. **Comunicação Clara**: Utilize sinais visuais e verbais para garantir que todos os membros da equipe estejam cientes das atividades em andamento.\n4. **Verificação de Ferramentas**: Antes de iniciar o trabalho, verifique se todas as ferramentas estão em boas condições e disponíveis.\n5. **Treinamento Contínuo**: Participe de treinamentos regulares para se manter atualizado sobre as melhores práticas e procedimentos.','2025-04-28 23:11:58','Manual de conduta operacional'),(32,'Procedimentos Operacionais no Setor de Manutenção','Ricardo Alves','Orientações para procedimentos operacionais no setor de manutenção:\n\n1. **Planejamento de Manutenção**: Realize um planejamento detalhado das atividades de manutenção, incluindo cronogramas e recursos necessários.\n2. **Registro de Atividades**: Documente todas as atividades de manutenção realizadas, incluindo problemas encontrados e soluções aplicadas.\n3. **Segurança em Primeiro Lugar**: Sempre desligue os equipamentos antes de realizar qualquer manutenção e utilize EPIs adequados.\n4. **Inspeções Regulares**: Realize inspeções periódicas nos equipamentos para identificar possíveis falhas antes que se tornem críticas.\n5. **Colaboração em Equipe**: Trabalhe em conjunto com outros membros da equipe para garantir que as manutenções sejam realizadas de forma eficiente.','2025-04-28 23:11:58','Manual de conduta operacional'),(33,'Processos no Setor de Controle de Qualidade','Fernanda Lima','Orientações sobre os processos no setor de controle de qualidade:\n\n1. **Verificação de Materiais**: Realize a inspeção de todos os materiais recebidos para garantir que atendam aos padrões de qualidade.\n2. **Testes de Produto**: Execute testes de qualidade em produtos acabados, seguindo os procedimentos estabelecidos.\n3. **Documentação de Resultados**: Registre todos os resultados dos testes e inspeções em relatórios de qualidade.\n4. **Feedback para Produção**: Forneça feedback à equipe de produção sobre quaisquer não conformidades encontradas durante as inspeções.\n5. **Treinamento em Qualidade**: Participe de treinamentos sobre normas de qualidade e melhores práticas para garantir a conformidade.','2025-04-28 23:11:58','Manual de conduta operacional'),(34,'Diretrizes para o Setor de Logística','Gustavo Pereira','Diretrizes de conduta e operação no setor de logística:\n\n1. **Organização do Armazém**: Mantenha o armazém organizado e sinalizado para facilitar a movimentação e o acesso aos materiais.\n2. **Embalagem e Transporte Seguros**: Utilize embalagens adequadas e siga os procedimentos de transporte para evitar danos aos produtos.\n3. **Controle de Estoque**: Realize inventários regulares e mantenha um controle preciso do estoque para evitar perdas e garantir a disponibilidade dos materiais.\n4. **Comunicação com Fornecedores e Clientes**: Mantenha uma comunicação clara e eficiente com fornecedores e clientes sobre prazos e entregas.\n5. **Utilização de Sistemas de Gestão**: Utilize os sistemas de gestão de logística para otimizar processos e rastrear envios.','2025-04-28 23:11:58','Manual de conduta operacional'),(35,'Normas de Segurança no Setor de Produção','Mariana Costa','Normas de segurança a serem seguidas no setor de produção:\n\n1. **Utilização Obrigatória de EPIs**: É obrigatório o uso de todos os EPIs especificados para cada função.\n2. **Procedimentos de Bloqueio e Etiquetagem (Lockout/Tagout)**: Siga rigorosamente os procedimentos de bloqueio e etiquetagem antes de qualquer intervenção em equipamentos.\n3. **Prevenção de Incêndios**: Conheça a localização dos extintores e os procedimentos em caso de incêndio.\n4. **Manuseio Seguro de Produtos Químicos**: Utilize os equipamentos de proteção adequados e siga as instruções de manuseio de produtos químicos.\n5. **Primeiros Socorros**: Esteja ciente dos procedimentos de primeiros socorros e da localização dos materiais de emergência.','2025-04-28 23:11:58','Manual de conduta operacional'),(36,'Padrões de Atendimento ao Cliente','Roberto Souza','Padrões de conduta para o atendimento ao cliente:\n\n1. **Cordialidade e Respeito**: Trate todos os clientes com cordialidade e respeito.\n2. **Comunicação Eficaz**: Comunique-se de forma clara, objetiva e atenciosa com os clientes.\n3. **Resolução de Problemas**: Esforce-se para resolver os problemas dos clientes de forma rápida e eficiente.\n4. **Conhecimento do Produto/Serviço**: Tenha um bom conhecimento dos produtos ou serviços oferecidos para poder auxiliar os clientes adequadamente.\n5. **Registro de Interações**: Registre todas as interações com os clientes para acompanhamento e melhoria contínua.','2025-04-28 23:11:58','Manual de conduta operacional'),(37,'Boas Práticas no Setor de Tecnologia da Informação (TI)','Juliana Oliveira','Diretrizes e boas práticas para o setor de TI:\n\n1. **Segurança da Informação**: Siga as políticas de segurança da informação para proteger dados e sistemas.\n2. **Uso Responsável de Recursos**: Utilize os recursos de TI de forma responsável e eficiente.\n3. **Manutenção de Equipamentos**: Mantenha os equipamentos de informática em bom estado de conservação.\n4. **Suporte Técnico Eficiente**: Preste suporte técnico de forma ágil e eficaz aos usuários.\n5. **Backup e Recuperação de Dados**: Realize backups regulares dos dados e esteja preparado para processos de recuperação em caso de falhas.','2025-04-28 23:11:58','Manual de conduta operacional'),(38,'Procedimentos para o Setor de Compras','Lucas Martins','Procedimentos operacionais para o setor de compras:\n\n1. **Cotação de Preços**: Obtenha cotações de diferentes fornecedores para garantir o melhor custo-benefício.\n2. **Seleção de Fornecedores**: Selecione fornecedores com base em critérios de qualidade, preço e prazo de entrega.\n3. **Emissão de Pedidos**: Emita pedidos de compra claros e detalhados.\n4. **Acompanhamento de Entregas**: Acompanhe as entregas para garantir que os materiais cheguem no prazo e em boas condições.\n5. **Gestão de Pagamentos**: Realize os pagamentos aos fornecedores de acordo com os termos acordados.','2025-04-28 23:11:58','Manual de conduta operacional'),(39,'Diretrizes para o Setor de Recursos Humanos (RH)','Camila Rocha','Diretrizes de conduta e operação para o setor de RH:\n\n1. **Processo de Recrutamento e Seleção**: Siga os procedimentos estabelecidos para o recrutamento e seleção de novos colaboradores.\n2. **Gestão de Desempenho**: Realize avaliações de desempenho periódicas e forneça feedback aos colaboradores.\n3. **Treinamento e Desenvolvimento**: Identifique as necessidades de treinamento e desenvolvimento dos colaboradores e ofereça programas adequados.\n4. **Administração de Pessoal**: Gerencie a folha de pagamento, benefícios e outras questões administrativas de forma precisa e eficiente.\n5. **Comunicação Interna**: Promova uma comunicação interna clara e transparente entre a empresa e os colaboradores.','2025-04-28 23:11:58','Manual de conduta operacional'),(40,'Normas e Procedimentos do Setor Financeiro','Thiago Santos','Normas e procedimentos a serem seguidos no setor financeiro:\n\n1. **Controle de Fluxo de Caixa**: Monitore e controle o fluxo de caixa da empresa.\n2. **Gestão de Contas a Pagar e a Receber**: Gerencie as contas a pagar e a receber de forma organizada.\n3. **Elaboração de Relatórios Financeiros**: Elabore relatórios financeiros precisos e regulares.\n4. **Planejamento Orçamentário**: Participe do processo de planejamento orçamentário da empresa.\n5. **Conformidade Fiscal**: Garanta a conformidade com todas as obrigações fiscais e tributárias.','2025-04-28 23:11:58','Manual de conduta operacional'),(41,'Testes de Funcionamento de Motores Elétricos','Carlos Braga','Procedimentos para testar o funcionamento de motores elétricos:\n\n1. **Teste de Isolamento**: Utilize um megômetro para verificar a resistência de isolamento dos enrolamentos.\n2. **Teste de Corrente**: Monitore a corrente de operação e compare com os valores da placa de identificação.\n3. **Teste de Vibração**: Use um medidor de vibração para identificar possíveis desalinhamentos ou desgastes.\n4. **Teste de Temperatura**: Monitore a temperatura do motor durante a operação para evitar superaquecimento.\n5. **Teste de Ruído**: Escute por ruídos anormais que possam indicar problemas mecânicos.','2025-04-28 23:11:58','Manual de diagnósticos'),(42,'Diagnóstico de Falhas em Sistemas de Automação','João Silva','Métodos para diagnosticar falhas em sistemas de automação:\n\n1. **Verificação de Conexões**: Inspecione todas as conexões elétricas e de comunicação.\n2. **Teste de Entradas e Saídas**: Utilize um multímetro para verificar se as entradas e saídas estão funcionando corretamente.\n3. **Análise de Códigos de Erro**: Consulte o manual do sistema para entender os códigos de erro exibidos.\n4. **Monitoramento de Sinais**: Use um osciloscópio para verificar a integridade dos sinais de controle.\n5. **Teste de Lógica de Controle**: Verifique se a lógica programada está funcionando conforme o esperado.','2025-04-28 23:11:58','Manual de diagnósticos'),(43,'Testes de Funcionamento de Geradores','Maria Oliveira','Procedimentos para testar geradores:\n\n1. **Teste de Partida**: Verifique se o gerador inicia corretamente e sem falhas.\n2. **Teste de Sincronização**: Confirme a sincronização com a rede elétrica usando um sincronoscópio.\n3. **Teste de Carga**: Aplique carga ao gerador e monitore a tensão e a frequência.\n4. **Teste de Ruído**: Escute por ruídos anormais durante a operação.\n5. **Teste de Temperatura**: Monitore a temperatura do motor e do sistema de arrefecimento.','2025-04-28 23:11:58','Manual de diagnósticos'),(44,'Diagnóstico de Falhas em Inversores de Frequência','Ana Souza','Métodos para diagnosticar falhas em inversores:\n\n1. **Verificação de Códigos de Erro**: Consulte o manual para entender os códigos de erro exibidos.\n2. **Teste de Saída**: Meça a tensão e a frequência na saída do inversor.\n3. **Teste de Temperatura**: Monitore a temperatura do inversor durante a operação.\n4. **Inspeção Visual**: Verifique se há sinais de danos físicos ou componentes queimados.\n5. **Teste de Comunicação**: Verifique a comunicação com CLPs ou outros dispositivos.','2025-04-28 23:11:58','Manual de diagnósticos'),(45,'Testes de Funcionamento de Bombas','Fernando Lima','Procedimentos para testar o funcionamento de bombas:\n\n1. **Teste de Pressão**: Monitore a pressão de saída durante a operação.\n2. **Teste de Vazão**: Utilize um medidor de vazão para verificar a eficiência da bomba.\n3. **Teste de Ruído**: Escute por ruídos anormais que possam indicar problemas mecânicos.\n4. **Teste de Temperatura**: Monitore a temperatura do motor e do fluido bombeado.\n5. **Verificação de Válvulas**: Inspecione o funcionamento correto das válvulas de entrada e saída.','2025-04-28 23:11:58','Manual de diagnósticos'),(46,'Diagnóstico de Problemas em Redes Industriais','Mariana Alves','Procedimentos para diagnosticar problemas em redes industriais:\n\n1. **Teste de Conectividade**: Utilize ferramentas de ping e traceroute para verificar a comunicação entre dispositivos.\n2. **Análise de Tráfego**: Monitore o tráfego da rede com um analisador de protocolos (sniffer).\n3. **Verificação de Configurações IP**: Certifique-se de que os endereços IP e as máscaras de sub-rede estão corretos.\n4. **Inspeção de Cabos e Conectores**: Verifique se há danos físicos nos cabos e se os conectores estão bem encaixados.\n5. **Análise de Logs de Dispositivos**: Consulte os logs de switches, roteadores e outros dispositivos de rede para identificar erros.','2025-04-28 23:11:58','Manual de diagnósticos'),(47,'Testes em Sistemas de Lubrificação','Pedro Santos','Procedimentos para testar sistemas de lubrificação:\n\n1. **Verificação do Nível de Lubrificante**: Monitore o nível de óleo ou graxa nos reservatórios.\n2. **Inspeção de Vazamentos**: Verifique se há vazamentos nas conexões, mangueiras e selos.\n3. **Análise da Qualidade do Lubrificante**: Colete amostras para verificar a viscosidade e a contaminação.\n4. **Teste de Pressão do Sistema**: Monitore a pressão do lubrificante durante a operação.\n5. **Verificação de Bomba e Filtros**: Inspecione o funcionamento da bomba de lubrificação e a condição dos filtros.','2025-04-28 23:11:58','Manual de diagnósticos'),(48,'Diagnóstico de Falhas em Sistemas Hidráulicos','Laura Gomes','Métodos para diagnosticar falhas em sistemas hidráulicos:\n\n1. **Inspeção de Vazamentos**: Verifique todas as conexões, mangueiras, cilindros e válvulas em busca de vazamentos de fluido.\n2. **Teste de Pressão**: Utilize manômetros para verificar a pressão em diferentes pontos do sistema.\n3. **Verificação de Nível de Fluido**: Mantenha o nível de fluido hidráulico dentro das especificações.\n4. **Análise de Ruídos Anormais**: Escute por ruídos incomuns que possam indicar cavitação ou outros problemas.\n5. **Teste de Atuadores**: Verifique o funcionamento correto de cilindros e motores hidráulicos.','2025-04-28 23:11:58','Manual de diagnósticos'),(49,'Testes em Sistemas de Ventilação e Exaustão','Rafael Nunes','Procedimentos para testar sistemas de ventilação e exaustão:\n\n1. **Medição de Vazão de Ar**: Utilize anemômetros para verificar a vazão do ar nos dutos e aberturas.\n2. **Inspeção de Filtros**: Verifique a condição dos filtros e realize a limpeza ou substituição conforme necessário.\n3. **Teste de Funcionamento de Ventiladores e Exaustores**: Verifique se os equipamentos ligam e operam corretamente.\n4. **Verificação de Dutos e Conexões**: Inspecione os dutos em busca de obstruções ou danos e verifique a integridade das conexões.\n5. **Teste de Vedação**: Verifique a vedação de portas e janelas para garantir a eficiência do sistema.','2025-04-28 23:11:58','Manual de diagnósticos'),(50,'Diagnóstico de Problemas em Instrumentação Industrial','Sofia Castro','Métodos para diagnosticar problemas em instrumentos industriais:\n\n1. **Calibração de Sensores e Transmissores**: Verifique e ajuste a calibração dos instrumentos conforme as especificações.\n2. **Teste de Sinal de Saída**: Meça o sinal de saída dos instrumentos para verificar sua precisão.\n3. **Verificação de Conexões Elétricas**: Inspecione as conexões elétricas dos instrumentos em busca de mau contato ou falhas.\n4. **Análise de Leituras Inconsistentes**: Investigue leituras inesperadas ou inconsistentes dos instrumentos.\n5. **Substituição e Teste de Componentes**: Se necessário, substitua componentes defeituosos e teste o funcionamento do instrumento.','2025-04-28 23:11:58','Manual de diagnósticos');
/*!40000 ALTER TABLE `manuais` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_atualiza_data` BEFORE UPDATE ON `manuais` FOR EACH ROW BEGIN
    SET NEW.dataDePublicacao = CURRENT_TIMESTAMP;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login` varchar(50) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `tipo` enum('viewer','user','adm') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'joao','senha123','viewer'),(2,'maria','senha456','user'),(3,'admin','senha789','adm');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_manuais_completos`
--

DROP TABLE IF EXISTS `view_manuais_completos`;
/*!50001 DROP VIEW IF EXISTS `view_manuais_completos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_manuais_completos` AS SELECT 
 1 AS `id_manual`,
 1 AS `titulo`,
 1 AS `autor`,
 1 AS `texto`,
 1 AS `dataDePublicacao`,
 1 AS `tipoManual`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_manuais_por_tipo`
--

DROP TABLE IF EXISTS `view_manuais_por_tipo`;
/*!50001 DROP VIEW IF EXISTS `view_manuais_por_tipo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_manuais_por_tipo` AS SELECT 
 1 AS `tipoManual`,
 1 AS `quantidade`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_manuais_recentes`
--

DROP TABLE IF EXISTS `view_manuais_recentes`;
/*!50001 DROP VIEW IF EXISTS `view_manuais_recentes`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_manuais_recentes` AS SELECT 
 1 AS `id_manual`,
 1 AS `titulo`,
 1 AS `autor`,
 1 AS `dataDePublicacao`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_manuais_resumo`
--

DROP TABLE IF EXISTS `view_manuais_resumo`;
/*!50001 DROP VIEW IF EXISTS `view_manuais_resumo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_manuais_resumo` AS SELECT 
 1 AS `id_manual`,
 1 AS `titulo`,
 1 AS `autor`,
 1 AS `tipoManual`,
 1 AS `dataDePublicacao`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_usuarios_por_tipo`
--

DROP TABLE IF EXISTS `view_usuarios_por_tipo`;
/*!50001 DROP VIEW IF EXISTS `view_usuarios_por_tipo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_usuarios_por_tipo` AS SELECT 
 1 AS `tipo`,
 1 AS `quantidade`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'wegone'
--

--
-- Dumping routines for database 'wegone'
--
/*!50003 DROP FUNCTION IF EXISTS `BuscarAutorPorTitulo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `BuscarAutorPorTitulo`(
    p_titulo VARCHAR(100)
) RETURNS varchar(100) CHARSET utf8mb4
    READS SQL DATA
    DETERMINISTIC
BEGIN
    DECLARE v_autor VARCHAR(100);

    SELECT autor
    INTO v_autor
    FROM manuais
    WHERE titulo = p_titulo
    LIMIT 1;

    RETURN v_autor;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `ContarManuaisPorTipo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `ContarManuaisPorTipo`(
    p_tipoManual ENUM('Manual de conduta operacional', 'Manual de diagnósticos', 'Manual de manutenção', 'Manual de operação', 'Manual de segurança')
) RETURNS int
    READS SQL DATA
    DETERMINISTIC
BEGIN
    DECLARE qtd INT;

    SELECT COUNT(*)
    INTO qtd
    FROM manuais
    WHERE tipoManual = p_tipoManual;

    RETURN qtd;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `ValidarLoginUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `ValidarLoginUsuario`(
    p_login VARCHAR(50)
) RETURNS enum('viewer','user','adm') CHARSET utf8mb4
    READS SQL DATA
    DETERMINISTIC
BEGIN
    DECLARE v_tipo ENUM('viewer', 'user', 'adm');

    SELECT tipo
    INTO v_tipo
    FROM usuarios
    WHERE login = p_login
    LIMIT 1;

    RETURN v_tipo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `AdicionarManual` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `AdicionarManual`(
    IN p_titulo VARCHAR(100),
    IN p_autor VARCHAR(100),
    IN p_texto TEXT,
    IN p_tipoManual ENUM('Manual de conduta operacional', 'Manual de diagnósticos', 'Manual de manutenção', 'Manual de operação', 'Manual de segurança')
)
BEGIN
    INSERT INTO manuais (titulo, autor, texto, tipoManual)
    VALUES (p_titulo, p_autor, p_texto, p_tipoManual);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `BuscarManuaisPorTipo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `BuscarManuaisPorTipo`(
    IN p_tipoManual ENUM('Manual de conduta operacional', 'Manual de diagnósticos', 'Manual de manutenção', 'Manual de operação', 'Manual de segurança')
)
BEGIN
    SELECT id_manual, titulo, autor, dataDePublicacao
    FROM manuais
    WHERE tipoManual = p_tipoManual;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `EditarManual` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `EditarManual`(
    IN p_id_manual INT,
    IN p_texto TEXT,
    IN p_tipoManual ENUM('Manual de conduta operacional', 'Manual de diagnósticos', 'Manual de manutenção', 'Manual de operação', 'Manual de segurança')
)
BEGIN
    UPDATE manuais
    SET texto = p_texto,
        tipoManual = p_tipoManual
    WHERE id_manual = p_id_manual;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ListarUsuarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ListarUsuarios`()
BEGIN
    SELECT id, login, tipo
    FROM usuarios;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `RemoverManual` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `RemoverManual`(
    IN p_id_manual INT
)
BEGIN
    DELETE FROM manuais
    WHERE id_manual = p_id_manual;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `view_manuais_completos`
--

/*!50001 DROP VIEW IF EXISTS `view_manuais_completos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_manuais_completos` AS select `manuais`.`id_manual` AS `id_manual`,`manuais`.`titulo` AS `titulo`,`manuais`.`autor` AS `autor`,`manuais`.`texto` AS `texto`,`manuais`.`dataDePublicacao` AS `dataDePublicacao`,`manuais`.`tipoManual` AS `tipoManual` from `manuais` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_manuais_por_tipo`
--

/*!50001 DROP VIEW IF EXISTS `view_manuais_por_tipo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_manuais_por_tipo` AS select `manuais`.`tipoManual` AS `tipoManual`,count(0) AS `quantidade` from `manuais` group by `manuais`.`tipoManual` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_manuais_recentes`
--

/*!50001 DROP VIEW IF EXISTS `view_manuais_recentes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_manuais_recentes` AS select `manuais`.`id_manual` AS `id_manual`,`manuais`.`titulo` AS `titulo`,`manuais`.`autor` AS `autor`,`manuais`.`dataDePublicacao` AS `dataDePublicacao` from `manuais` where (`manuais`.`dataDePublicacao` >= (now() - interval 30 day)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_manuais_resumo`
--

/*!50001 DROP VIEW IF EXISTS `view_manuais_resumo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_manuais_resumo` AS select `manuais`.`id_manual` AS `id_manual`,`manuais`.`titulo` AS `titulo`,`manuais`.`autor` AS `autor`,`manuais`.`tipoManual` AS `tipoManual`,`manuais`.`dataDePublicacao` AS `dataDePublicacao` from `manuais` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_usuarios_por_tipo`
--

/*!50001 DROP VIEW IF EXISTS `view_usuarios_por_tipo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_usuarios_por_tipo` AS select `usuarios`.`tipo` AS `tipo`,count(0) AS `quantidade` from `usuarios` group by `usuarios`.`tipo` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-28 21:54:32