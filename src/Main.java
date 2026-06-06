import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonitoramentoService servico = new MonitoramentoService();

        // --- DADOS MOCKADOS (Para simular os dados sem banco) ---
        RegiaoUrbana regiao1 = new RegiaoUrbana(1, "Centro de São Paulo", 5000, LocalDate.now());
        regiao1.adicionarPonto(new PontoPoligono(1, regiao1, 1, -23.5505, -46.6333));
        regiao1.adicionarPonto(new PontoPoligono(2, regiao1, 2, -23.5510, -46.6340));
        regiao1.adicionarPonto(new PontoPoligono(3, regiao1, 3, -23.5490, -46.6320));
        servico.cadastrarRegiao(regiao1);

        Equipamento eqp1 = new Equipamento(1, regiao1, "Satélite Termal", "Ativo");
        servico.cadastrarEquipamento(eqp1);
        
        servico.registrarLeituraTemperatura(eqp1, 28.5); 
        servico.registrarLeituraTemperatura(eqp1, 39.0); 
        System.out.println("---------------------------------------------------");

        int opcao = 0;

        // --- MENU INTERATIVO ---
        while (opcao != 6) {
            System.out.println("\n=== URBANHEAT GUARD - PAINEL DE CONTROLE ===");
            System.out.println("1. Cadastrar nova Região (com Polígono)");
            System.out.println("2. Cadastrar novo Equipamento");
            System.out.println("3. Atualizar Status de Equipamento");
            System.out.println("4. Registrar Leitura Térmica");
            System.out.println("5. Gerar Relatório de Alertas Críticos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("ID da Região: ");
                    int idReg = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do Local: ");
                    String nome = scanner.nextLine();
                    System.out.print("Raio de Abrangência (em metros): ");
                    int raio = scanner.nextInt();

                    RegiaoUrbana novaRegiao = new RegiaoUrbana(idReg, nome, raio, LocalDate.now());
                    
                    System.out.print("Quantos pontos (coordenadas) formam o polígono desta área? ");
                    int qtdPontos = scanner.nextInt();
                    
                    for (int i = 1; i <= qtdPontos; i++) {
                        System.out.print("Latitude do Ponto " + i + ": ");
                        double lat = scanner.nextDouble();
                        System.out.print("Longitude do Ponto " + i + ": ");
                        double lon = scanner.nextDouble();
                        novaRegiao.adicionarPonto(new PontoPoligono(i, novaRegiao, i, lat, lon));
                    }
                    scanner.nextLine();

                    servico.cadastrarRegiao(novaRegiao);
                    break;

                case 2:
                    if (servico.getRegioes().isEmpty()) {
                        System.out.println("Erro: Cadastre uma Região primeiro!");
                        break;
                    }
                    
                    System.out.println("\n--- Regiões Disponíveis ---");
                    for (int i = 0; i < servico.getRegioes().size(); i++) {
                        System.out.println(i + " - " + servico.getRegioes().get(i).getNomeLocal());
                    }
                    System.out.print("Escolha o número da Região: ");
                    int indiceRegiao = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (indiceRegiao < 0 || indiceRegiao >= servico.getRegioes().size()) {
                        System.out.println("Erro: Opção inválida!");
                        break;
                    }
                    
                    System.out.print("ID do Equipamento: ");
                    int idEqp = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipo (Satélite, Drone, Estação): ");
                    String tipo = scanner.nextLine();
                    
                    Equipamento novoEqp = new Equipamento(idEqp, servico.getRegioes().get(indiceRegiao), tipo, "Ativo");
                    servico.cadastrarEquipamento(novoEqp);
                    break;

                case 3:
                    System.out.print("Digite o ID do Equipamento para atualizar o status: ");
                    int idBusca = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo status (Ex: Em Manutenção, Inativo, Ativo): ");
                    String novoStatus = scanner.nextLine();
                    servico.atualizarStatusEquipamento(idBusca, novoStatus);
                    break;

                case 4:
                    if (servico.getEquipamentos().isEmpty()) {
                        System.out.println("Erro: Cadastre um Equipamento primeiro!");
                        break;
                    }
                    
                    System.out.println("\n--- Equipamentos ---");
                    for (int i = 0; i < servico.getEquipamentos().size(); i++) {
                        System.out.println(i + " - ID: " + servico.getEquipamentos().get(i).getIdEquipamento() + " (" + servico.getEquipamentos().get(i).getTipoEquipamento() + ")");
                    }
                    System.out.print("Escolha o número do Equipamento: ");
                    int indiceEqp = scanner.nextInt();
                    
                    if (indiceEqp < 0 || indiceEqp >= servico.getEquipamentos().size()) {
                        System.out.println("Erro: Opção inválida!");
                        break;
                    }
                    
                    System.out.print("Temperatura capturada (°C): ");
                    double temp = scanner.nextDouble();
                    
                    servico.registrarLeituraTemperatura(servico.getEquipamentos().get(indiceEqp), temp);
                    break;

                case 5:
                    servico.listarAlertasCriticos();
                    break;

                case 6:
                    System.out.println("Encerrando o sistema UrbanHeat Guard... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}