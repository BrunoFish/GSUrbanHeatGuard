import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlertaService servico = new AlertaService();

        // ==========================================
        // DADOS MOCKADOS (Para facilitar os testes)
        // ==========================================
        RegiaoUrbana regiao1 = new RegiaoUrbana(1, "Centro de São Paulo", -23.5505, -46.6333, 5000);
        Sensor sensor1 = new Sensor(1, regiao1, "Drone Termal", LocalDate.now());
        servico.cadastrarRegiao(regiao1);
        servico.cadastrarSensor(sensor1);
        
        // Simulando algumas leituras iniciais
        servico.registrarLeituraTemperatura(sensor1, 28.5); 
        servico.registrarLeituraTemperatura(sensor1, 39.0); 
        System.out.println("---------------------------------------------------");

        int opcao = 0;

        // ==========================================
        // MENU INTERATIVO (Console)
        // ==========================================
        while (opcao != 5) {
            System.out.println("\n=== URBANHEAT GUARD - PAINEL DE CONTROLE ===");
            System.out.println("1. Cadastrar nova Região");
            System.out.println("2. Cadastrar novo Sensor");
            System.out.println("3. Registrar Leitura de Temperatura (Simular Alerta)");
            System.out.println("4. Gerar Relatório de Alertas Críticos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID da Região: ");
                    int idReg = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Nome do Local (Ex: Bairro Liberdade): ");
                    String nome = scanner.nextLine();
                    
                    System.out.print("Latitude (Ex: -23.55): ");
                    double lat = scanner.nextDouble();
                    
                    System.out.print("Longitude (Ex: -46.63): ");
                    double lon = scanner.nextDouble();
                    
                    System.out.print("Raio de Abrangência (em metros): ");
                    int raio = scanner.nextInt();

                    RegiaoUrbana novaRegiao = new RegiaoUrbana(idReg, nome, lat, lon, raio);
                    servico.cadastrarRegiao(novaRegiao);
                    break;

                case 2:
                    if (servico.getRegioes().isEmpty()) {
                        System.out.println("Erro: Cadastre uma Região primeiro!");
                        break;
                    }
                    
                    // 1. Listar as regiões disponíveis
                    System.out.println("\n--- Regiões Disponíveis ---");
                    for (int i = 0; i < servico.getRegioes().size(); i++) {
                        System.out.println(i + " - " + servico.getRegioes().get(i).getNomeLocal());
                    }
                    
                    // 2. Pedir para o usuário escolher
                    System.out.print("Escolha o número da Região para instalar o sensor: ");
                    int indiceRegiao = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    
                    // Validação de segurança
                    if (indiceRegiao < 0 || indiceRegiao >= servico.getRegioes().size()) {
                        System.out.println("Erro: Opção inválida!");
                        break;
                    }
                    
                    // 3. Capturar a região escolhida
                    RegiaoUrbana regiaoAlvo = servico.getRegioes().get(indiceRegiao);
                    
                    // 4. Continuar com o cadastro do sensor
                    System.out.print("Digite o ID do Sensor: ");
                    int idSen = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Tipo de Sensor (Ex: Satélite, Drone): ");
                    String tipo = scanner.nextLine();
                    
                    Sensor novoSensor = new Sensor(idSen, regiaoAlvo, tipo, LocalDate.now());
                    servico.cadastrarSensor(novoSensor);
                    System.out.println("Sucesso! Sensor cadastrado na região: " + regiaoAlvo.getNomeLocal());
                    break;

                case 3:
                    if (servico.getSensores().isEmpty()) {
                        System.out.println("Erro: Cadastre um Sensor primeiro!");
                        break;
                    }
                    
                    // 1. Listar os sensores disponíveis
                    System.out.println("\n--- Sensores Disponíveis ---");
                    for (int i = 0; i < servico.getSensores().size(); i++) {
                        // Supondo que a classe Sensor tenha getId() e getTipo()
                        System.out.println(i + " - Sensor ID " + servico.getSensores().get(i).getIdSensor() + " (" + servico.getSensores().get(i).getTipoSensor() + ")");
                    }
                    
                    // 2. Pedir para o usuário escolher
                    System.out.print("Escolha o número do Sensor que capturou a temperatura: ");
                    int indiceSensor = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    
                    // Validação de segurança
                    if (indiceSensor < 0 || indiceSensor >= servico.getSensores().size()) {
                        System.out.println("Erro: Opção inválida!");
                        break;
                    }
                    
                    // 3. Capturar o sensor escolhido
                    Sensor sensorAlvo = servico.getSensores().get(indiceSensor);
                    
                    // 4. Registrar a leitura
                    System.out.print("Digite a temperatura capturada (°C): ");
                    double temp = scanner.nextDouble();
                    scanner.nextLine(); // Limpa o buffer
                    
                    servico.registrarLeituraTemperatura(sensorAlvo, temp);
                    System.out.println("Leitura de " + temp + "°C registrada com sucesso no Sensor ID " + sensorAlvo.getIdSensor() + "!");
                    break;

                case 4:
                    servico.listarAlertasCriticos();
                    break;

                case 5:
                    System.out.println("Encerrando o sistema UrbanHeat Guard... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}